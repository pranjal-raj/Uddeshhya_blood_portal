package com.example.uddeshhyabloodportal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.uddeshhyabloodportal.databinding.ActivitySearchDonorBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class searchDonor : AppCompatActivity() {
    lateinit var binding: ActivitySearchDonorBinding
    lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySearchDonorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchBtn.setOnClickListener {
            val bloodgrouptext:String = binding.searchText.text.toString()
            if (bloodgrouptext.isNotEmpty()){
                readData(bloodgrouptext)
            }else{
                Toast.makeText(this,"enter value",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(bloodgrouptext: String) {
        database=FirebaseDatabase.getInstance().getReference("Donors")
        database.child(bloodgrouptext).get().addOnSuccessListener {
            if(it.exists()){
                val name = it.child("fullName").value
                val email = it.child("email").value
                val phonenumber = it.child("mobileNo").value
                Toast.makeText(this,"successfully Read",Toast.LENGTH_SHORT).show()

                binding.nameView.text = name.toString()
                binding.emailView.text = email.toString()
                binding.phNo.text = phonenumber.toString()

            }else{
                Toast.makeText(this,"user doesnt exist",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener{
            Toast.makeText(this,"failed",Toast.LENGTH_SHORT).show()

        }
    }
}
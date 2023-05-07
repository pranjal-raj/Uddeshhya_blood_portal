package com.example.uddeshhyabloodportal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.uddeshhyabloodportal.databinding.ActivityDonorRegistrationBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class donorRegistration : AppCompatActivity() {
    lateinit var binding:ActivityDonorRegistrationBinding
    lateinit var database:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDonorRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerButton.setOnClickListener {
            val fullname =binding.fullName.text.toString()
            val bloodgroup=binding.spinnerBloodGroup.selectedItem.toString()
            val branch=binding.spinnerBranch.selectedItem.toString()
            val phone =binding.editTextPhone.text.toString()
            val email =binding.editTextTextEmailAddress.text.toString()

            database=FirebaseDatabase.getInstance().getReference("Donors")
            val donor=Donors(fullname,bloodgroup,phone,email,branch)
            database.child(phone).setValue(donor).addOnSuccessListener {

                binding.fullName.text.clear()
//                binding.spinnerBloodGroup.d
//                binding.branch.text.clear()
                binding.editTextPhone.text.clear()
                binding.editTextTextEmailAddress.text.clear()

                Toast.makeText(this,"Successfully Registed",Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{

                Toast.makeText(this,"error",Toast.LENGTH_SHORT).show()
            }


        }

    }
}
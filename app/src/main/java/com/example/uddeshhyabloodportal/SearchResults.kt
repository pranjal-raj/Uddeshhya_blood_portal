package com.example.uddeshhyabloodportal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uddeshhyabloodportal.databinding.ActivityMainBinding
import com.example.uddeshhyabloodportal.models.Donors
import com.google.gson.Gson

class SearchResults : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainxml: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainxml.root)

        val json = this.intent.getStringExtra("json")
        val donorList  = Gson().fromJson(json, Donors::class.java)
        mainxml.nameTv.text = donorList?.listOfDonors?.get(0)?.fullName
        mainxml.emailTv.text = donorList?.listOfDonors?.get(0)?.email
        mainxml.mobileTv.text = donorList?.listOfDonors?.get(0)?.mobileNo
    }
}

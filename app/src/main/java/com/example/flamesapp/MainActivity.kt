package com.example.flamesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_findout.setOnClickListener {
            val yourName = et_your_name.text.toString().toLowerCase()
            val partnerName = et_your_partner_name.text.toString().toLowerCase()
            if (yourName.isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            } else if (partnerName.isEmpty()) {
                Toast.makeText(this, "Please enter your partner name", Toast.LENGTH_SHORT).show()
            } else if(yourName==partnerName){
                Toast.makeText(this, "Both name cannot be same", Toast.LENGTH_SHORT).show()

            } else{
                val intent = Intent(this, resultActivity::class.java).also {

                    it.putExtra("yourName", yourName)
                    it.putExtra("partnerName", partnerName)
                }
                startActivity(intent)


            }
        }
    }
}
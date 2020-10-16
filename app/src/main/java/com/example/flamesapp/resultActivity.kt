package com.example.flamesapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*

class resultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val yourName = intent.getStringExtra("yourName")
            .toString().toLowerCase().toMutableList()
        val partnerName = intent.getStringExtra("partnerName")
            .toString().toLowerCase().toMutableList()

       val result = checkResult(yourName,partnerName)
        checkFlames(result)
    }

    private fun checkResult(yourName: MutableList<Char>, partnerName: MutableList<Char>):Int {

        var result = yourName.size + partnerName.size
        var count = 0
        var c = 0
        var yourName = yourName.toSet().toMutableList()
        var partnerName = partnerName.toSet().toMutableList()
        for (i in 0..yourName.size-1){
            for (j in 0..partnerName.size-1){
                if (yourName[i]==partnerName[j]){
                    count++

                    break
                }


            }
        }

        result = result-2*count


        return result

    }
    private fun checkFlames(result: Int){
        var flames = "flames".toMutableList()
        print(result)
        val result =result%6
        when(result-1){
            0-> friend()
            1-> love()
            2-> affection()
            3-> marrige()
            4-> enemy()
            5-> sibling()
        }

    }

    private fun friend(){
        tv_result.text= "Friends"
        iv_flames.setImageResource(R.drawable.friends)


    }

    private fun love() {
        tv_result.text="Love"
        iv_flames.setImageResource(R.drawable.love)
    }

    private fun affection(){
        tv_result.text="affection"
        iv_flames.setImageResource(R.drawable.affection)
    }
    private fun marrige(){
        tv_result.text="Marrige"
        iv_flames.setImageResource(R.drawable.marrige)
    }

    private fun enemy(){
        tv_result.text="Enemy"
        iv_flames.setImageResource(R.drawable.enemy)
    }

    private fun sibling(){
        tv_result.text="Siblings"
        iv_flames.setImageResource(R.drawable.sibling)
    }
}
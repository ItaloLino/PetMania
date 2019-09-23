package com.time7.mypetapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_inicial.*
import kotlinx.android.synthetic.main.activity_main.view.*

class Inicial : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicial)



        //Mudança para a tela de cadastro
        cadastrar.setOnClickListener(){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }



        //Mudança para a tela da lista
        entrar.setOnClickListener(){
            val intent = Intent(this,Lista::class.java)
            startActivity(intent)
        }


    }
}
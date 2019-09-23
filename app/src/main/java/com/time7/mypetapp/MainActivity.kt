package com.time7.mypetapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var db: FirebaseFirestore //Instância do Firestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = FirebaseFirestore.getInstance() //"Puxando" as informações necessárias do FireBase

        salvar.setOnClickListener() {

            if (Criterios()) {
                var porte = findViewById<RadioButton>(radioGroup.checkedRadioButtonId).text.toString()
                Log.d("onitorrinco", "${radioGroup.checkedRadioButtonId}")

                var pet = Pet(
                    nome.text.toString().trim(),
                    especie.text.toString().trim(),
                    raça.text.toString().trim(),
                    dono.text.toString().trim(),
                    porte
                )

                Log.d("onitorrinco", "${pet}")

                //db.collection("Pets")
            }
        }
    }

        //Função criada para verificar se há algum campo vazio quando clicado no botão "Salvar"
        fun Criterios(): Boolean {


            var notEmpty = true


            //Checando se os textos estão vazios
            if (nome.text.toString().trim().isEmpty()) {
                nome.error = "O campo não pode ser vazio!"
                notEmpty = false
            }

            if (raça.text.toString().trim().isEmpty()) {
                raça.error = "O campo não pode ser vazio!"
                notEmpty = false
            }

            if (especie.text.toString().trim().isEmpty()) {
                especie.error = "O campo não pode ser vazio!"
                notEmpty = false
            }

            if (dono.text.toString().trim().isEmpty()) {
                dono.error = "O campo não pode ser vazio!"
                notEmpty = false
            }


            //Checando se alguma das opções do "Porte" está selecionado
            if (radioGroup.checkedRadioButtonId == -1)
                notEmpty = false

            return notEmpty
        }
}

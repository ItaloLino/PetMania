package com.time7.mypetapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.android.synthetic.main.activity_lista.*

class Lista : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        val db = FirebaseFirestore.getInstance()

        val petList = ArrayList<Pet>()
        val task = consultar(db, "Pets")

        task?.addOnSuccessListener {

            if (it != null) {

                    it.forEach { pet ->
                        petList.add(Pet( pet.data["nome"].toString(), pet.data["especie"].toString(), pet.data["raca"].toString(), pet.data["dono"].toString(), pet.data["porte"].toString()
                            ))
                    }

                    val viewManager = LinearLayoutManager(this)
                    rv.adapter = Dogderaca(petList)
                    rv.layoutManager = viewManager
                }
            }
        }


    fun consultar(db : FirebaseFirestore,collection: String): Task<QuerySnapshot>? {

        val returnDocuments = db.collection(collection).get()
        return returnDocuments
    }}

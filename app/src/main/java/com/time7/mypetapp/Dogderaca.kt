package com.time7.mypetapp

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.pet.view.*
import java.util.ArrayList

class Dogderaca (private val myDataset: ArrayList<Pet>) :
    RecyclerView.Adapter<Dogderaca.MyViewHolder>() {

    lateinit var contexto: Context
    //Função para inflar o layout da lista criada no RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.pet, parent, false)
        contexto = parent.context
        return MyViewHolder(view)
    }

    //Função para fazer o bind dos elementos da lista com os itens da RecyclerView (lista visual)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.nome.text = myDataset[position].nome
        holder.especie.text = myDataset[position].especie
        holder.raca.text = myDataset[position].raca
        holder.dono.text = myDataset[position].dono
        holder.porte.text = myDataset[position].porte

    }

    //Função para retornar o tamanho da lista
    override fun getItemCount() : Int{
        return myDataset.size
    }

    //Classe interna para criação do ViewHolder
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var nome = itemView.rvNome
        var especie = itemView.rvEspecie
        var raca = itemView.rvRaca
        var dono = itemView.rvDono
        var porte = itemView.rvPorte

    }

}
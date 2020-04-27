package com.example.animals.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.animals.R
import com.example.animals.model.Animal


class AnimalListAdapter( private val animalsList: ArrayList<Animal>):
    RecyclerView.Adapter<AnimalListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int  = animalsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(animalsList[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindView(animal: Animal) {

            val animalImageView = itemView.findViewById<ImageView?>(R.id.animalImage)
            val animalText = itemView.findViewById<TextView?>(R.id.animalName)

            animalText?.text = animal.name
        }
    }

    fun updateAnimalList(newAnimalList: ArrayList<Animal>) {
        animalsList.clear()
        animalsList.addAll(animalsList)
        notifyDataSetChanged()
    }
}
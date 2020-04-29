package com.example.animals.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.RecyclerView
import com.example.animals.R
import com.example.animals.model.Animal
import com.example.animals.utils.getProgressDrawable
import com.example.animals.utils.loadImage
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_animal.view.*


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

            val animalLayout = itemView.findViewById<ConstraintLayout?>(R.id.animalLayout)
            val animalImageView = itemView.findViewById<ImageView?>(R.id.animalImage)
            val animalText = itemView.findViewById<TextView?>(R.id.animalName)

            animalImageView?.loadImage(animal.imageUrl, getProgressDrawable(itemView.context))
            animalText?.text = animal.name

            animalLayout?.setOnClickListener {
                val action = ListFragmentDirections.actionDetail(animal)
                Navigation.findNavController(itemView).navigate(action)
            }
        }
    }

    fun updateAnimalList(newAnimalList: List<Animal>) {
        animalsList.clear()
        animalsList.addAll(newAnimalList )
        notifyDataSetChanged()
    }
}
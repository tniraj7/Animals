package com.example.animals.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.animals.R
import com.example.animals.databinding.ItemAnimalBinding
import com.example.animals.model.Animal


class AnimalListAdapter( private val animalsList: ArrayList<Animal>):
    RecyclerView.Adapter<AnimalListAdapter.ViewHolder>(), AnimalClickListener {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemAnimalBinding>(inflater, R.layout.item_animal, parent, false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int  = animalsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.animal = animalsList[position]
        holder.view.clickListener = this

    }

    class ViewHolder(var view: ItemAnimalBinding): RecyclerView.ViewHolder(view.root)

    override fun onClick(v: View) {
        for (animal in animalsList) {
            if (v.tag == animal.name) {
                val action = ListFragmentDirections.actionDetail(animal)
                Navigation.findNavController(v).navigate(action)
            }
        }
    }

    fun updateAnimalList(newAnimalList: List<Animal>) {
        animalsList.clear()
        animalsList.addAll(newAnimalList )
        notifyDataSetChanged()
    }
}
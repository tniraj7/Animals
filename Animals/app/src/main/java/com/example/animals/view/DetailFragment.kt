package com.example.animals.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import com.example.animals.R
import com.example.animals.model.Animal
import com.example.animals.utils.getProgressDrawable
import com.example.animals.utils.loadImage
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.item_animal.*

class DetailFragment : Fragment() {

    var animal: Animal? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            animal = DetailFragmentArgs.fromBundle(it).animal
        }

        context?.let {
            animalImageView.loadImage(animal?.imageUrl, getProgressDrawable(it))
        }

        animalLifeSpan.text = animal?.lifeSpan
        animalDiet.text = animal?.diet
        animalLocation.text = animal?.location
        animalNameText.text = animal?.name
    }
}

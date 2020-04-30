package com.example.animals.view


import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

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

        animal?.imageUrl?.let {
            setupBackgroundColor(it)
        }

    }

    private fun setupBackgroundColor(url : String) {
        Glide.with(this)
            .asBitmap()
            .load(url)
            .into(object : CustomTarget<Bitmap>() {
                override fun onLoadCleared(placeholder: Drawable?) {

                }

                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    Palette.from(resource)
                        .generate() { palette: Palette? ->

                            val intColor = palette?.lightMutedSwatch?.rgb ?: 0
                            animalDetailLayout.setBackgroundColor(intColor)
                        }
                }
            })
    }
}

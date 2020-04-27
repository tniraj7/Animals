package com.example.animals.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.animals.model.Animal

class ListViewModel(application: Application): AndroidViewModel(application) {

    val animals by lazy  { MutableLiveData<List<Animal>>() }
    val loadError by lazy { MutableLiveData<Boolean>() }
    val loading by lazy { MutableLiveData<Boolean>() }

    fun refresh() {
        getAnimals()
    }

    private fun getAnimals() {
        val a1  = Animal("alligator")
        val a2  = Animal("elephant")
        val a3  = Animal("tiger")
        val a4  = Animal("lion")
        val a5  = Animal("dog")
        val a6  = Animal("cat")
        val a7  = Animal("monkey")
        val a8  = Animal("donkey")
        val a9  = Animal("flamingo")
        val a10 = Animal("horse")

        val animalList = arrayListOf(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10)

        animals.value = animalList
        loadError.value = false
        loading.value = false
    }
}
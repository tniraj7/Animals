package com.example.animals.di

import com.example.animals.model.AnimalAPIService
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun inject(service: AnimalAPIService)
}
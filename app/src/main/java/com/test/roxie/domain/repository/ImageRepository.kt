package com.test.roxie.domain.repository

interface ImageRepository {

    suspend fun loadImage(imageName: String)

}

package com.test.roxie.data

import com.test.roxie.base.util.ImageHandler
import com.test.roxie.data.datasource.ImageApi
import com.test.roxie.data.work.WorkHelper
import com.test.roxie.domain.repository.ImageRepository

class ImageRepositoryImpl(
    private val api: ImageApi,
    private val imageHandler: ImageHandler,
    private val workerHelper: WorkHelper
) : ImageRepository {

    override suspend fun loadImage(imageName: String) {
        if (imageHandler.isImageSaved(imageName)) return

        val body = api.getImage(imageName)
        workerHelper.planDeletingImage(imageName)
        imageHandler.saveImage(imageName, body)
    }

}
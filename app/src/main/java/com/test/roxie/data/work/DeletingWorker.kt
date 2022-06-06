package com.test.roxie.data.work

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.test.roxie.base.util.ImageHandler

class DeletingWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    private val imageName = workerParams.tags.last()

    override fun doWork(): Result {
        ImageHandler(applicationContext).deleteImage(imageName)
        return Result.success()
    }

}
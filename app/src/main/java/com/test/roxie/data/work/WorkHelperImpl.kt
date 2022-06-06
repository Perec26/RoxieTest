package com.test.roxie.data.work

import android.content.Context
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

private const val DELETE_DELAY = 1L

class WorkHelperImpl(private val context: Context) : WorkHelper {

    override fun planDeletingImage(imageName: String) {
        val workRequest = OneTimeWorkRequestBuilder<DeletingWorker>()
            .setInitialDelay(DELETE_DELAY, TimeUnit.MINUTES)
            .addTag(imageName)
            .build()
        WorkManager.getInstance(context).enqueue(workRequest)
    }

}
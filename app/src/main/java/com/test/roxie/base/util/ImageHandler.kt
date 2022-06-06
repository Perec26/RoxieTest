package com.test.roxie.base.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.test.roxie.BuildConfig
import okhttp3.ResponseBody
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream

class ImageHandler(private val context: Context) {

    fun deleteImage(imageName: String) {
        getImageFile(imageName).delete()
    }

    fun saveImage(imageName: String, body: ResponseBody) {

        val file = getImageFile(imageName)
        val fileReader = ByteArray(4096)
        val inputStream: InputStream? = body.byteStream()
        val outputStream = FileOutputStream(file)

        try {
            while (true) {
                val read = inputStream?.read(fileReader) ?: return
                if (read == -1) break

                outputStream.write(fileReader, 0, read)
            }
            outputStream.flush()

        } catch (e: IOException) {
            return
        } finally {
            inputStream?.close()
            outputStream.close()
        }

    }

    fun getImage(imageName: String): Bitmap? {
        val file = getImageFile(imageName)
        return BitmapFactory.decodeFile(file.absolutePath)
    }

    fun isImageSaved(imageName: String): Boolean {
        val file = getImageFile(imageName)
        return file.exists()
    }

    private fun getImageFile(imageName: String): File {
        val directory = context.getDir(BuildConfig.BASE_IMAGE_DIR, Context.MODE_PRIVATE)
        return File(directory, imageName)
    }

}


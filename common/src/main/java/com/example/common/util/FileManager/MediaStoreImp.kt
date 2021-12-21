package com.example.common.util.FileManager

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import com.example.common.util.isDeviceSDKGreaterThan
import java.io.FileNotFoundException

/**
 * Created by akash on 27,07,2021
 */
class MediaStoreImp(var context: Context) : MediaStore {

    override fun saveImage(fileName: String, bitmap: Bitmap, format: ImageFormat):Boolean {
        val row = ContentValues().apply {
            put(android.provider.MediaStore.Images.Media.DISPLAY_NAME, fileName)
            put(
                android.provider.MediaStore.Images.Media.MIME_TYPE,
                getMimeType(Image(format))
            )
        }
        val table = if (isDeviceSDKGreaterThan(29))
            android.provider.MediaStore.Images.Media.getContentUri(android.provider.MediaStore.VOLUME_EXTERNAL_PRIMARY)
        else
            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI

        context.contentResolver.run {
            return insert(table, row)?.let { uri ->
                try {
                    openOutputStream(uri).use {
                        bitmap.compress(getBitmapFormat(format), 100, it)
                    }
                } catch (e: FileNotFoundException) {
                    false
                }
            }?:false
        }
    }

    override fun saveAudio(): Uri? {
        return null
    }

    override fun saveVideo(): Uri? {
        return null
    }


}
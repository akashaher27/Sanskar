package com.example.common.util.FileManager

import android.graphics.Bitmap
import com.example.common.util.FileManager.*

/**
 * Created by akash on 01,08,2021
 */


fun getMimeType(format: Format): String {
    return when (format) {
        is Image -> {
            when (format.format) {
                ImageFormat.JPEG -> MIME_TYPE_JPG
                ImageFormat.PNG -> MIME_TYPE_PNG
            }
        }
        is Document -> {
            when (format.format) {
                DocFormat.PDF -> MIME_TYPE_PDF
                DocFormat.TEXT -> MIME_TYPE_TEXT
            }
        }
    }
}

fun getBitmapFormat(format: ImageFormat): Bitmap.CompressFormat {
    return when (format){
        ImageFormat.PNG -> Bitmap.CompressFormat.PNG
        ImageFormat.JPEG -> Bitmap.CompressFormat.JPEG
    }
}






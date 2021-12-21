package com.example.common.util.FileManager

import android.graphics.Bitmap

/**
 * Created by akash on 28,07,2021
 */


const val MIME_TYPE_JPG = "image/jpeg"
const val MIME_TYPE_PNG = "image/png"
const val MIME_TYPE_PDF = "application/pdf"
const val MIME_TYPE_TEXT = "text/plain"

const val EXT_JPG = ".jpeg"
const val EXT_PNG = ".png"
const val EXT_PDF = ".pdf"


enum class ImageFormat {
    PNG, JPEG
}
enum class DocFormat {
    PDF, TEXT
}

sealed class Format()
data class Image(
    var format: ImageFormat
) : Format()
data class Document(
    var format: DocFormat
) : Format()


enum class FileType {
    IMAGE, AUDIO, VIDEO, DOC
}

enum class StorageType {
    INTERNAL, EXTERNAL, SHARED
}

sealed class FileDetail(open var fileName: String, open var fileType: FileType)

data class ImageFile(
    override var fileName: String,
    var bitmap: Bitmap,
    var format: ImageFormat
) : FileDetail(fileName, FileType.IMAGE)


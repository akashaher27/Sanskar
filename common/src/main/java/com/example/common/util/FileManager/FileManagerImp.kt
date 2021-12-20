package com.example.common.util.FileManager

import android.content.Context
import java.io.File
import java.io.FileOutputStream

/**
 * Created by akash on 28,07,2021
 */
class FileManagerImp(private var context: Context) :
    FileManager {

    private val mediaStore: MediaStore by lazy {
        MediaStoreImp(context)
    }

    override fun saveFileToSharedStorage(fileDetail: FileDetail): Boolean {
        return when (fileDetail) {
            is ImageFile -> {
                saveImage(StorageType.SHARED, fileDetail)
            }
        }
    }

    override fun saveFileToExternalStorage(fileDetail: FileDetail): Boolean {
        return when (fileDetail) {
            is ImageFile -> {
                saveImage(StorageType.EXTERNAL, fileDetail)
            }
        }
    }

    override fun saveFileToInternalStorage(fileDetail: FileDetail): Boolean {
        return when (fileDetail) {
            is ImageFile -> {
                saveImage(StorageType.EXTERNAL, fileDetail)
            }
        }
    }

    private fun saveImage(storageType: StorageType, imageFile: ImageFile): Boolean {
        return when (storageType) {
            StorageType.SHARED -> {
                mediaStore.saveImage(imageFile.fileName, imageFile.bitmap, imageFile.format)
            }
            StorageType.INTERNAL -> {
                return false
            }
            StorageType.EXTERNAL -> {
                val appDirectory = context.getExternalFilesDir(null)
                return appDirectory?.let { dir ->
                    try {
                        val file = File(dir.absolutePath, imageFile.fileName + EXT_JPG)
                        FileOutputStream(file).use {
                            imageFile.bitmap.compress(getBitmapFormat(imageFile.format), 100, it)
                        }
                    } catch (e: Exception) {
                        false
                    }
                } ?: false
            }
        }
    }
}




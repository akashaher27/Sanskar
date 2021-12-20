package com.example.common.util.FileManager

import com.example.common.util.FileManager.FileDetail

/**
 * Created by akash on 28,07,2021
 */
interface FileManager {

    fun saveFileToSharedStorage(fileDetail: FileDetail):Boolean

    fun saveFileToExternalStorage(fileDetail: FileDetail):Boolean

    fun saveFileToInternalStorage(fileDetail: FileDetail):Boolean

}
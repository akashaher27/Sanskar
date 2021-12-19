package com.example.common.model

import android.net.Uri

/**
 * Created by akash on 22,11,2021
 */
data class FileDetail(
    var name: String? = null,
    var size: Long? = null,
    var uri: Uri? = null

)

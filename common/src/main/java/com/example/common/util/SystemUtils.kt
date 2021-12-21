package com.example.common.util

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.OpenableColumns
import androidx.core.content.FileProvider
import com.example.common.R
import com.example.common.model.FileDetail
import java.io.File

/**
 * Created by akash on 22,11,2021
 */


fun getTempFileUri(context: Context): Uri? {
    val tempFile = File.createTempFile("temp", null, context.cacheDir)
    return try {
        FileProvider.getUriForFile(
            context.applicationContext,
            "com.example.sanskar.provider",
            tempFile
        )
    } catch (e: Exception) {
        null
    }
}

fun getTempFileUri(context: Context, suffix: String): Uri? {
    val tempFile = File.createTempFile("temp", suffix, context.cacheDir)
    return try {
        FileProvider.getUriForFile(
            context.applicationContext,
            "com.example.sanskar.provider",
            tempFile
        )
    } catch (e: Exception) {
        null
    }
}

fun getFileDetail(context: Context, uri: Uri): FileDetail {
    var name: String? = null
    var size: Long? = null
    context.contentResolver.query(uri, null, null, null, null)?.use { cursor ->
        val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
        val sizeIndex = cursor.getColumnIndex(OpenableColumns.SIZE)
        cursor.moveToFirst()
        name = cursor.getString(nameIndex).toString()
        size = cursor.getLong(sizeIndex)
    }
    return FileDetail(name, size, uri)
}

fun toMegaByte(byte: Long): Float {
    return (byte / (1024 * 1024)).toFloat()
}

fun Context.copyTextToClipboard(title: String, value: String): Boolean {
    return try {
        val clipboard: ClipboardManager =
            getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText(title, value)
        clipboard.setPrimaryClip(clip)
        true
    } catch (e: Exception) {
        false
    }
}

fun isDeviceSDKGreaterThan(sdkInt: Int): Boolean = Build.VERSION.SDK_INT > sdkInt

fun Context.showIntentChooser(chooserIntent: Intent) {
    val info = this.packageManager.queryIntentActivities(chooserIntent, 0)
    if (info.isNotEmpty()) {
        startActivity(
            Intent.createChooser(
                chooserIntent,
                this.getString(R.string.title_share_with)
            )
        )
    }
}

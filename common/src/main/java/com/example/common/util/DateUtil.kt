package com.example.common.util

import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*

/**
 * Created by akash on 22,10,2021
 */

object DateUtil {

    const val PATTERN_DD_MM_UUUU = "dd/MM/uuuu"
    const val PATTERN_MMM_DD_UUUU = "MMM dd uuuu"
    const val PATTERN_DD_MMM_UUUU = "dd MMM uuuu"


    fun stringToDate(date: String, pattern: String): LocalDate? {
        return try {
            LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH))
        } catch (e: Exception) {
            null
        }
    }

    fun dateToString(date: LocalDate, pattern: String): String? {
        return try {
            date.format(DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH))
        } catch (e: Exception) {
            null
        }
    }

    fun toMilli(date: String, pattern: String): Long? {
        return stringToDate(date, pattern)?.atStartOfDay()
            ?.toInstant(ZoneOffset.UTC)?.toEpochMilli()
    }

    fun toLocalDate(millis: Long): LocalDate {
        return Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalDate()
    }
}
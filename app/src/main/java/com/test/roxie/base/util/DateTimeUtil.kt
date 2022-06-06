package com.test.roxie.base.util

import java.time.format.DateTimeFormatter

object DateTimeFormats {
    private const val FORMAT_TIME = "hh:mm"
    private const val FORMAT_DATE = "dd.MM.yyyy"
    val FORMATTER_TIME: DateTimeFormatter = DateTimeFormatter.ofPattern(FORMAT_TIME)
    val FORMATTER_DATE: DateTimeFormatter = DateTimeFormatter.ofPattern(FORMAT_DATE)
}
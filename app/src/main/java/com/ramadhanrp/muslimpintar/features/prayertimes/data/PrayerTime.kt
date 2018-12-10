package com.ramadhanrp.muslimpintar.features.prayertimes.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverter
import java.util.*
import com.google.gson.annotations.SerializedName
import com.ramadhanrp.muslimpintar.features.prayertimes.data.source.remote.aladhan.Meta
import com.ramadhanrp.muslimpintar.features.prayertimes.data.source.remote.aladhan.Method
import com.ramadhanrp.muslimpintar.features.prayertimes.data.source.remote.aladhan.Offset

@Entity(tableName = "PrayerTime")
data class PrayerTime(
    @PrimaryKey
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "imsak") val imsak: String,
    @ColumnInfo(name = "fajr") val fajr: String,
    @ColumnInfo(name = "sunrise") val sunrise: String,
    @ColumnInfo(name = "dhuhr") val dhuhr: String,
    @ColumnInfo(name = "asr") val asr: String,
    @ColumnInfo(name = "maghrib") val maghrib: String,
    @ColumnInfo(name = "isha") val isha: String,
    @ColumnInfo(name = "midnight") val midnight: String
)

data class PrayerTimeConfigs(
    val latitude: Double,
    val longitude: Double,
    val method: Method,
    val offset: Offset,
    val timeZone: String,
    val city: String
)
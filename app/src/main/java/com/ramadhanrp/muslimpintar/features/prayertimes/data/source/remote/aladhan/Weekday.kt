package com.ramadhanrp.muslimpintar.features.prayertimes.data.source.remote.aladhan

import com.google.gson.annotations.SerializedName

data class Weekday(

	@field:SerializedName("en")
	val en: String? = null,

	@field:SerializedName("ar")
	val ar: String? = null
)
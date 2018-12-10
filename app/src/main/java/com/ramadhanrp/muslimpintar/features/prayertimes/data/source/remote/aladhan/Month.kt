package com.ramadhanrp.muslimpintar.features.prayertimes.data.source.remote.aladhan

import com.google.gson.annotations.SerializedName

data class Month(

	@field:SerializedName("number")
	val number: Int? = null,

	@field:SerializedName("en")
	val en: String? = null,

	@field:SerializedName("ar")
	val ar: String? = null
)
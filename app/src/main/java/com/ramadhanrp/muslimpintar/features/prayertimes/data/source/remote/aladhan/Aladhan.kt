package com.ramadhanrp.muslimpintar.features.prayertimes.data.source.remote.aladhan

import com.google.gson.annotations.SerializedName

data class Aladhan(

	@field:SerializedName("date")
	val date: Date? = null,

	@field:SerializedName("meta")
	val meta: Meta? = null,

	@field:SerializedName("timings")
	val timings: Timings? = null
)
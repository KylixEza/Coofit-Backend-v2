package com.pemweb.model.step

import com.google.gson.annotations.SerializedName

data class StepBody(
	@field:SerializedName("step")
	val step: String
)

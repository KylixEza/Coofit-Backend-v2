package com.pemweb.model.user

import com.google.gson.annotations.SerializedName

data class EditAddressBody(
	
	@field:SerializedName("address")
	val address: String
)

package com.test.enmatest.data.network.model

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("statusCode") val statusCode: Int?,
    @SerializedName("code") val code: Int?,
    @SerializedName("message") val message: String?
)
package com.test.enmatest.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.test.enmatest.util.md5
import kotlin.math.sign

data class PresetQueryParams(
    @Expose
    @SerializedName("app_id")
    val appId: String,
    @Expose
    @SerializedName("app_secret")
    val appSecret: String,
    val hashKey: String
)

fun getHashKey(queryParams: PresetQueryParams, vararg additionalSignatureInfo: String): String {
    val stringBuilder = StringBuilder()
    for (string in additionalSignatureInfo)
        stringBuilder.append(string)
    val signature = "${stringBuilder.toString()}${queryParams.appId}${queryParams.appSecret}${queryParams.hashKey}".md5()
    return signature
}
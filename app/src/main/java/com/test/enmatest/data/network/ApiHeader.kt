package com.test.enmatest.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

class ApiHeader @Inject constructor(internal val protectedApiHeader: ProtectedApiHeader,
                                    internal val publicApiHeader: PublicApiHeader) {
    class ProtectedApiHeader @Inject constructor(@Expose
                                                 @SerializedName("Authorization") val authToken: String?)

    class PublicApiHeader @Inject constructor(@Expose
                                              @SerializedName("Accept-Language") val language: String?,
                                              @Expose
                                              @SerializedName("X-Device-Id") val deviceId: String?,
                                              @Expose
                                              @SerializedName("X-Device-Platform") val devicePlatform: String?,
                                              @Expose
                                              @SerializedName("X-App-Version") val appVersion: String?,
                                              @Expose
                                              @SerializedName("Content-Type") val contentType: String?)
}
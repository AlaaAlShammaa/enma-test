package com.test.enmatest.data.network

import com.test.enmatest.data.network.model.*
import com.google.gson.Gson
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single
import org.json.JSONObject
import javax.inject.Inject


class AppApiHelper @Inject constructor(private val apiHeader: ApiHeader) : ApiHelper {

    @Inject
    lateinit var mGson: Gson

}
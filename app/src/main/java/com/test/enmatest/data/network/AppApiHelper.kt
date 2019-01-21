package com.test.enmatest.data.network

import com.test.enmatest.data.network.model.*
import com.google.gson.Gson
import com.rx2androidnetworking.Rx2AndroidNetworking
import com.test.enmatest.util.md5
import io.reactivex.Single
import org.json.JSONObject
import javax.inject.Inject


class AppApiHelper @Inject constructor(private val apiHeader: ApiHeader, private val queryParams: PresetQueryParams) :
    ApiHelper {

    @Inject
    lateinit var mGson: Gson

    override fun getCategories(): Single<CategoriesResponse> =
        Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_GET_CATEGORIES)
            .addQueryParameter(queryParams)
            .addQueryParameter("signature", getHashKey(queryParams))
            .build()
            .getObjectSingle(CategoriesResponse::class.java)

    override fun getPosts(query: String?, pageNumber: Int, pageSize: Int): Single<FeedResponse> =
        Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_GET_POSTS)
            .addQueryParameter(queryParams)
            .addQueryParameter("signature", getHashKey(queryParams))
            .build()
            .getObjectSingle(FeedResponse::class.java)

}
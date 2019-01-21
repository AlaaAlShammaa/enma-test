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

    override fun getPosts(categoryId: String?, query: String?, pageNumber: Int, pageSize: Int): Single<FeedResponse> {
        val stringBuilder = StringBuilder()
        val builder =
            Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_GET_POSTS)
        if (categoryId != null) {
            builder.addQueryParameter("category", categoryId)
            stringBuilder.append(categoryId)
        }
        if (!query.isNullOrBlank()) {
            builder.addQueryParameter("q", query)
        }
        builder
            .addQueryParameter("page", pageNumber.toString())
            .addQueryParameter("limit", pageSize.toString())
            .addQueryParameter(queryParams)
            .addQueryParameter("signature", getHashKey(queryParams, query, pageSize.toString(), pageNumber.toString(), stringBuilder.toString()))
        return builder
            .build()
            .getObjectSingle(FeedResponse::class.java)
    }

}
package com.test.enmatest.data.network

import com.test.enmatest.data.network.model.*
import com.test.enmatest.util.AppConstants
import io.reactivex.Single
import org.json.JSONObject

interface ApiHelper {
    fun getCategories(): Single<CategoriesResponse>
    fun getPosts(categoryId: String? = "", query: String? = "", pageNumber: Int, pageSize: Int = AppConstants.PAGE_SIZE): Single<FeedResponse>
}
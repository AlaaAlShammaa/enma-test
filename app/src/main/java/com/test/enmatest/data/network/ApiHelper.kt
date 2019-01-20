package com.test.enmatest.data.network

import com.test.enmatest.data.network.model.*
import com.test.enmatest.util.AppConstants.ProcessType
import io.reactivex.Single
import org.json.JSONObject

interface ApiHelper {
    fun getCategories(): Single<CategoriesResponse>
}
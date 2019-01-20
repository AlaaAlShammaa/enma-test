package com.test.enmatest.data.network.model

import com.google.gson.annotations.Expose

data class CategoriesResponse(
    @Expose
    val `data`: List<Category>?,
    @Expose
    val meta: Meta
)

data class Category(
    @Expose
    val description: String,
    @Expose
    val id: Int,
    @Expose
    val image: String,
    @Expose
    val name: String
)

data class Meta(
    @Expose
    val cached: Boolean,
    @Expose
    val message: String,
    @Expose
    val response: String,
    @Expose
    val status: Int,
    @Expose
    val success: Int,
    @Expose
    val total_processing_time: Double
)
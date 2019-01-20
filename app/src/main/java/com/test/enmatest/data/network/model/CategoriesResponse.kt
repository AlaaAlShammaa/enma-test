package com.test.enmatest.data.network.model

data class CategoriesResponse(
    val `data`: List<Data>,
    val meta: Meta
)

data class Data(
    val description: String,
    val id: Int,
    val image: String,
    val name: String
)

data class Meta(
    val cached: Boolean,
    val message: String,
    val response: String,
    val status: Int,
    val success: Int,
    val total_processing_time: Double
)
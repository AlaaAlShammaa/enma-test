package com.test.enmatest.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class FeedResponse(
    @Expose
    @SerializedName("data")
    val posts: List<Post>?,
    @Expose
    @SerializedName("meta")
    val meta: Meta?
)

data class Post(
    @Expose
    @SerializedName("caption")
    val caption: String?,
    @Expose
    @SerializedName("category_id")
    val categoryId: Int?,
    @Expose
    @SerializedName("comment_count")
    val commentCount: Int?,
    @Expose
    @SerializedName("coutrycode2")
    val coutrycode2: String?,
    @Expose
    @SerializedName("created_at")
    val createdAt: Int?,
    @Expose
    @SerializedName("dislike_count")
    val dislikeCount: Int?,
    @Expose
    @SerializedName("id_post")
    val idPost: Int?,
    @Expose
    @SerializedName("like_count")
    val likeCount: Int?,
    @Expose
    @SerializedName("media")
    val media: List<Media?>?,
    @Expose
    @SerializedName("name")
    val name: String?,
    @Expose
    @SerializedName("ranking_score")
    val rankingScore: Int?,
    @Expose
    @SerializedName("tag")
    val tag: List<Any?>?,
    @Expose
    @SerializedName("type")
    val type: String?,
    @Expose
    @SerializedName("url")
    val url: String?,
    @Expose
    @SerializedName("username")
    val username: String?,
    @Expose
    @SerializedName("view_count")
    val viewCount: Int?
)

data class Media(
    @Expose
    @SerializedName("title")
    val title: String?,
    @Expose
    @SerializedName("type")
    val type: String?,
    @Expose
    @SerializedName("url")
    val url: String?
)
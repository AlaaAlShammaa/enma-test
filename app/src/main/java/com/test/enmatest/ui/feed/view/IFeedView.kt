package com.test.enmatest.ui.feed.view

import com.test.enmatest.data.network.model.Post
import com.test.enmatest.ui.base.view.IView

interface IFeedView : IView {
    fun setupFeedRV()
    fun showToolbarProgress()
    fun hideToolbarProgress()
    fun reflectPosts(posts: List<Post>?, isNewList: Boolean)
    fun searchByQuery(query: String)
}

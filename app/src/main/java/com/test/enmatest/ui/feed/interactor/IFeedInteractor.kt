package com.test.enmatest.ui.feed.interactor

import com.test.enmatest.data.network.model.FeedResponse
import com.test.enmatest.ui.base.interactor.IInteractor
import io.reactivex.Single

interface IFeedInteractor : IInteractor {
    fun getPosts(categoryId: String?, query: String?, pageNumber: Int, pageSize: Int): Single<FeedResponse>
}

package com.test.enmatest.ui.feed

import com.test.enmatest.ui.feed.interactor.FeedInteractorImpl
import com.test.enmatest.ui.feed.interactor.IFeedInteractor
import com.test.enmatest.ui.feed.presenter.FeedPresenterImpl
import com.test.enmatest.ui.feed.presenter.IFeedPresenter
import com.test.enmatest.ui.feed.view.IFeedView
import dagger.Module
import dagger.Provides

@Module
class FeedFragmentModule {

    @Provides
    internal fun provideFeedInteractor(FeedInteractorImpl: FeedInteractorImpl): IFeedInteractor = FeedInteractorImpl

    @Provides
    internal fun provideFeedPresenter(FeedPresenterImpl: FeedPresenterImpl<IFeedView, IFeedInteractor>)
            : IFeedPresenter<IFeedView, IFeedInteractor> = FeedPresenterImpl
}

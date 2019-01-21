package com.test.enmatest.ui.searchFeed


import com.test.enmatest.ui.searchFeed.interactor.SearchFeedInteractorImpl
import com.test.enmatest.ui.searchFeed.interactor.ISearchFeedInteractor
import com.test.enmatest.ui.searchFeed.presenter.SearchFeedPresenterImpl
import com.test.enmatest.ui.searchFeed.presenter.ISearchFeedPresenter
import com.test.enmatest.ui.searchFeed.view.ISearchFeedView
import dagger.Module
import dagger.Provides

@Module
class SearchFeedActivityModule {

    @Provides
    internal fun provideSearchFeedInteractor(searchFeedInteractorImpl: SearchFeedInteractorImpl): ISearchFeedInteractor = searchFeedInteractorImpl

    @Provides
    internal fun provideSearchFeedPresenter(searchFeedPresenterImpl: SearchFeedPresenterImpl<ISearchFeedView, ISearchFeedInteractor>)
            : ISearchFeedPresenter<ISearchFeedView, ISearchFeedInteractor> = searchFeedPresenterImpl
}

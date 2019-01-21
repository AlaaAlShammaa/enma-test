package com.test.enmatest.ui.categoryFeed.presenter

import com.test.enmatest.ui.base.presenter.IPresenter
import com.test.enmatest.ui.categoryFeed.interactor.ICategoryFeedInteractor
import com.test.enmatest.ui.categoryFeed.view.ICategoryFeedView

interface ICategoryFeedPresenter<V : ICategoryFeedView, I : ICategoryFeedInteractor> : IPresenter<V, I> {

}

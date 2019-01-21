package com.test.enmatest.ui.searchFeed.interactor

import com.test.enmatest.data.network.ApiHelper
import com.test.enmatest.data.preferences.PreferenceHelper
import com.test.enmatest.ui.base.interactor.BaseInteractorImpl
import com.test.enmatest.ui.searchFeed.interactor.ISearchFeedInteractor
import javax.inject.Inject

class SearchFeedInteractorImpl @Inject internal constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : BaseInteractorImpl(preferenceHelper = preferenceHelper, apiHelper = apiHelper), ISearchFeedInteractor {
}

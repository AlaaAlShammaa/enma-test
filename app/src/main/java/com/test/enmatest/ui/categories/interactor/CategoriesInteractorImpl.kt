package com.test.enmatest.ui.categories.interactor

import com.test.enmatest.data.network.ApiHelper
import com.test.enmatest.data.network.model.CategoriesResponse
import com.test.enmatest.data.preferences.PreferenceHelper
import com.test.enmatest.ui.base.interactor.BaseInteractorImpl
import io.reactivex.Single
import javax.inject.Inject

class CategoriesInteractorImpl @Inject internal constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : BaseInteractorImpl(preferenceHelper = preferenceHelper, apiHelper = apiHelper), ICategoriesInteractor {
    override fun getCategories(): Single<CategoriesResponse> = apiHelper.getCategories()
}

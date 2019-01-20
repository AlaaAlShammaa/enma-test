package com.test.enmatest.ui.categories.interactor

import com.test.enmatest.data.network.model.CategoriesResponse
import com.test.enmatest.ui.base.interactor.IInteractor
import io.reactivex.Single

interface ICategoriesInteractor : IInteractor {
    fun getCategories(): Single<CategoriesResponse>
}

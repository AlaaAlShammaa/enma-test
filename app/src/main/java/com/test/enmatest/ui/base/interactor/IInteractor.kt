package com.test.enmatest.ui.base.interactor

import io.reactivex.Single

interface IInteractor {

    fun setAccessToken(accessToken: String?)

    fun getAccessToken(): String?

    fun isUserLoggedIn(): Boolean

    fun performUserLogout()

}
package com.test.enmatest.ui.base.interactor

import com.google.gson.Gson
import com.test.enmatest.data.network.ApiHelper
import com.test.enmatest.data.preferences.PreferenceHelper
import com.test.enmatest.util.AppConstants
import io.reactivex.Single
import javax.inject.Inject


open class BaseInteractorImpl() : IInteractor {


    protected lateinit var preferenceHelper: PreferenceHelper
    protected lateinit var apiHelper: ApiHelper

    constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : this() {
        this.preferenceHelper = preferenceHelper
        this.apiHelper = apiHelper
    }

    override fun isUserLoggedIn() = this.preferenceHelper.getCurrentUserLoggedInMode() != AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.type

    override fun performUserLogout() = preferenceHelper.let {
        it.clearPreferences()
        it.setCurrentUserLoggedInMode(AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT)
    }

    override fun setAccessToken(accessToken: String?) {
        preferenceHelper.setAccessToken(accessToken)
    }

    override fun getAccessToken(): String? {
        return preferenceHelper.getAccessToken()
    }

}
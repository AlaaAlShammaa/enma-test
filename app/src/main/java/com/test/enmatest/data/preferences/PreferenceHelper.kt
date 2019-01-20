package com.test.enmatest.data.preferences

import com.test.enmatest.util.AppConstants

interface PreferenceHelper {

    fun clearPreferences()

    fun getCurrentUserLoggedInMode(): Int

    fun setCurrentUserLoggedInMode(mode: AppConstants.LoggedInMode)

    fun getCurrentUserId(): Long?

    fun setCurrentUserId(userId: Long?)

    fun getCurrentUserName(): String

    fun setCurrentUserName(userName: String?)

    fun getCurrentUserEmail(): String?

    fun setCurrentUserEmail(email: String?)

    fun getAccessToken(): String?

    fun setAccessToken(accessToken: String?)

    fun getAppUser(): String?

    fun setAppUser(appUser: String?)

}
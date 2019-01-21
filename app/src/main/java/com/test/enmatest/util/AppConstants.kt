package com.test.enmatest.util


object AppConstants {

    internal const val PREF_NAME = "enmatest_pref"
    internal const val PAGE_SIZE = 10
    internal const val PAGINATION_MARGIN = 3
    internal const val NULL_INDEX = -1L

    enum class LoggedInMode constructor(val type: Int) {
        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3)
    }
}
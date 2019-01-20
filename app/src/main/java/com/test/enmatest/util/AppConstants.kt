package com.test.enmatest.util

import androidx.annotation.StringDef

object AppConstants {

    internal const val PREF_NAME = "enmatest_pref"
    internal const val NO_INTERNET_ERROR = 0
    internal const val SESSION_EXPIRED = 106
    internal const val ERROR_CODE_RAHAL_NOT_ENOUGH_QUOTA = 301
    internal const val ERROR_CODE_RAHAL_CARD_NOT_FOUND = 302
    internal const val ERROR_CODE_RAHAL_PRODUCT_NOT_FOUND = 303
    internal const val ERROR_CODE_UNAVAILABLE_TIMESLOT = 304
    internal const val ERROR_CODE_CREDIT_CART_NOT_FOUND = 208
    internal const val ERROR_CODE_CANNOT_CREATE_ORDER = 305
    internal const val UNAUTHORIZED = 401
    internal const val STATUS_SUCCESS = 200
    internal const val STATUS_CREATED = 201
    internal const val ERROR_VERSION_IS_TOO_OLD = 102
    internal const val ERROR_INVALID_PHONE_NUMBER = 202
    internal const val ERROR_EMIRATES_ID_ALREADY_EXISTS = 203
    internal const val ERROR_PHONE_NUMBER_ALREADY_EXISTS = 204
    internal const val ERROR_INVALID_PIN = 205
    internal const val ERROR_DELETE_PRIMARY_CREDIT_CARD = 209
    internal const val ERROR_DUPLICATE_LABEL = 210
    internal const val ERROR_DELETE_ACTIVE_CREDIT_CARD = 211
    internal const val ERROR_INVALID_OTP = 212
    internal const val ERROR_VERIFY_IDENTITY = 213
    internal const val ERROR_INVALID_EMIRATES_ID = 214
    internal const val ERROR_TOO_MANY_TRIES = 215
    internal const val ERROR_WALLET_VALIDATION = 216
    internal const val ERROR_DELETE_CAR_ERROR = 217
    internal const val ERROR_PAYMENT_FAILED = 312
    const val ERROR_ID_ALREADY_EXISTS_LOCAL = 400

    // local errors
    internal const val ERROR_INVALID_NAME = 10006
    internal const val ERROR_INVALID_EMAIL = 10007
    internal const val ERROR_INVALID_ADDRESS_ID = 10011
    internal const val ERROR_DELETE_PRIMARY_ADDRESS = 10021
    internal const val ERROR_INVALID_CREDIT_CARD_ID = 10022
    internal const val ERROR_DELETE_PRIMARY_CARD = 10023
    internal const val ERROR_ADD_CREDIT_CARD = 10024
    internal const val ERROR_INVALID_CAR_ID = 10031
    internal const val ERROR_INVALID_PHONE_NUMBER_LOCAL = 400
    internal const val NULL_INDEX = -1L

    //cancel order error
    internal const val ERROR_CODE_CANNOT_CANCEL_RUNNING_ORDER = 400
    internal const val ERROR_CODE_NOT_FOUND = 404
    internal const val ERROR_INVITATION_CODE_ERROR = 314
    internal const val ERROR_GASOLINE_ORDER_DISABLED = 315

    @StringDef(TYPE_LPG, TYPE_GASOLINE)
    @Retention(AnnotationRetention.SOURCE)
    annotation class ProcessType

    // Map defaults
    const val MAP_DEFAULT_ZOOM = 15f
    const val ABU_DHABI_LATITUDE = 24.4539
    const val ABU_DHABI_LONGITUDE = 54.3773

    const val TYPE_LPG = "lpg"
    const val TYPE_GASOLINE = "gasoline"

    // Map Regions
    const val REGION_GREEN = "green"
    const val REGION_YELLOW = "YELLOW"
    const val REGION_RED = "red"

    @StringDef(REGION_GREEN, REGION_YELLOW, REGION_RED)
    @Retention(AnnotationRetention.SOURCE)
    annotation class RegionType

    // payment credit carts
    const val MASTER_CARD = "mastercard"
    const val VISA = "visa"

    // default time zone
    const val TIMEZONE = "Asia/Dubai"

    internal const val EXTRA_USER_ID = "EXTRA_USER_ID"
    internal const val EXTRA_KEY_FEED_SOURCE = "EXTRA_KEY_FEED_SOURCE"


    // popup
    const val TITLE: String = "title"
    const val SUBTITLE: String = "subtitle"
    const val IMAGE: String = "iv"
    const val INPUT: String = "input"
    const val NEGATIVE_BUTTON: String = "negative_button"
    const val POSITIVE_BUTTON: String = "positive_button"

    // Adjust
//    const val ADJUST_TOKEN = "7f2vuu9timbk"
    const val ADJUST_TOKEN = "8n7prtctre68"

    // Permission status
    val GRANTED = 0
    val DENIED = 1
    val BLOCKED_OR_NEVER_ASKED = 2

    enum class LoggedInMode constructor(val type: Int) {
        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3)
    }
}
package com.test.enmatest.di.module

import com.test.enmatest.BuildConfig
import com.test.enmatest.R
import com.test.enmatest.di.ApiKeyInfo
import com.test.enmatest.di.PreferenceInfo
import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.provider.Settings
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import javax.inject.Singleton
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.google.gson.Gson
import com.test.enmatest.data.network.ApiHeader
import com.test.enmatest.data.network.ApiHelper
import com.test.enmatest.data.network.AppApiHelper
import com.test.enmatest.data.preferences.AppPreferenceHelper
import com.test.enmatest.data.preferences.PreferenceHelper
import com.test.enmatest.util.AppConstants
import com.test.enmatest.util.CommonUtil
import com.test.enmatest.util.SchedulerProvider


@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application


    @Provides
    @ApiKeyInfo
    internal fun provideApiKey(): String = BuildConfig.BASE_URL

    @Provides
    @PreferenceInfo
    internal fun provideprefFileName(): String = AppConstants.PREF_NAME

    @Provides
    @Singleton
    internal fun providePrefHelper(appPreferenceHelper: AppPreferenceHelper): PreferenceHelper = appPreferenceHelper

    @Provides
    internal fun provideProtectedApiHeader(@ApiKeyInfo apiKey: String, preferenceHelper: PreferenceHelper)
            : ApiHeader.ProtectedApiHeader = ApiHeader.ProtectedApiHeader(
        authToken = preferenceHelper.getAccessToken()
    )

    @SuppressLint("HardwareIds")
    @Provides
    internal fun providePublicApiHeader(application: Application): ApiHeader.PublicApiHeader {
        return ApiHeader.PublicApiHeader(
            if (CommonUtil.isArabic()) "ar" else "en",
            Settings.Secure.getString(
                application.contentResolver,
                Settings.Secure.ANDROID_ID
            ),
            "Android",
            BuildConfig.VERSION_NAME.split("-")[0],
            "application/json"
        )
    }

    @Provides
    @Singleton
    internal fun provideCalligraphyDefaultCCustomToolonfig(): CalligraphyConfig {
        return CalligraphyConfig.Builder()
            .setDefaultFontPath("fonts/SF-Pro-Text-Regular.ttf")
            .setFontAttrId(R.attr.fontPath)
            .build()
    }


    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
        return gsonBuilder.create()
    }


    @Provides
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper


    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()

}
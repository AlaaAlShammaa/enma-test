package com.test.enmatest.di.component

import com.test.enmatest.di.builder.ActivityBuilder
import com.test.enmatest.di.builder.ServiceBuilder
import com.test.enmatest.di.module.AppModule
import android.app.Application
import com.test.enmatest.EnmaApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class), (AppModule::class), (ActivityBuilder::class), (ServiceBuilder::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: EnmaApp)
}
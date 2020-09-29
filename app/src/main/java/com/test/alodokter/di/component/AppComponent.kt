package com.test.alodokter.di.component

import android.app.Application
import com.test.alodokter.App
import com.test.alodokter.di.builder.ActivityBuilder
import com.test.alodokter.di.builder.FragmentBuilder
import com.test.alodokter.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class, FragmentBuilder::class])
interface AppComponent {
    fun inject(app: App?)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application?): Builder?

        fun build(): AppComponent?
    }
}
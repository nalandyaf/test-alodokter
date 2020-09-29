package com.test.alodokter

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import com.test.alodokter.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasFragmentInjector
import dagger.android.support.HasSupportFragmentInjector
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class App : Application(), HasActivityInjector,HasSupportFragmentInjector {
    @kotlin.jvm.JvmField
    @Inject
    var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>? = null
    @JvmField
    @Inject
    var mFragmentInjector: DispatchingAndroidInjector<Fragment>? = null
    @kotlin.jvm.JvmField
    @Inject
    var mCalligraphyConfig: CalligraphyConfig? = null

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector!!
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return mFragmentInjector!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        appContext = applicationContext
        DaggerAppComponent.builder()
                .application(this)
                ?.build()
                ?.inject(this)
        CalligraphyConfig.initDefault(mCalligraphyConfig)
    }

    companion object {
        var appContext: Context? = null
            private set
        var instance: App? = null
            private set

    }


}
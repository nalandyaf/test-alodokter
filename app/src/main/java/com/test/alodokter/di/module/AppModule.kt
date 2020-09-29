package com.test.alodokter.di.module

import android.app.Application
import android.content.Context
import com.test.alodokter.R
import com.test.alodokter.utils.AndroidUtils
import com.test.alodokter.utils.AppSchedulerProvider
import com.test.alodokter.utils.SchedulerProvider
import dagger.Module
import dagger.Provides
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }

    @Provides
    @Singleton
    fun provideCalligraphyDefaultConfig(): CalligraphyConfig {
        return CalligraphyConfig.Builder()
                .setDefaultFontPath(AndroidUtils.getString(R.string.font_path_caviardreams))
                .setFontAttrId(R.attr.fontPath)
                .build()
    }
}
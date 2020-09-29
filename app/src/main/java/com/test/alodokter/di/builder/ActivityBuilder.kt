package com.test.alodokter.di.builder

import com.test.alodokter.ui.login.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [])
    abstract fun bindLoginActivity(): LoginActivity?
}
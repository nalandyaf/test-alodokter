package com.test.alodokter.di.builder

import com.test.alodokter.ui.main.ui.home.HomeFragment
import com.test.alodokter.ui.main.ui.home.detail.ImageDetailFragment
import com.test.alodokter.ui.main.ui.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class FragmentBuilder {

    @ContributesAndroidInjector(modules = [])
    abstract fun bindHomeFragment(): HomeFragment?

    @ContributesAndroidInjector(modules = [])
    abstract fun bindProfileFragment(): ProfileFragment?

    @ContributesAndroidInjector(modules = [])
    abstract fun bindDetailImage(): ImageDetailFragment?


}
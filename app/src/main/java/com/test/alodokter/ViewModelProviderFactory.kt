package com.test.alodokter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import com.test.alodokter.data.remote.UserRepository
import com.test.alodokter.domain.mappers.UserMapper
import com.test.alodokter.domain.usecases.user.IUserUsecases
import com.test.alodokter.domain.usecases.user.UserUsecases
import com.test.alodokter.ui.login.LoginViewModel
import com.test.alodokter.ui.main.ui.home.HomeViewModel
import com.test.alodokter.ui.main.ui.home.detail.ImageDetailViewModel
import com.test.alodokter.ui.main.ui.profile.ProfileViewModel
import com.test.alodokter.utils.SchedulerProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelProviderFactory @Inject constructor(private val schedulerProvider: SchedulerProvider) : NewInstanceFactory() {
    private val userUsecases: IUserUsecases
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(userUsecases, schedulerProvider) as T
        } else if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(null, schedulerProvider) as T
        } else if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            return ProfileViewModel(null, schedulerProvider) as T
        } else if (modelClass.isAssignableFrom(ImageDetailViewModel::class.java)) {
            return ImageDetailViewModel(null, schedulerProvider) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

    init {
        userUsecases = UserUsecases(UserMapper(), UserRepository.instance!!)
    }
}
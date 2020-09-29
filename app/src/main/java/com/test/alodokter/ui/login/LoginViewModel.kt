package com.test.alodokter.ui.login

import android.text.Editable
import androidx.databinding.ObservableField
import com.test.alodokter.data.local.PreferencesManager
import com.test.alodokter.domain.usecases.user.IUserUsecases
import com.test.alodokter.ui.base.BaseViewModel
import com.test.alodokter.utils.SchedulerProvider
import com.test.alodokter.utils.StringUtils

class LoginViewModel(baseUsecase: IUserUsecases, schedulerProvider: SchedulerProvider) : BaseViewModel<IUserUsecases?, LoginNavigator?>(baseUsecase, schedulerProvider) {

    var username = ObservableField<String>()
    var password = ObservableField<String>()
    var validUser = ObservableField<Boolean>()
    var validPassword = ObservableField<Boolean>()

    var preferencesManager: PreferencesManager? = PreferencesManager.instance


    override fun defineLayout() {
    }

    fun afterUsernameChanged(s: Editable) {
        username.set(s.toString())
        checkUsername()
    }

    private fun checkUsername() {
        if (username.get()?.length!! < 6) {
            navigator!!.errorUsername()
            validUser.set(false)
        } else {
            validUser.set(true)
        }
    }

    fun afterPasswordChanged(s: Editable) {
        password.set(s.toString())
        checkPassword()
    }

    private fun checkPassword() {
        if (password.get()?.length!! < 8) {
            navigator!!.errorPassword()
            validPassword.set(false)
        } else {
            validPassword.set(true)
        }

    }

    fun login() {
        preferencesManager?.prefUsername = username.get()!!
        navigator?.navigateToMain()
    }

    fun checkLogin() {
       if (StringUtils.isNotBlank(preferencesManager?.prefUsername)){
            navigator?.navigateToMain()
       }
    }

}
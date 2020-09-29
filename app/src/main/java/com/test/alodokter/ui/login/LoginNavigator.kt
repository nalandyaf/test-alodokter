package com.test.alodokter.ui.login

import com.test.alodokter.ui.base.BaseNavigator

interface LoginNavigator : BaseNavigator {
    fun login()
    fun errorUsername()
    fun errorPassword()
    fun showToast()
    fun navigateToMain()
}
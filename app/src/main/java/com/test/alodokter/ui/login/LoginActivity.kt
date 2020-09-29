package com.test.alodokter.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.test.alodokter.BR
import com.test.alodokter.R
import com.test.alodokter.ViewModelProviderFactory
import com.test.alodokter.databinding.ActivityLoginBinding
import com.test.alodokter.ui.base.BaseActivity
import com.test.alodokter.ui.main.MainActivity
import javax.inject.Inject

class LoginActivity : BaseActivity<ActivityLoginBinding?, LoginViewModel>(), LoginNavigator {
    @kotlin.jvm.JvmField
    @Inject
    var factory: ViewModelProviderFactory? = null
    private var mLoginViewModel: LoginViewModel? = null
    private var mActivityLoginBinding: ActivityLoginBinding? = null
    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_login

    override val viewModel: LoginViewModel
        get() {
            mLoginViewModel = ViewModelProviders.of(this, factory).get(LoginViewModel::class.java)
            return mLoginViewModel!!
        }

    override fun handleError(throwable: Throwable?) {

    }

    override fun login() {}
    override fun errorEmail() {
        viewDataBinding?.username?.error = "Email tidak Valid"
    }

    override fun errorPassword() {
        viewDataBinding?.password?.error = "Minimal 8 Karakter"
    }

    override fun showToast() {
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
    }

    override fun navigateToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        this.finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityLoginBinding = viewDataBinding
        mLoginViewModel!!.setNavigator(this)
        viewModel.checkLogin()
    }

    companion object {
        fun newIntent(context: Context?): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }
}
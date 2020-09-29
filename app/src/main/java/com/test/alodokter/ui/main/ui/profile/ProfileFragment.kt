package com.test.alodokter.ui.main.ui.profile

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.test.alodokter.BR
import com.test.alodokter.R
import com.test.alodokter.ViewModelProviderFactory
import com.test.alodokter.databinding.FragmentProfileBinding
import com.test.alodokter.ui.base.BaseFragment
import javax.inject.Inject


class ProfileFragment : BaseFragment<FragmentProfileBinding?, ProfileViewModel>(), ProfileNavigator {

    @JvmField
    @Inject
    var factory: ViewModelProviderFactory? = null

    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.fragment_profile
    override val viewModel: ProfileViewModel
        get() = ViewModelProvider(this, factory!!).get(ProfileViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setNavigator(this)
    }

    override fun handleError(throwable: Throwable?) {
    }
}
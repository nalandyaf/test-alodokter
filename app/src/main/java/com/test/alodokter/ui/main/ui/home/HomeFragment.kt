package com.test.alodokter.ui.main.ui.home

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.test.alodokter.BR
import com.test.alodokter.R
import com.test.alodokter.ViewModelProviderFactory
import com.test.alodokter.databinding.FragmentHomeBinding
import com.test.alodokter.domain.models.ImageList
import com.test.alodokter.ui.base.BaseFragment
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding?, HomeViewModel>(), HomeNavigator {

    @JvmField
    @Inject
    var factory: ViewModelProviderFactory? = null

    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.fragment_home

    override val viewModel: HomeViewModel
        get() = ViewModelProvider(this, factory!!).get(HomeViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setNavigator(this)
    }

    override fun navigateToDetail(item: ImageList) {
        var bundle = Bundle()
        bundle.putSerializable("data", item)
        findNavController().navigate(R.id.to_detail_image, bundle)
    }

    override fun handleError(throwable: Throwable?) {

    }

}
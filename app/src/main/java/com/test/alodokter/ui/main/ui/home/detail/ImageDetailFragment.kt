package com.test.alodokter.ui.main.ui.home.detail

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.test.alodokter.BR
import com.test.alodokter.R
import com.test.alodokter.ViewModelProviderFactory
import com.test.alodokter.databinding.FragmentDetailImageBinding
import com.test.alodokter.domain.models.ImageList
import com.test.alodokter.ui.base.BaseFragment
import javax.inject.Inject

class ImageDetailFragment : BaseFragment<FragmentDetailImageBinding?, ImageDetailViewModel>(), ImageDetailNavigator {

    @JvmField
    @Inject
    var factory: ViewModelProviderFactory? = null

    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.fragment_detail_image

    override val viewModel: ImageDetailViewModel
        get() = ViewModelProvider(this, factory!!).get(ImageDetailViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setNavigator(this)
        viewModel.initData(arguments?.get("data") as ImageList)
    }

    override fun handleError(throwable: Throwable?) {

    }

}
package com.test.alodokter.ui.main.ui.home

import com.test.alodokter.common.DummyData
import com.test.alodokter.databinding.ItemListBinding
import com.test.alodokter.domain.models.ImageList
import com.test.alodokter.ui.base.BaseViewModel
import com.test.alodokter.ui.main.ui.home.adapter.AdapterListImage
import com.test.alodokter.utils.SchedulerProvider

class HomeViewModel(baseUsecase: Any?, schedulerProvider: SchedulerProvider) : BaseViewModel<Any?, HomeNavigator?>(baseUsecase, schedulerProvider) {


    override fun defineLayout() {

    }

    fun getAdapter(): AdapterListImage {
        return AdapterListImage(DummyData.getImageList(), ::detailList)
    }

    fun detailList(item: ImageList, binding: ItemListBinding) {
        navigator?.navigateToDetail(item)
    }


}
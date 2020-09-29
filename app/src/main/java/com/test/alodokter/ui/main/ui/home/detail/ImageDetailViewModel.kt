package com.test.alodokter.ui.main.ui.home.detail

import com.test.alodokter.common.DummyData
import com.test.alodokter.domain.models.ImageList
import com.test.alodokter.ui.base.BaseViewModel
import com.test.alodokter.utils.SchedulerProvider

class ImageDetailViewModel(baseUsecase: Any?, schedulerProvider: SchedulerProvider) :
        BaseViewModel<Any?, ImageDetailNavigator?>(baseUsecase, schedulerProvider) {

    var data: ArrayList<ImageList> = ArrayList()

    override fun defineLayout() {
    }

    fun initData(imageList: ImageList) {
        when (imageList.id) {
            1 -> {
                data = DummyData.getImageManchester()
            }
            2 -> {
                data = DummyData.getImageManchesterCity()
            }
            3 -> {
                data = DummyData.getImageLiverpool()
            }
        }
    }
}
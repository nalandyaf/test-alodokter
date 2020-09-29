package com.test.alodokter.ui.main.ui.home

import com.test.alodokter.domain.models.ImageList
import com.test.alodokter.ui.base.BaseNavigator

interface HomeNavigator : BaseNavigator {
    abstract fun navigateToDetail(item: ImageList)
}
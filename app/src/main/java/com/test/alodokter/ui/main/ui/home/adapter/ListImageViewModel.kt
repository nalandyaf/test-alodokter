package com.test.alodokter.ui.main.ui.home.adapter


import androidx.databinding.ObservableField
import com.test.alodokter.databinding.ItemListBinding
import com.test.alodokter.domain.models.ImageList
import java.util.*

class ListImageViewModel(itemData: ImageList?, actionDetail: (ImageList, ItemListBinding) -> Unit,
                         binding: ItemListBinding) : Observable() {

    val imageDrawable = ObservableField<Int>()
    var data: ImageList? = itemData
    var actionDetail: (ImageList, ItemListBinding) -> Unit = actionDetail
    var binding: ItemListBinding = binding

    init {
        imageDrawable.set(data?.imageSrc)
    }

    fun goDetail() {
        with(binding) {
            executePendingBindings()
        }
        actionDetail(data!!, binding)
    }

}
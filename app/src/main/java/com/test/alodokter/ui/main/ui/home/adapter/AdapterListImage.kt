package com.test.alodokter.ui.main.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.alodokter.databinding.ItemListBinding
import com.test.alodokter.domain.models.ImageList
import com.test.alodokter.ui.base.BaseAdapter

class AdapterListImage(data: ArrayList<ImageList>, action: (ImageList, ItemListBinding) -> Unit) : BaseAdapter<ImageList>(data) {

    private val action: (ImageList, ItemListBinding) -> Unit = action
    private lateinit var binding: ItemListBinding

    override fun createHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemListBinding.inflate(LayoutInflater.from(parent.context),
                parent, false)
        genericViewHolder = GenericViewHolder(binding)
        return genericViewHolder
    }

    override fun bindingViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        binding.viewModel = ListImageViewModel(getItem(position), action, binding)
        genericViewHolder.bind(position)
    }
}
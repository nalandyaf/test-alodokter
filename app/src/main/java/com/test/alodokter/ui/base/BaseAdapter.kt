package com.test.alodokter.ui.base

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<M>(dataList: ArrayList<M>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var listData = mutableListOf<M>().apply { addAll(dataList) }
    lateinit var genericViewHolder: GenericViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return createHolder(parent, viewType)
    }

    abstract fun createHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        bindingViewHolder(holder, position)
    }

    fun getItem(position: Int): M? {
        return listData[position]
    }

    fun addItems(datas: List<M>) {
        listData.addAll(datas)
        notifyItemRangeInserted(0, datas.size)
    }

    @SuppressLint("CheckResult")
    fun clearItems() {
        var totalItem = itemCount;
        listData.clear()
        notifyItemRangeRemoved(0, totalItem)
    }

    abstract fun bindingViewHolder(holder: RecyclerView.ViewHolder, position: Int)

    inner class GenericViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        private var itemData: M? = null
        fun bind(position: Int) {
            itemData = listData[position]
        }

    }
}
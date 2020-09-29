package com.test.alodokter.ui.main.ui.home.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.smarteist.autoimageslider.SliderViewAdapter
import com.test.alodokter.R
import com.test.alodokter.domain.models.ImageList
import com.test.alodokter.ui.main.ui.home.detail.SliderAdapter.SliderAdapterVH

class SliderAdapter(data: ArrayList<ImageList>) : SliderViewAdapter<SliderAdapterVH>() {

    private var items: ArrayList<ImageList> = data

    fun renewItems(sliderItems: ArrayList<ImageList>) {
        items = sliderItems
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        items.removeAt(position)
        notifyDataSetChanged()
    }

    fun addItem(sliderItem: ImageList) {
        items.add(sliderItem)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.image_slider_layout_item, null)
        return SliderAdapterVH(inflate)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
        val (imageSrc) = items[position]
        viewHolder.image.setImageResource(imageSrc)
    }

    override fun getCount(): Int {
        return items.size
    }

    class SliderAdapterVH(itemView: View) : ViewHolder(itemView) {
        var image: ImageView

        init {
            image = itemView.findViewById(R.id.image)
        }
    }

}
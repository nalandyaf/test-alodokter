package com.test.alodokter.common


import com.test.alodokter.R
import com.test.alodokter.domain.models.ImageList

object DummyData {


    fun getImageList(): ArrayList<ImageList> {
        return arrayListOf(
                ImageList(R.drawable.manchester_united, 1),
                ImageList(R.drawable.manchester_city, 2),
                ImageList(R.drawable.livepoorl, 3))
    }

    fun getImageManchester(): ArrayList<ImageList> {
        return arrayListOf(
                ImageList(R.drawable.wayne_rooney, 1),
                ImageList(R.drawable.gigis, 2),
                ImageList(R.drawable.vandersar, 3))
    }

    fun getImageManchesterCity(): ArrayList<ImageList> {
        return arrayListOf(
                ImageList(R.drawable.debryune, 1),
                ImageList(R.drawable.sterling, 2),
                ImageList(R.drawable.aguero, 3))
    }

    fun getImageLiverpool(): ArrayList<ImageList> {
        return arrayListOf(
                ImageList(R.drawable.gerard, 1),
                ImageList(R.drawable.salah, 2),
                ImageList(R.drawable.mane, 3))
    }


}
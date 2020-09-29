package com.test.alodokter.domain.entities

import com.google.gson.annotations.SerializedName

open class BaseObjectEntity {
    @SerializedName("id")
    var id: String? = null
    var createdAt: String? = null
    var updatedAt: String? = null
    var message: String? = null
    var foo: String? = null
    var count: Long = 0
    var code = 0
}
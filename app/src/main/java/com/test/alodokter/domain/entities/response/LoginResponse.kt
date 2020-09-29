package com.test.alodokter.domain.entities.response

import com.test.alodokter.domain.entities.BaseObjectEntity
import com.google.gson.annotations.SerializedName

data class LoginResponse(
        @SerializedName("jwt")
        val jwt: String? = null
): BaseObjectEntity()
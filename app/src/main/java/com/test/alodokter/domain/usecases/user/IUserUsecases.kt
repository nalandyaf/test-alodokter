package com.test.alodokter.domain.usecases.user

import com.test.alodokter.domain.entities.response.RegistrationResponse
import com.test.alodokter.domain.exceptions.MapperException
import com.test.alodokter.domain.models.User
import io.reactivex.Single

abstract class IUserUsecases {
    @get:Throws(MapperException::class)
    abstract val user: Single<User?>?

    @Throws(MapperException::class)
    abstract fun login(username: String?, password: String?): Single<Boolean?>

    @Throws(MapperException::class)
    abstract fun registration(email: String?, username: String?, password: String?): Single<RegistrationResponse?>?
}
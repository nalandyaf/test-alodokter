package com.test.alodokter.domain.usecases.user

import com.test.alodokter.data.local.PreferencesManager
import com.test.alodokter.data.remote.UserRepository
import com.test.alodokter.domain.entities.requests.LoginRequest
import com.test.alodokter.domain.entities.requests.RegistrationRequest
import com.test.alodokter.domain.entities.response.LoginResponse
import com.test.alodokter.domain.entities.response.RegistrationResponse
import com.test.alodokter.domain.mappers.UserMapper
import com.test.alodokter.domain.models.User
import io.reactivex.Single

class UserUsecases(private val mapper: UserMapper, private val repository: UserRepository?) : IUserUsecases() {
    override val user: Single<User?>?
        get() = null

    override fun login(username: String?, password: String?): Single<Boolean?> {
        return repository!!.login(LoginRequest(username, password))!!.flatMap { response: LoginResponse? ->
            if (response?.jwt != null) {
                PreferencesManager.instance!!.prefToken = (response.jwt)
                return@flatMap Single.just(true)
            }
            Single.just(false)
        }
    }

    override fun registration(email: String?, username: String?, password: String?): Single<RegistrationResponse?>? {
        return repository!!.registration(RegistrationRequest(username, email, password))
    }

}
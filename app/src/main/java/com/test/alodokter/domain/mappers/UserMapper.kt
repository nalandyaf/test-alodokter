package com.test.alodokter.domain.mappers

import com.test.alodokter.domain.entities.UserEntity
import com.test.alodokter.domain.exceptions.MapperException
import com.test.alodokter.domain.models.User

class UserMapper : BaseMapper<UserEntity?, User?>() {
    override fun createObject(): User? {
        return null
    }

    override fun createEntity(): UserEntity? {
        return null
    }

    @Throws(MapperException::class)
    override fun defineObject(`object`: User?): User? {
        return null
    }

    @Throws(MapperException::class)
    override fun defineEntity(entity: UserEntity?): UserEntity? {
        return null
    }
}
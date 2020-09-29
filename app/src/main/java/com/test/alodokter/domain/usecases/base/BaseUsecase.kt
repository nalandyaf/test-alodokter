package com.test.alodokter.domain.usecases.base

import com.test.alodokter.data.remote.BaseRepository
import com.test.alodokter.domain.mappers.BaseMapper

abstract class BaseUsecase<M : BaseMapper<*, *>?, R : BaseRepository<*>?>(protected var mapper: M, protected var repository: R)
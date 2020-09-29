package com.test.alodokter.domain.exceptions

/**
 * Exception is thrown when an error occurs while reading file from local storage
 */
class FileReaderException(message: String?) : Exception(message)
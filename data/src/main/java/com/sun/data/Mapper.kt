package com.sun.data

abstract class Mapper<out E : Any, L : Any, R : Any> {
    abstract fun mapToEntity(): E

    open fun mapToLocal(): L? {
        return null
    }

    open fun mapToRemote(): R? {
        return null
    }
}

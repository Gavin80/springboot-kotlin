package com.first.kotlin.dao

import com.first.kotlin.po.User
import org.springframework.stereotype.Component

@Component
interface UserDao {
    fun get(id: Int): User
}
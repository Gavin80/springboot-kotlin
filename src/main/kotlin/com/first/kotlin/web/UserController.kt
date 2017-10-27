package com.first.kotlin.web

import com.first.kotlin.dao.UserDao
import com.first.kotlin.po.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("user")
open class UserController {
    @Autowired
    lateinit open var userDao: UserDao

    @GetMapping
    @ResponseBody
    fun get(): User {
      return userDao.get(1)
    }
}
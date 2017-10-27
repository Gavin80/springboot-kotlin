package com.first.kotlin

import com.alibaba.druid.pool.DruidDataSource
import org.mybatis.spring.annotation.MapperScan
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment
import javax.sql.DataSource

@SpringBootApplication
@MapperScan("com.first.kotlin.dao")
open class KotlinApplication {
    @Autowired
    lateinit open var env: Environment

    @Bean
    fun dataSource(): DataSource {
        var dataSource = DruidDataSource()
        dataSource.url = env.getProperty("spring.datasource.url")
        dataSource.username = env.getProperty("spring.datasource.username")
        dataSource.password = env.getProperty("spring.datasource.password")
        dataSource.driverClassName = env.getProperty("spring.datasource.driver-class-name")
        dataSource.initialSize = 2
        dataSource.maxActive = 20
        dataSource.minIdle = 0
        dataSource.maxWait = 30000
        dataSource.validationQuery = "select 1"
        dataSource.isTestWhileIdle = true
        dataSource.isPoolPreparedStatements = false //是否缓存preparedStatement
        return dataSource
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(KotlinApplication::class.java, *args)
}



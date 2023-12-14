package com.example.cp3.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import javax.sql.DataSource

@Configuration
class DataSourceConfig {
    @Primary
    @Bean
    @ConfigurationProperties("spring.db1.datasource")
    fun dataSource(): DataSource {
        val dataSource = DataSourceBuilder.create().type(HikariDataSource::class.java).build()

        // UTF-8이 아닌 레거시 데이터베이스에 연결시 한글 문자열을 온전히 처리하기 위해 사용
        dataSource.connectionInitSql = "SET NAMES utf8mb4"

        return dataSource;
    }
}
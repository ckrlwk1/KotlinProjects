package com.example.cp3.test.mapper

import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Repository

@Mapper
interface TestMapper {
    fun test(): List<String>
}
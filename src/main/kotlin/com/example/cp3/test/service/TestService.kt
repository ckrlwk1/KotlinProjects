package com.example.cp3.test.service

import com.example.cp3.common.BusinessCode
import com.example.cp3.test.vo.UserVo

interface TestService {
    fun test(userVo: UserVo): BusinessCode

    fun test3(): BusinessCode

}
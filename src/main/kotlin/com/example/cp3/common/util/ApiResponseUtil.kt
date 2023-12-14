package com.example.cp3.common.util

import com.example.cp3.common.BusinessCode
import com.example.cp3.test.vo.UserVo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody

class ApiResponseUtil    {
    fun getResponseEntity ( businessCode: BusinessCode): ResponseEntity<*>{

        return ResponseEntity(businessCode, businessCode.id);
    }


}
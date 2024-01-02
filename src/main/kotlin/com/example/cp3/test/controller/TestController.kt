package com.example.cp3.test.controller


import com.example.cp3.common.BusinessCode
import com.example.cp3.common.Code
import com.example.cp3.common.util.ApiResponseUtil
import com.example.cp3.test.mapper.TestMapper
import com.example.cp3.test.service.TestService
import com.example.cp3.test.vo.UserVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class testController {

    var apireponseUtil = ApiResponseUtil();

    @Autowired
    private lateinit var testMapper: TestMapper;

    @Autowired
    private lateinit var testService: TestService;

    @PostMapping("/test")
    fun save_word(@RequestBody userVo: UserVo): String {



        val test = testMapper.test();
        println("=================================================================================DSS")
        println(test);
        val userVo1 = UserVo(id = null, name = null, email = null, password = null,"33");

        userVo1.password = "123123";


        return userVo1.password ?: "";
    }

    @PostMapping("/apiTest")
    fun apiTest(@RequestBody userVo: UserVo): ResponseEntity<*> {

        val code = BusinessCode(Code.ServiceError.ORDER, Code.CodeName.ERR_PARAM)


        return ResponseEntity(code, code.id);
    }


    @PostMapping("/apiTest1")
    fun apiTest1(@RequestBody userVo: UserVo): ResponseEntity<*> {



//    try {
//        var businessCode =
////            throw ApiException(Code.ServiceError.API, Code.CodeName.ERR_NOT_FOUND)
//        } catch (e: ApiException) {
//            businessCode = e.error ?: BusinessCode(Code.ServiceError.API, Code.CodeName.ERR_SERVER)
//        } catch (e : Exception) {
//            businessCode = BusinessCode(Code.ServiceError.API, Code.CodeName.ERR_SERVER)
//        }


        return apireponseUtil.getResponseEntity(testService.test(userVo));
    }

    @PostMapping("/restTemplateTest")
    fun restTemplateTest(@RequestBody userVo: UserVo): ResponseEntity<*> {

        val code = BusinessCode(Code.ServiceError.ORDER, Code.CodeName.SUCCESS)



        return apireponseUtil.getResponseEntity(testService.test3());
    }


    @RequestMapping("/api/hello")
    fun hello(): ResponseEntity<*> {
        return apireponseUtil.getResponseEntity(BusinessCode(Code.ServiceError.ORDER, Code.CodeName.SUCCESS, "hello"));
    }

    @RequestMapping("/api/hello2")
    fun hello2(): ResponseEntity<*> {
        return apireponseUtil.getResponseEntity(BusinessCode(Code.ServiceError.ORDER, Code.CodeName.SUCCESS, "hello2"));
    }

    @RequestMapping("/api/hello3")
    fun hello3(): ResponseEntity<*> {
        return apireponseUtil.getResponseEntity(BusinessCode(Code.ServiceError.ORDER, Code.CodeName.SUCCESS, "hello3"));
    }

}


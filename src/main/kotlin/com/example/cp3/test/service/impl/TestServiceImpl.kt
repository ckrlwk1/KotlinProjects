package com.example.cp3.test.service.impl




import com.example.cp3.common.BusinessCode
import com.example.cp3.common.Code
import com.example.cp3.common.exception.ApiException
import com.example.cp3.test.mapper.TestMapper
import com.example.cp3.test.service.TestService
import com.example.cp3.test.vo.UserVo
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.*
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.RestTemplate
import java.util.*


@Service
class TestServiceImpl : TestService {

    @Autowired
    private lateinit var restTemplate: RestTemplate

    @Autowired
    private lateinit var testMapper: TestMapper

    override fun test(userVo: UserVo): BusinessCode {

        var list = testMapper.test();
        var code = BusinessCode(Code.ServiceError.API, Code.CodeName.SUCCESS, list)


        try {
            // 예외가 발생할 수 있는 코드
            list = emptyList();
            println(list);

            test3();

            if (list.size < 1) {
                throw ApiException(Code.ServiceError.API, Code.CodeName.ERR_LOGIN)
            }
        } catch (e: ApiException) {
            code = e.error ?: BusinessCode(Code.ServiceError.API, Code.CodeName.ERR_SERVER)
        } catch (e: Exception) {
            code = BusinessCode(Code.ServiceError.API, Code.CodeName.ERR_SERVER)
        }

        return code;
    }


    override fun test3() : BusinessCode {

        var response = sendPost();

        throw ApiException(Code.ServiceError.API, Code.CodeName.SUCCESS)
    }

    fun sendPost(): String? {
        val url = "http://52.231.49.135:8080/order"

        // Create a new User instance with the provided name
        val newUser = UserVo(1,"b","c","d","test");


        // Set headers if needed
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        headers.accept = Collections.singletonList(MediaType.APPLICATION_JSON)

        val mapper = ObjectMapper();
        val jsonString = mapper.writeValueAsString(newUser)

        val requestEntity = HttpEntity(jsonString, headers)
        var response = "";
        // Make a POST request to create the user

        try {
            val responseEntity: ResponseEntity<String> =
                restTemplate.exchange(url, HttpMethod.POST, requestEntity, String::class.java)
            println("-------------------------")
            println(responseEntity.body)
            response = responseEntity.body.toString();
        } catch (e : HttpClientErrorException){
            response = e.responseBodyAsString;
        } catch (e : Exception){

        }



        return response;
    }


}
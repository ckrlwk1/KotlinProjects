package com.example.cp3.board.service.impl




import com.example.cp3.board.mapper.BoardMapper
import com.example.cp3.board.service.BoardService
import com.example.cp3.board.vo.BoardVo
import com.example.cp3.common.BusinessCode
import com.example.cp3.common.Code
import com.example.cp3.common.exception.ApiException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.*
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.util.*


@Service
class BoardServiceImpl : BoardService {

    @Autowired
    private lateinit var restTemplate: RestTemplate

    @Autowired
    private lateinit var boardMapper: BoardMapper


    override fun getBoardList(boardVo: BoardVo): BusinessCode {
        println("boardVo------------------------1111111111111111111111111 : " + boardVo )


        var list : List<BoardVo> = boardMapper.getBoardList(boardVo);

        println("boardVo------------------------ : " + list.size)



//        var list = boardMapper.test();
//        var code = BusinessCode(Code.ServiceError.API, Code.CodeName.SUCCESS, list)
//
//
//        try {
//            // 예외가 발생할 수 있는 코드
//            list = emptyList();
//            println(list);
//
//            test3();
//
//            if (list.size < 1) {
//                throw ApiException(Code.ServiceError.API, Code.CodeName.ERR_LOGIN)dsadasd
//            }
//        } catch (e: ApiException) {
//            code = e.error ?: BusinessCode(Code.ServiceError.API, Code.CodeName.ERR_SERVER)
//        } catch (e: Exception) {
//            code = BusinessCode(Code.ServiceError.API, Code.CodeName.ERR_SERVER)
//        }

        return BusinessCode(Code.ServiceError.API, Code.CodeName.SUCCESS, list);
    }

//    override fun getBoardList(boardVo: BoardVo): BusinessCode {
//
//        var list = testMapper.test();
//        var code = BusinessCode(Code.ServiceError.API, Code.CodeName.SUCCESS, list)
//
//
//        try {
//            // 예외가 발생할 수 있는 코드
//            list = emptyList();
//            println(list);
//
//            test3();
//
//            if (list.size < 1) {
//                throw ApiException(Code.ServiceError.API, Code.CodeName.ERR_LOGIN)
//            }
//        } catch (e: ApiException) {
//            code = e.error ?: BusinessCode(Code.ServiceError.API, Code.CodeName.ERR_SERVER)
//        } catch (e: Exception) {
//            code = BusinessCode(Code.ServiceError.API, Code.CodeName.ERR_SERVER)
//        }
//
//        return code;
//    }




}
package com.example.cp3.board.controller


import com.example.cp3.board.service.BoardService
import com.example.cp3.board.vo.BoardVo
import com.example.cp3.common.util.ApiResponseUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/board")
class BoardController {

    var apireponseUtil = ApiResponseUtil();


    @Autowired
    private lateinit var boardService: BoardService;

    @PostMapping("/getBoardList")
    fun getBoardList(@RequestBody boardVo: BoardVo): ResponseEntity<*> {

        return apireponseUtil.getResponseEntity(boardService.getBoardList(boardVo));
    }



}


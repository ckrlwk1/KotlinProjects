package com.example.cp3.board.service

import com.example.cp3.board.vo.BoardVo
import com.example.cp3.common.BusinessCode
import com.example.cp3.test.vo.UserVo

interface BoardService {
    fun getBoardList(boardVo: BoardVo): BusinessCode

}
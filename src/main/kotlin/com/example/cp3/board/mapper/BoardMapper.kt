package com.example.cp3.board.mapper

import com.example.cp3.board.vo.BoardVo
import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Repository

@Mapper
interface BoardMapper {
    fun getBoardList(boardVo: BoardVo): List<BoardVo>


}
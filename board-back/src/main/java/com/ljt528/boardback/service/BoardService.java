package com.ljt528.boardback.service;

import org.springframework.http.ResponseEntity;

import com.ljt528.boardback.dto.request.board.PostBoardRequestDto;
import com.ljt528.boardback.dto.response.board.GetBoardResponseDto;
import com.ljt528.boardback.dto.response.board.PostBoardResponseDto;

public interface BoardService {

    ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);
    ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email);

}

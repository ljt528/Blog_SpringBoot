package com.ljt528.boardback.service;

import org.springframework.http.ResponseEntity;

import com.ljt528.boardback.dto.request.board.PostBoardRequestDto;
import com.ljt528.boardback.dto.response.board.GetBoardResponseDto;
import com.ljt528.boardback.dto.response.board.GetFavoriteListResponseDto;
import com.ljt528.boardback.dto.response.board.PostBoardResponseDto;
import com.ljt528.boardback.dto.response.board.PutFavoriteResponseDto;

public interface BoardService {

    ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);
    ResponseEntity<? super GetFavoriteListResponseDto> getFavoriteList(Integer boardNumber);

    ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email);
    
    ResponseEntity<? super PutFavoriteResponseDto> putFavorite(Integer boardNumber, String email);

}

package com.ljt528.boardback.service;

import org.springframework.http.ResponseEntity;

import com.ljt528.boardback.dto.response.search.GetPopularListResponseDto;

public interface SearchService {
    
    ResponseEntity<? super GetPopularListResponseDto> getPopularList();

}

package com.ljt528.boardback.service;

import org.springframework.http.ResponseEntity;

import com.ljt528.boardback.dto.response.user.GetSignInUserResponseDto;

public interface UserService {

    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email);
    
}

package com.ljt528.boardback.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ljt528.boardback.dto.response.user.GetSignInUserResponseDto;
import com.ljt528.boardback.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
// 로그인한 사용자 정보 꺼내오기
public class UserController {
    
    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(
        // JwtAuthenticationFilter에서 꺼내올 수 있음
        @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super GetSignInUserResponseDto> response = userService.getSignInUser(email);
        return response;
    }

}

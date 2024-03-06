package com.ljt528.boardback.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.ljt528.boardback.dto.request.auth.SignInRequestDto;
import com.ljt528.boardback.dto.request.auth.SignUpRequestDto;
import com.ljt528.boardback.dto.response.auth.SignInResponseDto;
=======
import com.ljt528.boardback.dto.request.auth.SignUpRequestDto;
>>>>>>> 1704d27f3f5d9a44a268d4645c71d8107709670d
import com.ljt528.boardback.dto.response.auth.SignUpResponseDto;
import com.ljt528.boardback.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    
    // controller에는 비즈니스 로직이 적히면 안 됨.
    private final AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<? super SignUpResponseDto> signUp(
        @RequestBody @Valid SignUpRequestDto requestBody
    ) {
        ResponseEntity<? super SignUpResponseDto> response = authService.signUp(requestBody);
        return response;
    }
<<<<<<< HEAD

    @PostMapping("/sign-in")
    public ResponseEntity<? super SignInResponseDto> signIn(
        @RequestBody @Valid SignInRequestDto requestBody
    ) {
        ResponseEntity<? super SignInResponseDto> response = authService.signIn(requestBody);
        return response;
    }

}
=======
}
>>>>>>> 1704d27f3f5d9a44a268d4645c71d8107709670d

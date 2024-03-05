package com.ljt528.boardback.service;

import org.springframework.http.ResponseEntity;

import com.ljt528.boardback.dto.request.auth.SignUpRequestDto;
import com.ljt528.boardback.dto.response.auth.SignUpResponseDto;

import jakarta.validation.Valid;

public interface AuthService {

        // Implement 클래스와 인터페이스를 나누는 이유?
    // 인터페이스를 구현하는 클래스가 하나 밖에 없더라도 추가로 증가할 것을 생각하고 작성해야 한다.
    // SOLID원칙의 DIP원칙에 따라 높은 수준의 모듈은 낮은 수준의 모듈을 직접 의존하면 안 됨.

    // 구체적인 객체가 아닌 ? super T 를 사용하는 이유?
    // 부모 타입도 같이 반환(초반에는 생산성이 떨어진다고 생각할 수 있지만 편리한 유지보수를 위해)
    // ResponseDto 타입으로도 반환되고 특정 ResponseDto 타입으로도 반환되기 때문에 둘 다 반환하도록 지정
    
    ResponseEntity<? super SignUpResponseDto> signUp(@Valid SignUpRequestDto requestBody);
    
}

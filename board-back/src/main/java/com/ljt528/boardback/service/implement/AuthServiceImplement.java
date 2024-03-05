package com.ljt528.boardback.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ljt528.boardback.dto.request.auth.SignUpRequestDto;
import com.ljt528.boardback.dto.response.ResponseDto;
import com.ljt528.boardback.dto.response.auth.SignUpResponseDto;
import com.ljt528.boardback.entity.UserEntity;
import com.ljt528.boardback.repository.UserRepository;
import com.ljt528.boardback.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
// DB 유저 테이블에 데이터를 넣는 작업(Repository를 통해서)
public class AuthServiceImplement implements AuthService {

    // implement란? - 인터페이스의 구현체

    private final UserRepository userRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Override
    public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {

        try {

            // 이메일 존재 시 반환
            String email = dto.getEmail();
            boolean existedEmail = userRepository.existsByEmail(email);
            if (existedEmail) return SignUpResponseDto.duplicateEmail();

            // 닉네임 존재 시 반환
            String nickname = dto.getNickname();
            boolean existedNickname = userRepository.existsByNickname(nickname);
            if (existedNickname) return SignUpResponseDto.duplicateNickname();

            // 전화번호 존재 시 반환
            String telNumber = dto.getTelNumber();
            boolean existedTelNumber = userRepository.existsByTelNumber(telNumber);
            if (existedTelNumber) return SignUpResponseDto.duplicateTelNumber();

            // 패스워드 암호화
            String password = dto.getPassword();
            String encodedPassword = passwordEncoder.encode(password);
            dto.setPassword(encodedPassword);

            // 데이터베이스에 저장
            UserEntity userEntity = new UserEntity(dto);
            userRepository.save(userEntity);
        
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignUpResponseDto.success();

    }

}
package com.ljt528.boardback.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import com.ljt528.boardback.dto.request.auth.SignInRequestDto;
import com.ljt528.boardback.dto.request.auth.SignUpRequestDto;
import com.ljt528.boardback.dto.response.ResponseDto;
import com.ljt528.boardback.dto.response.auth.SignInResponseDto;
import com.ljt528.boardback.dto.response.auth.SignUpResponseDto;
import com.ljt528.boardback.entity.UserEntity;
import com.ljt528.boardback.provider.JwTProvider;
=======
import com.ljt528.boardback.dto.request.auth.SignUpRequestDto;
import com.ljt528.boardback.dto.response.ResponseDto;
import com.ljt528.boardback.dto.response.auth.SignUpResponseDto;
import com.ljt528.boardback.entity.UserEntity;
>>>>>>> 1704d27f3f5d9a44a268d4645c71d8107709670d
import com.ljt528.boardback.repository.UserRepository;
import com.ljt528.boardback.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
// DB 유저 테이블에 데이터를 넣는 작업(Repository를 통해서)
public class AuthServiceImplement implements AuthService {

    // implement란? - 인터페이스의 구현체

    private final UserRepository userRepository;
<<<<<<< HEAD
    private final JwTProvider jwtProvider;
=======
>>>>>>> 1704d27f3f5d9a44a268d4645c71d8107709670d

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
<<<<<<< HEAD

=======
        
>>>>>>> 1704d27f3f5d9a44a268d4645c71d8107709670d
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignUpResponseDto.success();

    }

<<<<<<< HEAD
    @Override
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {
        
        String token = null;

        try {

            String email = dto.getEmail();
            UserEntity userEntity = userRepository.findByEmail(email);
            if (userEntity == null) return SignInResponseDto.signInFail();

            String password = dto.getPassword();
            String encodedPassword = userEntity.getPassword();
            // 평문 패스워드와 암호화된 패스워드가 같으면 true
            boolean isMatched = passwordEncoder.matches(password, encodedPassword);
            if (!isMatched) return SignInResponseDto.signInFail();

            token = jwtProvider.create(email);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignInResponseDto.success(token);

    }
    
}
=======
}
>>>>>>> 1704d27f3f5d9a44a268d4645c71d8107709670d

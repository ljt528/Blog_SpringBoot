package com.ljt528.boardback.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ljt528.boardback.dto.request.user.PatchNicknameRequestDto;
import com.ljt528.boardback.dto.request.user.PatchProfileImageRequestDto;
import com.ljt528.boardback.dto.response.ResponseDto;
import com.ljt528.boardback.dto.response.user.GetSignInUserResponseDto;
import com.ljt528.boardback.dto.response.user.GetUserResponseDto;
import com.ljt528.boardback.dto.response.user.PatchNicknameResponseDto;
import com.ljt528.boardback.dto.response.user.PatchProfileImageResponseDto;
import com.ljt528.boardback.entity.UserEntity;
import com.ljt528.boardback.repository.UserRepository;
import com.ljt528.boardback.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {
    
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<? super GetUserResponseDto> getUser(String email) {

        UserEntity userEntity = null;
        
        try {
            
            userEntity = userRepository.findByEmail(email);
            if (userEntity == null) return GetUserResponseDto.noExistUser();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetUserResponseDto.success(userEntity);

    }

    @Override
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email) {

        UserEntity userEntity = null;

        try {
            
            userEntity = userRepository.findByEmail(email);
            if (userEntity == null) return GetSignInUserResponseDto.notExistUser();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetSignInUserResponseDto.success(userEntity);

    }

    @Override
    public ResponseEntity<? super PatchNicknameResponseDto> patchNickname(PatchNicknameRequestDto dto, String email) {

        try {
            
            UserEntity userEntity = userRepository.findByEmail(email);
            if (userEntity == null) PatchNicknameResponseDto.noExistUser();

            String nickname = dto.getNickname();
            boolean existedNickname = userRepository.existsByNickname(nickname);
            if (existedNickname) return PatchNicknameResponseDto.duplicateNickname();

            userEntity.setNickname(nickname);
            userRepository.save(userEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PatchNicknameResponseDto.success();

    }

    @Override
    public ResponseEntity<? super PatchProfileImageResponseDto> patchProfileImage(PatchProfileImageRequestDto dto, String email) {

        try {
            
            UserEntity userEntity = userRepository.findByEmail(email);
            if (userEntity == null) return PatchProfileImageResponseDto.noExistUser();

            String profileImage = dto.getProfileImage();
            
            userEntity.setProfileImage(profileImage);
            userRepository.save(userEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PatchProfileImageResponseDto.success();

    }

}

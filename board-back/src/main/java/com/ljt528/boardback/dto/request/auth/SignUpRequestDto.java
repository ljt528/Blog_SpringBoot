package com.ljt528.boardback.dto.request.auth;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignUpRequestDto {
    
    @NotBlank @Email
    private String email;

    @NotBlank @Size(min=8, max=20)
    private String password;

    @NotBlank
    private String nickname;

    // 정규식 표현 0부터 9까지 길이는 11에서 13사이로 지정
    @NotBlank @Pattern(regexp="^[0-9]{11,13}$")
    private String telNumber;
    
    @NotBlank
    private String address;

    private String addressDetail;

    // NotNull은 참조형 변수에서 사용 가능, NotBlank, NotEmpty는 문자열만 사용 가능
    // 기본형 데이터 타입이 아닌 참조형 타입인 wrapper 클래스인 Boolean 사용
    @NotNull @AssertTrue
    private Boolean agreedPersonal;

}

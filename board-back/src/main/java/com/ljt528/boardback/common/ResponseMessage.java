package com.ljt528.boardback.common;

public interface ResponseMessage {
    // 인터페이스에서는 public static final로 인식하므로 생략 가능

    // HTTP Status 200 (OK)
    String SUCCESS = "Success.";              // 성공

    // HTTP Status 400 (Bad Request)
    String VALIDATION_FAILED = "Validation failed.";    // 유효성 검증 실패
    String DUPLICATE_EMAIL = "Duplication email.";      // 중복된 이메일
    String DUPLICATE_TEL_NUMBER = "Duplication tel number."; // 중복된 전화번호
    String DUPLICATE_NICKNAME = "Duplication nickname.";   // 중복된 닉네임
    String NOT_EXISTED_USER = "This user does not exist.";     // 존재하지 않는 유저
    String NOT_EXISTED_BOARD = "This board does not exist.";    // 존재하지 않는 게시물

    // HTTP Status 401 (Unauthorized)
    String SIGN_IN_FAIL = "Login information mismatch.";         // 로그인 실패
    String AUTHORIZATION_FAIL = "Authorization failed.";   // 인증 실패

    // HTTP Status 403 (Forbidden)
    String NO_PERMISSION = "Do not have permission.";        // 권한 없음

    // HTTP Status 500 (Internal Server Error)
    String DATABASE_ERROR = "Database error.";      // 데이터베이스 에러
}

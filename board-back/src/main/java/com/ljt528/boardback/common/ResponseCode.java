package com.ljt528.boardback.common;

public interface ResponseCode {
    
    // 인터페이스에서는 public static final로 인식하므로 생략 가능

    // HTTP Status 200 (OK)
    String SUCCESS = "SU";              // 성공

    // HTTP Status 400 (Bad Request)
    String VALIDATION_FAILED = "VF";    // 유효성 검증 실패
    String DUPLICATE_EMAIL = "DE";      // 중복된 이메일
    String DUPLICATE_TEL_NUMBER = "DT"; // 중복된 전화번호
    String DUPLICATE_NICKNAME = "DN";   // 중복된 닉네임
    String NOT_EXISTED_USER = "NU";     // 존재하지 않는 유저
    String NOT_EXISTED_BOARD = "NB";    // 존재하지 않는 게시물

    // HTTP Status 401 (Unauthorized)
    String SIGN_IN_FAIL = "SF";         // 로그인 실패
    String AUTHORIZATION_FAIL = "AF";   // 인증 실패

    // HTTP Status 403 (Forbidden)
    String NO_PERMISSION = "NP";        // 권한 없음

    // HTTP Status 500 (Internal Server Error)
    String DATABASE_ERROR = "DBE";      // 데이터베이스 에러
}

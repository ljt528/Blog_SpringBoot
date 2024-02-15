enum ResponseCode {

    // HTTP Status 200 (OK)
    SUCCESS = "SU",              // 성공

    // HTTP Status 400 (Bad Request)
    VALIDATION_FAILED = "VF",    // 유효성 검증 실패
    DUPLICATE_EMAIL = "DE",      // 중복된 이메일
    DUPLICATE_TEL_NUMBER = "DT", // 중복된 전화번호
    DUPLICATE_NICKNAME = "DN",   // 중복된 닉네임
    NOT_EXISTED_USER = "NU",     // 존재하지 않는 유저
    NOT_EXISTED_BOARD = "NB",    // 존재하지 않는 게시물

    // HTTP Status 401 (Unauthorized)
    SIGN_IN_FAIL = "SF",         // 로그인 실패
    AUTHORIZATION_FAIL = "AF",   // 인증 실패

    // HTTP Status 403 (Forbidden)
    NO_PERMISSION = "NP",        // 권한 없음

    // HTTP Status 500 (Internal Server Error)
    DATABASE_ERROR = "DBE",      // 데이터베이스 에러
    
};

export default ResponseCode;
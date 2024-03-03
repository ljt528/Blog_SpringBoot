package com.ljt528.boardback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ljt528.boardback.entity.UserEntity;

// JpaRepository 첫 번째 제네릭 위치 : 어떤 엔터티의 레포지토리인지 지정, 두 번째 제네릭 위치 : 엔터티의 pk타입
@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    
    // existsBy 뒤는 WHERE절에 들어올 자리이면서 대문자로 시작해야 함.
    // user 테이블에서 email값을 찾아서 하나라도 존재하면 true 반환
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
    boolean existsByTelNumber(String telNumber);

    // 쿼리 메소드 - 메소드명을 규칙적으로 작성하면 SQL을 JPA가 자동으로 만들어줌
    // email을 UNIQUE이기 때문에 1개 또는 0개가 반드시 반환되므로 굳이 리스트로 받을 필요 없음
    UserEntity findByEmail(String email);

}

package com.ljt528.boardback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ljt528.boardback.entity.BoardEntity;
import com.ljt528.boardback.repository.resultSet.GetBoardResultSet;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{

    BoardEntity findByBoardNumber(Integer boardNumber);
    
    // 반드시 한 칸씩 띄워줘야 함
    // 네이티브 쿼리
    // 물음표1은 매개변수 boardNumber에서 첫번째 값을 넣겠다라는 의미
    @Query(
        value=
        "SELECT " +
        "B.board_number AS boardNumber, " +
        "B.title AS title, " +
        "B.content AS content, " +
        "B.write_datetime AS writeDatetime, " +
        "B.writer_email AS writerEmail, " +
        "U.nickname AS writerNickname, " +
        "U.profile_image AS writerProfileImage " +
        "FROM board AS B " +
        "INNER JOIN user AS U " +
        "ON B.writer_email = U.email " +
        "WHERE board_number = ?1 ",
        nativeQuery = true
    )
    GetBoardResultSet getBoard(Integer boardNumber);

}

package com.ljt528.boardback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ljt528.boardback.entity.CommentEntity;
import com.ljt528.boardback.repository.resultSet.GetCommentListResultSet;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer>{
    
    // JOIN 작업이 이루어지기 때문에 일반적인 쿼리메소드보다 쿼리를 직접 작성하는 것이 좋음
    @Query(
        value=
        "SELECT " +
        "    U.nickname AS nickname, " +
        "    U.profile_image AS profileImage, " +
        "    C.write_datetime AS writeDatetime, " +
        "    C.content AS content " +
        "FROM comment AS C " +
        "INNER JOIN user AS U " +
        "ON C.user_email = U.email " +
        "WHERE C.board_number = ?1 " +
        "ORDER BY writeDatetime DESC ",
        nativeQuery = true
    )
    // 물음표1로 지정하면 아래 매개변수가 들어감
    List<GetCommentListResultSet> getCommentList(Integer boardNumber);

}

package com.ljt528.boardback.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
// entity와 table은 지정해주지 않으면 class이름을 따라가기 때문에 이름을 지정해주어야 한다.
@Entity(name="board")
@Table(name="board")
public class BoardEntity {
    
    // auto increment 지정 : insert문을 보낼때 마다 자동으로 num값이 증가
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int boardNumber;
    private String title;
    private String content;
    private String writeDatetime;
    private int favoriteCount;
    private int commentCount;
    private int viewCount;
    private String writerEmail;
    
}

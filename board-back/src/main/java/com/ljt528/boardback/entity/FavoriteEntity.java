package com.ljt528.boardback.entity;

import com.ljt528.boardback.entity.primaryKey.FavoritePk;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="favorite")
@Table(name="favorite")
@IdClass(FavoritePk.class)
public class FavoriteEntity {
    
    // pk값을 넘겨줘야 하는데 String, int 둘 다 있으므로 복합키 표시
    @Id
    private String userEmail;
    @Id
    private int boardNumber;

}

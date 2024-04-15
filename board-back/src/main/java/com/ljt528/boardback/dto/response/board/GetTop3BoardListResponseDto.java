package com.ljt528.boardback.dto.response.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ljt528.boardback.common.ResponseCode;
import com.ljt528.boardback.common.ResponseMessage;
import com.ljt528.boardback.dto.object.BoardListItem;
import com.ljt528.boardback.dto.response.ResponseDto;
import com.ljt528.boardback.entity.BoardListViewEntity;

import lombok.Getter;

@Getter
public class GetTop3BoardListResponseDto extends ResponseDto {
    
    private List<BoardListItem> top3List;

    private GetTop3BoardListResponseDto(List<BoardListViewEntity> boardListViewEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.top3List = BoardListItem.getList(boardListViewEntities);
    }

    public static ResponseEntity<GetTop3BoardListResponseDto> success(List<BoardListViewEntity> boardListViewEntities) {
        GetTop3BoardListResponseDto result = new GetTop3BoardListResponseDto(boardListViewEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}

package com.ljt528.boardback.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ljt528.boardback.dto.request.board.PostBoardRequestDto;
import com.ljt528.boardback.dto.request.board.PostCommentRequestDto;
import com.ljt528.boardback.dto.response.ResponseDto;
import com.ljt528.boardback.dto.response.board.GetBoardResponseDto;
import com.ljt528.boardback.dto.response.board.GetFavoriteListResponseDto;
import com.ljt528.boardback.dto.response.board.PostBoardResponseDto;
import com.ljt528.boardback.dto.response.board.PostCommentResponseDto;
import com.ljt528.boardback.dto.response.board.PutFavoriteResponseDto;
import com.ljt528.boardback.entity.BoardEntity;
import com.ljt528.boardback.entity.CommentEntity;
import com.ljt528.boardback.entity.FavoriteEntity;
import com.ljt528.boardback.entity.ImageEntity;
import com.ljt528.boardback.repository.BoardRepository;
import com.ljt528.boardback.repository.CommentRepository;
import com.ljt528.boardback.repository.FavoriteRepository;
import com.ljt528.boardback.repository.ImageRepository;
import com.ljt528.boardback.repository.UserRepository;
import com.ljt528.boardback.repository.resultSet.GetBoardResultSet;
import com.ljt528.boardback.repository.resultSet.GetFavoriteListResultSet;
import com.ljt528.boardback.service.BoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImplement implements BoardService {

    private final BoardRepository boardRepository;
    private final ImageRepository imageRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final FavoriteRepository favoriteRepository;

    @Override
    public ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber) {
        
        GetBoardResultSet resultSet = null;
        List<ImageEntity> imageEntities = new ArrayList<>();
        
        try {

            resultSet = boardRepository.getBoard(boardNumber);
            if (resultSet == null) return GetBoardResponseDto.noExistBoard();

            imageEntities = imageRepository.findByBoardNumber(boardNumber);

            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            boardEntity.increaseViewCount();
            boardRepository.save(boardEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetBoardResponseDto.success(resultSet, imageEntities);

    }
    
    @Override
    public ResponseEntity<? super GetFavoriteListResponseDto> getFavoriteList(Integer boardNumber) {
        
        List<GetFavoriteListResultSet> resultSets = new ArrayList<>();

        try {
            
            boolean existedBoard = boardRepository.existsByBoardNumber(boardNumber);
            if (!existedBoard) return GetFavoriteListResponseDto.noExistBoard();

            resultSets = favoriteRepository.getFavoriteList(boardNumber);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetFavoriteListResponseDto.success(resultSets);

    }

    @Override
    public ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email) {

        try {

            boolean existdEmail = userRepository.existsByEmail(email);
            if (!existdEmail) return PostBoardResponseDto.notExistUser();

            BoardEntity boardEntity = new BoardEntity(dto, email);
            boardRepository.save(boardEntity);

            int boardNumber = boardEntity.getBoardNumber();

            List<String> boardImageList = dto.getBoardImageList();
            List<ImageEntity> imageEntities = new ArrayList<>();

            for (String image: boardImageList) {
                ImageEntity imageEntity = new ImageEntity(boardNumber, image);
                imageEntities.add(imageEntity);
            }
            // for문 안에 save를 작성해도 되지만 그럴 경우 DB에 접근하는 작업이 많아지기 때문에 for문 밖에 saveAll로 작성
            imageRepository.saveAll(imageEntities);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PostBoardResponseDto.success();

    }

    @Override
    public ResponseEntity<? super PostCommentResponseDto> postComment(PostCommentRequestDto dto, Integer boardNumber, String email) {
        
        try {

            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if (boardEntity == null) return PostCommentResponseDto.noExistBoard();

            boolean existedUser = userRepository.existsByEmail(email);
            if (!existedUser) return PostCommentResponseDto.noExistUser();

            CommentEntity commentEntity = new CommentEntity(dto, boardNumber, email);
            commentRepository.save(commentEntity);

            boardEntity.increaseCommentCount();
            boardRepository.save(boardEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PostCommentResponseDto.success();

    }

    @Override
    public ResponseEntity<? super PutFavoriteResponseDto> putFavorite(Integer boardNumber, String email) {
        try {
            
            // 유저 존재 확인
            boolean existedUser = userRepository.existsByEmail(email);
            if (!existedUser) return PutFavoriteResponseDto.noExistUser();

            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if (boardEntity == null) return PutFavoriteResponseDto.noExistBoard();

            FavoriteEntity favoriteEntity = favoriteRepository.findByBoardNumberAndUserEmail(boardNumber, email);
            if (favoriteEntity == null) {
                favoriteEntity = new FavoriteEntity(email, boardNumber);
                favoriteRepository.save(favoriteEntity);
                boardEntity.increaseFavoriteCount();
            }
            else {
                favoriteRepository.delete(favoriteEntity);
                boardEntity.decreaseFavoriteCount();
            }

            boardRepository.save(boardEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PutFavoriteResponseDto.success();

    }

}

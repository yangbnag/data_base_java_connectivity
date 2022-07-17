package com.spring.webmvc.springmvc.chap03_02.service;

import com.spring.webmvc.springmvc.chap03_02.domain.BoardV2;
import com.spring.webmvc.springmvc.chap03_02.repository.BoardRepositoryV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardV2Service {
    private final BoardRepositoryV2 repositoryV2;

    //게시물 전체 조회 기능
    public List<BoardV2> findAll() {
        List<BoardV2> boardV2List = repositoryV2.findAll();
        return boardV2List;

    };
    //# Board 타입의 리스트에
    // 데이터 베이스에 있는 게시물 정보를 반환해 주는 메서드


    //게시물 상세 조회 기능
    public BoardV2 findOne(int boardNo) {

        BoardV2 boardV2 = repositoryV2.findOne(boardNo);
        return boardV2;
    };
    // #회원번호를 입력 받으면 특정 게시물 객체에
    // 데이터 베이스 정보를 받아와 리턴 하는 메서드


    // 게시글 등록 요청
   public boolean save(BoardV2 boardV2){
      return repositoryV2.save(boardV2);
   };
    // #게시물 객체를 입력 받으면 데이터베이스에 게시물을
    // 등록하는 메서드
    // 등록 결과를 boolean 타입으로 리턴


    // 게시글 삭제 요청
   public boolean delete(int boardNo){
       return repositoryV2.delete(boardNo);
   };
    // #게시물 번호를 입력 받으면 해당 게시물을
    // 데이터베이스에서 삭제 후
    // 결과를 boolean 타입으로 리턴


    // 게시글 수정 요청
   public boolean update(String writer, String title, String content, int boardNo){
       return repositoryV2.update(writer,title,content,boardNo);
   };
    // # 게시물 번호를 입력 받으면 해당 게시물의
    // 내용을 데이터베스에서 수정 한 후
    // 결과 값을 boolean 타입으로 리턴}

    // 조회수 늘리기

    public boolean viewCnt(int boardNo) {
        return repositoryV2.viewCnt(boardNo);
    }


}

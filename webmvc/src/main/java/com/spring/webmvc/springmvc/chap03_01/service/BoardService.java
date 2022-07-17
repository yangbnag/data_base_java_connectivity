/*
package com.spring.webmvc.springmvc.chap03_01.service;

import com.spring.webmvc.springmvc.chap03_01.domain.Board;
import com.spring.webmvc.springmvc.chap03_01.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository repository;

    // 게시물 삭제 중간처리
    public boolean deleteService(int boardNo){
        return repository.remove(boardNo);
    }

    // 게시물 개별조회 중간처리
    public Board detailService(int boardNo){
        return repository.findOne(boardNo);
    }

    // 게시물 저장 요청 중간 처리
    public boolean saveService(Board board){

        return repository.save(board);
    }

    // 게시물 목록 요청 중간 처리
    public List<Board> listService(){
        List<Board> boardList = repository.findAll();

        return boardList;
    }

    // 게시물 수정 중간 처리
    public boolean updateService(String writer, String title, String content, int boardNo){

        return repository.update(writer,title,content,boardNo);
    }

}
*/

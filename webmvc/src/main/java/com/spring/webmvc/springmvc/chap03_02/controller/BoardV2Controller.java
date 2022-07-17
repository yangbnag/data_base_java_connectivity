package com.spring.webmvc.springmvc.chap03_02.controller;

import com.spring.webmvc.springmvc.chap03_02.domain.BoardV2;
import com.spring.webmvc.springmvc.chap03_02.service.BoardV2Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
public class BoardV2Controller {

    private final BoardV2Service service;

    // 1. 게시물 등록 및 조회 화면 열기 요청
    //* 게시물 목록요청: /board/list: GET
    @GetMapping("/board/list")
    public String list(Model model) {
        log.info("/board/list GET 요청!! - ");

        List<BoardV2> boardList = service.findAll();
        log.info("boardList - {}", boardList);

        model.addAttribute("boards", boardList);


        return "chap04/v2-list";
    }

    // 2. 게시물 상세 요청
    //* 게시물 상세조회요청: /board/content: GET
    @GetMapping("/board/content")
    public String detail(int boardNo, Model model) {
        log.info("/board/content GET 요청!!");

        service.viewCnt(boardNo);

        BoardV2 one = service.findOne(boardNo);
        log.info("boardV2 - {}", one);

        model.addAttribute("b",one);

        return "chap04/v2-content";

    }

    // 3. 게시글 쓰기 화면 요청
    //* 게시글 쓰기 화면요청: /board/write: GET
    @GetMapping("/board/write")
    public String saveForm(){
        log.info("/board/write - GET 요청!");
        return "chap04/v2-write";
    }

    // 4. 게시글 등록 요청
    //* 게시글 등록요청: /board/write: POST

    @PostMapping("/board/write")
    public String save(BoardV2 board){
        log.info("/board/write POST 요청!!");
        return service.save(board) ? "redirect:/board/list" : "redirect:/";
    }

    // 5. 게시글 삭제 요청
    //* 게시글 삭제요청: /board/delete: GET
    @GetMapping("/board/delete")
    public String delete(int boardNo){
        log.info("/board/delete GET 요청!!");
        return service.delete(boardNo)? "redirect:/board/list" : "redirect:/";
    }

    // 6. 게시글 수정화면 요청
    //* 게시글 수정화면요청: /board/modify: GET
    @GetMapping("/board/modify")
    public String modifyForm(int boardNo, Model model){
        log.info("/board/modify GET 요청!!");

        BoardV2 one = service.findOne(boardNo);
        log.info("board {}",one);

        model.addAttribute("b",one);

        return "chap04/v2-modify";
    }

    // 7. 게시글 수정요청
    //* 게시글 수정요청: /board/modify: POST
    @PostMapping("/board/modify")
    public String modify(String writer, String title, String content, int boardNo){
        log.info("/board/modify POST 요청!!");

        BoardV2 one = service.findOne(boardNo);
        log.info("writer,title,content,boardNo {}",writer+title+content+boardNo);
        int bnum = one.getBoardNo();
        log.info("수정 게시물번호{}",bnum);
        return service.update(writer,title,content,boardNo)?"redirect:/board/list":"redirect:/";
    }


}

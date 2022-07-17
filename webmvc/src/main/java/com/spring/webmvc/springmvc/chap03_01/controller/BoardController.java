/*
package com.spring.webmvc.springmvc.chap03_01.controller;

import com.spring.webmvc.servlet.chap04.ModelAndView;

import com.spring.webmvc.springmvc.chap03_01.domain.Board;
import com.spring.webmvc.springmvc.chap03_01.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    // 게시물 등록 및 조회 화면 열기 요청
    @GetMapping("/board/list")
    public String list(Model model) {
        log.info("/board/list GET 요청!! - ");

        List<Board> boardList = service.listService();
        log.info("boardList - {}", boardList);
        model.addAttribute("boards", boardList);

        return "chap03/board-list";
    }

    // 게시물 상세 요청
    @GetMapping("/board/content")
    public String detail(int boardNo, Model model) {
        log.info("/board/content GET 요청!!-");
        Board board = service.detailService(boardNo);
//        log.info("board = {}",board);

        model.addAttribute("b", board);
        return "chap03/board-content";

    }

    // 게시글 쓰기 화면 요청
    @GetMapping("/board/write")
    public String write() {
        log.info("/board/write GET 요청!! - ");
        return "chap03/board-write";
    }


    // 게시글 등록요청
    @PostMapping("/board/write")
    public String save(Board board) {
        log.info("/board/write GET 요청!!-");

        return service.saveService(board) ? "redirect:/board/list" : "redirect:";

        // form 태그에서 post 요청 메서드 설정 맞출 것.

    }

    // 게시글 삭제요청
    @GetMapping("/board/delete")
    public String delete(int boardNo) {
        log.info("/board/delete GET 요청 !! -");
        return service.deleteService(boardNo) ? "redirect:/board/list" : "redirect:/";

    }

    // 게시글 수정화면요청
    @GetMapping("/board/modify")
    public String modify(@RequestParam int boardNo, Model model) {
        log.info("/board/modify GET 요청 !! -");


        Board b = service.detailService(boardNo);
        model.addAttribute("b",b);

        log.info("게시물 정보[ ]",b);
        log.info("boardNo = ", boardNo);


        return "chap03/board-modify";
    }

    // 게시글 수정요청
    @PostMapping("/board/modify")
    public String update(String writer, String title, String content, int boardNo) {
        log.info("/board/modify POST 요청!! -" + writer + title + content + boardNo);
        Board b = service.detailService(boardNo);
        int bnum = b.getBoardNo();
        log.info(b.getBoardNo());


        return service.updateService(writer, title, content, boardNo) ? "redirect:/board/list" : "redirect:/";
    }

}
*/

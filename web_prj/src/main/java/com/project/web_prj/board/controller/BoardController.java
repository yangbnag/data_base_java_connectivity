package com.project.web_prj.board.controller;

import com.project.web_prj.board.domain.Board;
import com.project.web_prj.board.service.BoardService;
import com.project.web_prj.common.paging.Page;
import com.project.web_prj.common.paging.PageMaker;
import com.project.web_prj.common.search.Search;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService service;

    //게시물 목록 요청
    @GetMapping("/list")
    public String list(Search search, Model model) {
        log.info("controller request /board/list GET! - page : {}", search);
        Map<String, Object> boardMap = service.findAllService(search);
        log.debug("return data - {}", boardMap);

        //페이지 정보 생성
        PageMaker pm = new PageMaker(new Page(search.getPageNum(),search.getAmount()), (Integer) boardMap.get("tc"));
        log.info("tc{}",boardMap.get("tc"));

        model.addAttribute("bList", boardMap.get("bList"));
        model.addAttribute("pm", pm);

        return "board/board-list";
    }

    // 게시물 상세 조회 요청
    @GetMapping("/content/{boardNo}")
    public String content(@PathVariable Long boardNo,
                          @ModelAttribute("p") Page page, Model model, HttpServletResponse response, HttpServletRequest request) {
        log.info("controller request /board/content GET ! - {}", boardNo);

        Board board = service.findOneService(boardNo,response, request);
        log.info("return data - {}", board);
        model.addAttribute("b", board);

        return "board/board-detail";
    }

    // 게시물 쓰기 화면 요청
    @GetMapping("/write")
    public String write() {
        log.info("controller request /board/write GET !");
        return "board/board-write";
    }

    // 게시물 등록 화면 요청
    @PostMapping("/write")
    public String write(Board board, RedirectAttributes ra) { // @RequestBody 는 테스트 할때만 사용.
        log.info("controller request /board/write POST! - {}", board);
        boolean flag = service.saveService(board);

        // 게시물 등록이 잘 되면 클라이언트에 성공 메시지를 전송 하고 싶다.
        if (flag) ra.addFlashAttribute("msg", "reg-success");

        return flag ? "redirect:/board/list" : "redirect:/";
    }

    // 게시물 삭제 요청
    @GetMapping("/delete")
    public String delete(Long boardNo) {
        log.info("controller request / board/delete GET ! - {}", boardNo);
        return service.removeService(boardNo)
                ? "redirect:/board/list" : "redirect:/";
    }

    // 수정화면 요청
    @GetMapping("/modify")
    public String modify(Long boardNo, Model model, HttpServletResponse response, HttpServletRequest request) {
        log.info("controller request /board/modify GET ! - bno:{}", boardNo);
        Board board = service.findOneService(boardNo, response, request);
        log.info("find article: {}", board);

        model.addAttribute("board", board);
        return "board/board-modify";
    }

    @PostMapping("/modify")
    public String modify(Board board) {
        log.info("controller request /board/modify POST! - {}", board);
        boolean flag = service.modifyService(board);

        return flag ? "redirect:/board/content/" + board.getBoardNo() : "redirect:/";
    }


}

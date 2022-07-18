package com.project.web_prj.board.service;

import com.project.web_prj.board.domain.Board;
import com.project.web_prj.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository repository;

    // 게시물 등록 요청 중간 처리
    public boolean saveService(Board board) {
        log.info("save service start - {}", board);
        return repository.save(board);
    }

    // 게시물 전체 조회 요청 중간 처리
    public List<Board> findAllService() {
        log.info("findAll service start");
        List<Board> boardList = repository.findAll();

        // 목록 중간 데이터 처리
        processConverting(boardList);

        //글제목 줄임처리
//        subStringTitle(boardList);

        //시간 포맷팅처리
//        converDateFormat(boardList);

        return boardList;
    }

    private void processConverting(List<Board> boardList) {  //, 인터페이스 ㅇㅇ
        for (Board b : boardList) {
            convertDateFormat(b);
            substringTitle(b);
        }
    }

    //시간 포맷팅처리
    private void convertDateFormat(Board b) {

            Date date = b.getRegDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd a hh:mm");// 패턴을 써주면 날짜를 원하는 형태로 바꿔준다.
            b.setPrettierDate(sdf.format(date));

    }

    //글제목 줄임처리
    private void substringTitle(Board b) {


            // 만약에 글제목이 5글자 이상이라면
            // 5글자만 보여주고 나머지는 ...처리

            String title = b.getTitle();
            if (title.length() > 5) {
                String subStr = title.substring(0, 6);
                b.setShortTitle(subStr + "...");
            } else {
                b.setShortTitle(title);
            }

    }

    // 게시물 상세 조회 요청 중간 처리
    public Board findOneService(Long boardNo) {
        log.info("findOne service start - {}", boardNo);
        return repository.findOne(boardNo);
    }

    // 게시물 삭제 요청 중간 처리
    public boolean removeService(Long boardNo) {
        log.info("remove service start - {}", boardNo);
        return repository.remove(boardNo);
    }

    // 게시물 수정 요청 중간 처리
    public boolean modifyService(Board board) {
        log.info("modify service start - {}", board);
        return repository.modify(board);
    }
}
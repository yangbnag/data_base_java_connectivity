package com.spring.webmvc.springmvc.chap02.repository;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 의존성 주입을 테스트라인에서 사용 가능
class ScoreRepositorylmplTest {

    @Autowired
    ScoreRepository repository;

    @Test
    @DisplayName("점수 정보가 데이터베이스 테이블에 삽입 되어야 한다.")
    void saveTest() {
        Score s = new Score("뚱뚱이", 88, 68, 62);
        boolean result = repository.save(s);

        assertTrue(result);
    }

    @Test
    @DisplayName("특정 학번에 해당하는 점수 정보가 데이터베이스 테이블에서 삭제되어야 한다.")

    @Transactional // 테스트 후 데이터를 원상태로 유지 하기 위해서
    @Rollback // @Transactional @Rollback 을 붙여서 사용.
    void removeTest() {
        //give
        int stuNum = 2;

        //when
        boolean result = repository.remove(stuNum);

        //then
        assertTrue(result);
    }

    @Test
    @DisplayName("모든 점수 정보를 조회해야 한다.")
    void findAllTest(String sort){
        List<Score> scoreList = repository.findAll(sort);

        scoreList.forEach(s -> System.out.println(s)); // iter 문
    }

    @Test
    @DisplayName("특정 학번에 대한 점수 정보를 조회해야 한다.")
    void findOneTest(){
        Score score = repository.findOne(3);

        System.out.println(score);

        assertEquals("냠냠이", score.getName());
    }

    @Test
    @DisplayName("1등인 학생의 정보를 조회해야 한다.")
    void findFirstTest(){
        List<Score> first = repository.findFirst();

        for (Score score : first) {
            System.out.println(score);
            System.out.println(score.getName());
        }


    }

    @Test
    @DisplayName("꼴등인 학생의 정보를 조회해야 한다.")
    void findLastTest(){
        List<Score> last = repository.findlast();

        for (Score score : last) {
            System.out.println(score);
            System.out.println(score.getName());
        }




    }
}
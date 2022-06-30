package com.jdbc.basic.score.repository;

import com.jdbc.basic.score.domain.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ScoreOracleRepoTest {

    ScoreRepository repository = new ScoreOracleRepo();

    @Test
    @DisplayName("성적 정보를 DB에 삽입해야 한다.")
    void insertTest() {

        Score kim = new Score();
        kim.setStuName("김테스트");
        kim.setKor(58);
        kim.setEng(77);
        kim.setMath(99);
        kim.calc();

        boolean result = repository.save(kim);
        assertTrue(result);

    }

    @Test
    @DisplayName("전체 성적 정보를 조회해야 한다.")
    void findOneTest() {

        Score one = repository.findOne(3);
        System.out.println(one);

        assertEquals("박영희", one.getStuName());


    }

    @Test
    @DisplayName("성적 정보를 수정해야 한다.")
    void findModify() {

        // given [객체에서 수정 진행]
        Score score = repository.findOne(3);
        score.setKor(80);
        score.setEng(80);
        score.setMath(80);
        score.setTotal(80);
        score.calc();

        //when - 테스트할 상황
        boolean result = repository.modify(score);

        //then - 테스트 후 예상되는 결과
        Score newScore = repository.findOne(3);
        assertEquals(80, newScore.getAverage());
    }

    @Test
    @DisplayName("특정 성적 정보를 삭제")
    void removeTest() {
        //give
        int stuNum = 4;

        //when
        boolean result = repository.remove(stuNum);

        // then
        Score score = repository.findOne(4);
        assertNull(score);
    }

    @Test
    @DisplayName("전체 성적 정보를 조회해야 한다.")
    void findAllTest() {

        Map<Integer, Score> scoreMap = repository.findAll();
        for (Integer stuNum : scoreMap.keySet()) {
            System.out.println(scoreMap.get(stuNum));
        }

        assertEquals(3, scoreMap.size());

    }
}
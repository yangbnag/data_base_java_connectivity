package com.jdbc.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.jdbc.basic.PersonCRUD.*;
import static org.junit.jupiter.api.Assertions.*;

class PersonCRUDTest {

    @Test
    @DisplayName("사람 정보가 데이터베이스에 저장되어야 한다.")
    void saveTest(){

        // 사람 객체 생성
        PersonCRUD.Person p = makePerson("850201-1233499", "고길동", 25);
        PersonCRUD.Person p1 = makePerson("222-22-222222", "황길동", 27);
        PersonCRUD.Person p2 = makePerson("333-333-33333", "오길동", 29);

        //사람 저장 명령
//        boolean result = save(p);
        boolean result = save(p1);
        boolean result2 = save(p2);

        // 단언
        assertTrue(result);
        assertTrue(result2);

    }

    @Test
    @DisplayName("주어진 주민번호에 맞는 사람정보를 데이터베이스에서 삭제해야 한다.")
    void removeTest(){
        boolean flag = remove("850201-1233499");
        assertTrue(flag);
    }

    @Test
    @DisplayName("주어진 주민번호에 맞는 사람의 이름을 수정해야 한다.")
    void update(){
        boolean result = updateName("이소룡","333-333-33333 ");
        assertTrue(result);

    }

    @Test
    void bulkInsertTest(){
        String[] firstNames = {"김", "이", "박", "최", "송", "라"};
        for (int i = 0; i < 10; i++) {
            String f = firstNames[(int) Math.random() * firstNames.length];
            save(makePerson("991112-123456"+i, f +"철수", 24));
        }
    }

    /*@Test
    void bulkInsertTest() {

        String[] firstNames = {"김", "이", "박", "최", "송", "라"};
        for (int i = 0; i < 10; i++) {
            String f = firstNames[(int) (Math.random() * firstNames.length)];
            save(makePerson("991112-123456"+i, f+"철수", 24));
        }
    }*/

    @Test
    @DisplayName("전체 사람데이터를 조회해야 한다")
    void findAllTest(){
        List<Person> people = findAll();

        for (Person p : people) {
            System.out.println(p);
        }
    }

}
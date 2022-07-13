package com.spring.webmvc.springmvc.chap02.repository;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor // final 필드를 초기화 해주는 생성자 선언
public class ScoreRepositorylmpl implements ScoreRepository {

    // 스프링 JDBC - JDBC Template : JDBC를 단순화
    private final JdbcTemplate template;

/*    @Autowired // 스프링에 자동 주입하라고 요청
    public ScoreRepositorylmpl(JdbcTemplate template) {
        this.template = template;
    }*/

    @Override
    public boolean save(Score score) {
        String sql = "INSERT INTO tbl_score " +
                "VALUES (seq_tbl_score.nextval, ?, ?, ?, ?, ?, ?, ?)";

        // INSERT, UPDATE, DELETE는 템플릿의 update() 메서드 활용
        return template.update(sql, score.getName(), score.getKor(), score.getEng(), score.getMath(),
                score.getTotal(), score.getAverage(), score.getGrade().toString()) == 1;
    }

    @Override
    public List<Score> findAll() {
        String sql = "SELECT * FROM tbl_score ORDER BY average DESC";
        // SELECT문의 경우는 query()
//        return template.query(sql, new ScoreRowMapper()); // 1번 구현체 클래스 만들기

        /*
        return template.query(sql, new RowMapper<Score>() { // 2번 익명 클래스 만들기
            @Override
            public Score mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Score(rs);
            }
        });
         */
        return template.query(sql, (rs, rowNum) -> new Score(rs)); // 3번 람다 활용
    }


    @Override
    public Score findOne(int stuNum) {
        String sql = "SELECT * FROM tbl_score WHERE stu_num = ?";
        // 단일 건수 조회시 사용
//        return template.queryForObject(sql, new ScoreRowMapper(), stuNum);

        return template.queryForObject(sql, (rs, rowNum) -> new Score(rs), stuNum); // 람다
    }

    @Override
    public boolean remove(int stuNum) {
        String sql = "DELETE FROM tbl_score WHERE stu_num = ?";
        return template.update(sql, stuNum) == 1;
    }

    @Override
    public List<Score> findFirst() {
        String sql = "SELECT *\n" +
                "  FROM tbl_score \n" +
                "  WHERE average = (SELECT MAX(average) from tbl_score)";

        return template.query(sql, (rs, rowNum) -> new Score(rs));
    }

    @Override
    public List<Score> findlast() {
        String sql = "SELECT *\n" +
                "  FROM tbl_score \n" +
                "  WHERE average = (SELECT MIN(average) from tbl_score)";

        return template.query(sql, (rs, rowNum) -> new Score(rs));
    }
}

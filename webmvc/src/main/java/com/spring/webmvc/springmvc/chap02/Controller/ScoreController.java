package com.spring.webmvc.springmvc.chap02.Controller;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import com.spring.webmvc.springmvc.chap02.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
public class ScoreController {

    private final ScoreRepository repository;

//    @Autowired
//    public ScoreController(ScoreRepository repository) {
//        this.repository = repository;
//    }

    // 점수 등록 및 조회 화면 열기 요청
    @RequestMapping("/score/list")
    public String list(Model model){
        log.info("/score/list GET 요청!!");

        // jsp에게 점수 정보 리스트를 전달해야 함.
        List<Score> scoreList = repository.findAll();
        model.addAttribute("scores",scoreList);

        Score firstStu;
        Score lastStu;
        for (Score score : scoreList) {

        }

        return "chap02/score-list";
    }

    // 점수 신규등록 요청
    @RequestMapping("/score/register")
    public String register(Score score){
        score.calcTotalAndAvg();
        score.calcGrade();
        log.info("/score/register POST! -" + score);

        if (repository.save(score)) {
            return "redirect:/score/list";
        } else {
            return "redirect:/";
        }
    }

  @RequestMapping("/score/detail")
    public String detail(int stuNum, Model model) {
        log.info("/score/detail GET 요청!! - ");

      Score s = repository.findOne(stuNum);

      model.addAttribute("s", s);
//      model.addAttribute("name", s.getName());
//      model.addAttribute("kor", s.getKor());
//      model.addAttribute("eng", s.getEng());
//      model.addAttribute("math", s.getMath());
//      model.addAttribute("total", s.getTotal());
//      model.addAttribute("average", s.getAverage());
//      model.addAttribute("grade", s.getGrade());

      log.info(s);

      return "chap02/score-detail";
  }

  @RequestMapping("/score/delete")
    public String delete(int stuNum){
        repository.remove(stuNum);
        return "redirect:/score/list";
  }


}

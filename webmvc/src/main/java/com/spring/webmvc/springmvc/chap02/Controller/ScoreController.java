package com.spring.webmvc.springmvc.chap02.Controller;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import com.spring.webmvc.springmvc.chap02.repository.ScoreMapper;
import com.spring.webmvc.springmvc.chap02.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
public class ScoreController {

//    private final ScoreRepository repository;
    private final ScoreMapper mapper;

    //    @Autowired
    //    public ScoreController(ScoreRepository repository) {
    //        this.repository = repository;
    //    }

    // 점수 등록 및 조회 화면 열기 요청
    @RequestMapping("/score/list")
    public String list(
            //클라이언트가 sort를 보내지 않을 경우
            @RequestParam(defaultValue = "num") String sort,
            Model model) {
        log.info("/score/list GET 요청!! - param1: {}", sort);

        // jsp에게 점수 정보 리스트를 전달해야 함.
//        List<Score> scoreList = repository.findAll(sort);
        List<Score> scoreList = mapper.findAll(sort);


        // 이름 마킹 처리
//        for (Score s : scoreList) {
//            String original = s.getName();
//            StringBuilder markName = new StringBuilder(String.valueOf(original.charAt(0)));
//            for (int i = 0; i < original.length() - 1; i++) {
//                markName.append("*");
//            }
//            s.setName(markName.toString());
//        }


        model.addAttribute("scores", scoreList);

        /*// jsp 에게 1등인 학생의 정보를 전달
        List<Score> firstScoreList = repository.findFirst();
        model.addAttribute("firstScores", firstScoreList);

        // jsp 에게 꼴등인 학생의 정보를 전달
        List<Score> lastScoreList = repository.findlast();
        model.addAttribute("lastScores", lastScoreList);*/


        return "chap02/score-list";
    }

    // 점수 신규등록 요청
    @RequestMapping("/score/register")
    public String register(Score score) {
        score.calcTotalAndAvg();
        score.calcGrade();
        log.info("/score/register POST! -" + score);

        if (mapper.save(score)) {
            return "redirect:/score/list";
        } else {
            return "redirect:/";
        }
    }


/*        @RequestMapping("score/detail")
        public ModelAndView detail(int sutNum) {
            log.info("score/detail GET - param1: {}", sutNum);
            Score score = repository.findOne(sutNum);

            ModelAndView mv = new ModelAndView("chap02/score-detail");
            mv.addObject("s",score);

            return mv;
        }*/

    @RequestMapping("/score/detail")
    public String detail(int stuNum, Model model) {
        log.info("/score/detail GET 요청!! - ");

        Score s = mapper.findOne(stuNum);

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
    public String delete(@RequestParam("stuNum") int sn) {
        log.info("score/delete GET - param1: {}", sn);

        return mapper.remove(sn) ? "redirect:/score/list" : "redirect:/";
    }


}

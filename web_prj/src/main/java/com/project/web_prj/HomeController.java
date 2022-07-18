package com.project.web_prj;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class HomeController {

    @GetMapping("/") // home으로 들어오면
    public String home() {
        log.info("welcome page open!");
        return "index";
    }
}

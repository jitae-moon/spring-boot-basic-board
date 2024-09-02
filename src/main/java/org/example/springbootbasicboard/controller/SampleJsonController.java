package org.example.springbootbasicboard.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SampleJsonController {

    @GetMapping("/helloArr")
    public String[] helloArr() {
        log.info("SampleJsonController :: helloArr");

        return new String[]{"hello, ", "world!"};
    }

}

package org.example.springbootbasicboard.controller;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Controller
public class SampleController {

    @GetMapping("/hello")
    public void hello(Model model) {
        log.info("SampleController :: hello");

        model.addAttribute("message", "hello, world!");
    }

    @GetMapping("/ex/ex1")
    public void ex1(Model model) {
        log.info("SampleController :: ex1");

        List<String> list = List.of("AAA", "BBB", "CCC");

        model.addAttribute("list", list);
    }

    @GetMapping("/ex/ex2")
    public void ex2(Model model) {
        log.info("SampleController :: ex2");
        List<String> list = IntStream.range(1, 10)
                .mapToObj(i -> "Data" + i)
                .collect(Collectors.toList());

        model.addAttribute("list", list);

        Map<String, String> map = new HashMap<>();
        map.put("A", "AAAA");
        map.put("B", "BBBB");

        model.addAttribute("map", map);

        SampleDto sampleDto = new SampleDto();
        sampleDto.p1 = "Value -- p1";
        sampleDto.p2 = "Value -- p2";
        sampleDto.p3 = "Value -- p3";

        model.addAttribute("dto", sampleDto);
    }

    @GetMapping("/ex/ex3")
    public void ex3(Model model) {
        model.addAttribute("arr", new String[]{"AAA", "BBB", "CCC"});
    }

    @Getter
    class SampleDto {
        private String p1, p2, p3;
    }

}

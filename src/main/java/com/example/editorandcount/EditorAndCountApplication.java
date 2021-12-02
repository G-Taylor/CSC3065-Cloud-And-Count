package com.example.editorandcount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.editorandcount.CountAndFunction;

@SpringBootApplication
@RestController
public class EditorAndCountApplication {

    public static void main(String[] args) {

        SpringApplication.run(EditorAndCountApplication.class, args);
    }

    @GetMapping("/")
    public String getResponse(@RequestParam(value = "text") String text) {

        CountAndFunction countAndFunction = new CountAndFunction();
        int numberOfAnds = countAndFunction.countAnds(text);


        return "Number of ands: " + numberOfAnds;
    }
}

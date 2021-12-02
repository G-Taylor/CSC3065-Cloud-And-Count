package com.example.editorandcount;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.editorandcount.*;

@SpringBootApplication
@RestController
public class EditorAndCountApplication {

    public static void main(String[] args) {

        SpringApplication.run(EditorAndCountApplication.class, args);
    }

    @GetMapping("/")
    public String getResponse(@RequestParam(value = "text") String text) throws JSONException {

        CountAndFunction countAndFunction = new CountAndFunction();
        JSONObject object = new JSONObject();

        int numberOfAnds = countAndFunction.countAnds(text);

        if (text.equals("")) {
            object.put("error", false);
            object.put("sentence", "No Text Entered");
            object.put("answer", 0);
        } else {
            object.put("error", false);
            object.put("sentence", text);
            object.put("answer", numberOfAnds);
        }


        return object.toString();
    }
}

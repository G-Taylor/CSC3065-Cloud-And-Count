package com.example.editorandcount;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.editorandcount.*;

@SpringBootApplication
@RestController
public class EditorAndCountApplication {

    public static void main(String[] args) {

        SpringApplication.run(EditorAndCountApplication.class, args);
    }

    @GetMapping("/")
    public ResponseEntity<String> getResponse(@RequestParam(value = "text") String text) throws JSONException {

        CountAndFunction countAndFunction = new CountAndFunction();
        JSONObject object = new JSONObject();

        int numberOfAnds = countAndFunction.countAnds(text);

        if (text.equals("")) {
            object.put("error", true);
            object.put("sentence", "No Text Entered");
            object.put("answer", 0);

            return ResponseEntity.badRequest()
                    .header("Content-Type", "application/json")
                    .header("Access-Control-Allow-Origin", "*")
                    .body(object.toString());
        } else {
            object.put("error", false);
            object.put("sentence", text);
            object.put("answer", numberOfAnds);

            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .header("Access-Control-Allow-Origin", "*")
                    .body(object.toString());
        }

    }
}

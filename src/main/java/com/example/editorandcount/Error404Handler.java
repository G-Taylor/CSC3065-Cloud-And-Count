package com.example.editorandcount;

import com.fasterxml.jackson.annotation.JsonAlias;
import netscape.javascript.JSObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Error404Handler implements ErrorController {

    @GetMapping("/error")
    @ResponseBody
    public ResponseEntity<String> handle404() throws JSONException {
        JSONObject object = new JSONObject();

        object.put("error", true);
        object.put("sentence", "Incorrect Parameters");
        object.put("answer", 0);

        return ResponseEntity.badRequest()
                .header("Content-Type", "application/json")
                .header("Access-Control-Allow-Origin", "*")
                .body(object.toString());
    }
}

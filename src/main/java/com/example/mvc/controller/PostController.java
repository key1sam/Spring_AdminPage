package com.example.mvc.controller;

import com.example.mvc.model.SearchParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostController {

    //HTML <Form>
    //ajax 검색
    //http post body -> data
    // json, xml, multipart-form / text-plain

    //@PostMapping(value = /postMethod", produces = {"application-json"} 이런식으로 입력받을 객체를 선택할 수 있다.
    @PostMapping("/postMethod") //default값은 json
    public String postMethod(@RequestBody SearchParam searchParam) { // Get 메서드와 다르게 @RequestBody 선언 필요
        return "searchParam";
    }
}

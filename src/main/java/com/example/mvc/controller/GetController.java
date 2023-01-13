package com.example.mvc.controller;

import com.example.mvc.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // Localhost:8080/api
public class GetController {
    @RequestMapping(method = RequestMethod.GET, path = "/getMethod" ) // localhost:8080/api/getMethod
    public String getRequest() {
        return "Hi getMethod";
    }

    @GetMapping("/getParameter") // localhost:8080/api/getParameter?id=1234&password=yyyymmdd
    public String getParameter(@RequestParam String id, @RequestParam (name = "password") String pwd) {
        String password = "bbbb"; // 주소 매개변수에서 어쩔 수 없이 parameter 이름이 동일할 때 위에서 (name = "password")와 같이 저장할 수 있다.
        System.out.println("id : " + id);
        System.out.println("password : " + pwd);
        return id+pwd;
    }

    //localhost:8080/api/getMultiParameter?account=abcd&email=study@gmail.com&page=10
    //받아야하는 매개변수가 많을 경우 RequestParam을 계속 입력해야한다. 이때는 Model 객체를 사용하면 된다.
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam) { //Model 클래스를 전달
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        // { "account" : "", "email" : "", "page" : "0" }
        return searchParam; // 매개변수로 받은 객체를 리턴하면 JSON 형태로 출력된다.
    }
}

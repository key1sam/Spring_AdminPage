package com.example.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

// Parameter를 받기 위해서는 get,set메서드와 생성자가 필요하다.
@Data // Lombok을 활용하여 get,set메서드, 생성자 생성
@AllArgsConstructor // 매개변수를 다 가지고 있는 생성자 생성
public class SearchParam {

    private String account;
    private String email;
    private int page;

}

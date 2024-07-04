package com.len.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Principal {

    private String userId;

    private String userName;

    private List<String> roles = new ArrayList<>();

    private String photo;
}

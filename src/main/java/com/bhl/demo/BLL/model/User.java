package com.bhl.demo.BLL.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private String id;

    private String name;

    private String username;

    private String password;

}

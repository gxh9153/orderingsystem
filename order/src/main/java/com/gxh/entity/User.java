package com.gxh.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private String gender;
    private String telephone;
    private String registerdate;
    private String address;
}

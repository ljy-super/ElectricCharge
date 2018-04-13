package com.electricharge.base;

import com.baomidou.mybatisplus.plugins.Page;

public class MySearch<T> extends Page {
    private  String dormitoryCode;

    private String userCode;

    private String userName;

    private String userType;
    public String getDormitoryCode() {
        return dormitoryCode;
    }

    public void setDormitoryCode(String dormitoryCode) {
        this.dormitoryCode = dormitoryCode;
    }
}

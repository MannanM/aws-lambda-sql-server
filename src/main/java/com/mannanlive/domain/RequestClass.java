package com.mannanlive.domain;

public class RequestClass {
    private Integer value;
    public RequestClass() { }
    public RequestClass(Integer value) {
        this.value = value;
    }
    public Integer getValue() {
        return value;
    }
    public void setValue(Integer value) {
        this.value = value;
    }
}
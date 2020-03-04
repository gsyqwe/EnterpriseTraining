package com.example.demo.model;

import java.util.Date;

public class Student {
    private Integer id;

    private String name;

    private String sex;

    private Date birthday;

    private Double score;

    private String address;

    private Integer collegeId;

    public Student(Integer id, String name, String sex, Date birthday, Double score, String address, Integer collegeId) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.score = score;
        this.address = address;
        this.collegeId = collegeId;
    }

    public Student(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }
}
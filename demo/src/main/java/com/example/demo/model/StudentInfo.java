package com.example.demo.model;

public class StudentInfo {

    private Integer id;

    private String name;

    private String sex;

    private String birthday;

    private Double score;


    public StudentInfo() {
    }

    public StudentInfo(Integer id, String name, String sex, String birthday, Double score) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.score = score;
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
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}

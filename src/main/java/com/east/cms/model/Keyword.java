package com.east.cms.model;

public class Keyword {
    private Integer keywordId;

    private String name;

    private Integer times;

    private String nameFullPy;

    private String nameShortPy;

    public Integer getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(Integer keywordId) {
        this.keywordId = keywordId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public String getNameFullPy() {
        return nameFullPy;
    }

    public void setNameFullPy(String nameFullPy) {
        this.nameFullPy = nameFullPy;
    }

    public String getNameShortPy() {
        return nameShortPy;
    }

    public void setNameShortPy(String nameShortPy) {
        this.nameShortPy = nameShortPy;
    }
}
package com.example.fbcrud;

public class user {
    String vid;
    String op;
    public user() {

    }
    public user(String vid, String op) {
        this.vid = vid;
        this.op = op;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }
}

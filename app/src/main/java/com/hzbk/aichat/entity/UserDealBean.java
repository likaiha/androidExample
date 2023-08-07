package com.hzbk.aichat.entity;

public class UserDealBean {

    private String code;
    private MsgDat msg;
    private String data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public MsgDat getMsg() {
        return msg;
    }

    public void setMsg(MsgDat msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public static class MsgDat {
        private String post_content;

        public String getPost_content() {
            return post_content;
        }

        public void setPost_content(String post_content) {
            this.post_content = post_content;
        }
    }
}

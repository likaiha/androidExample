package com.hzbk.aichat.entity;

public class CheckVersionBean {

    private String code;
    private String msg;
    private DataDat data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataDat getData() {
        return data;
    }

    public void setData(DataDat data) {
        this.data = data;
    }

    public static class DataDat {
        private String id;
        private String version;
        private String description;
        private String download_url;
        private String create_time;
        private String version_num;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDownload_url() {
            return download_url;
        }

        public void setDownload_url(String download_url) {
            this.download_url = download_url;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getVersion_num() {
            return version_num;
        }

        public void setVersion_num(String version_num) {
            this.version_num = version_num;
        }
    }
}

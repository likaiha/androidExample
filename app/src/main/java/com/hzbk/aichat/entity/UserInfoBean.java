package com.hzbk.aichat.entity;

public class UserInfoBean {

    private String code;
    private String msg;
    private DataDTO data;

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

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public static class DataDTO {
        private UserDTO user;

        public UserDTO getUser() {
            return user;
        }

        public void setUser(UserDTO user) {
            this.user = user;
        }

        public static class UserDTO {
            private String id;
            private String user_type;
            private String sex;
            private String birthday;
            private String last_login_time;
            private String create_time;
            private String user_status;
            private String user_login;
            private String user_pass;
            private String user_nickname = "";
            private String user_email;
            private String avatar;
            private String signature;
            private String last_login_ip;
            private String user_activation_key;
            private String mobile;
            private String more;
            private String p_mobile;
            private String path;
            private String share_code;
            private String parent_share_code;
            private String parent_id;
            private String reward_num;
            private String number_of_times;
            private String is_first;
            private String level;
            private String tx_name = "";
            private String deposit_bank = "";
            private String bank_no = "";
            private String ali_account = "";
            private String balance;
            private String shopping_points;
            private String green_points;
            private String frozen_balance;
            private String levelName;
            private String id_number;//身份证号码

            public String getId_number() {
                return id_number;
            }

            public void setId_number(String id_number) {
                this.id_number = id_number;
            }

            public String getLevelName() {
                return levelName;
            }

            public void setLevelName(String levelName) {
                this.levelName = levelName;
            }

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUser_type() {
                return user_type;
            }

            public void setUser_type(String user_type) {
                this.user_type = user_type;
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

            public String getLast_login_time() {
                return last_login_time;
            }

            public void setLast_login_time(String last_login_time) {
                this.last_login_time = last_login_time;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getUser_status() {
                return user_status;
            }

            public void setUser_status(String user_status) {
                this.user_status = user_status;
            }

            public String getUser_login() {
                return user_login;
            }

            public void setUser_login(String user_login) {
                this.user_login = user_login;
            }

            public String getUser_pass() {
                return user_pass;
            }

            public void setUser_pass(String user_pass) {
                this.user_pass = user_pass;
            }

            public String getUser_nickname() {
                return user_nickname;
            }

            public void setUser_nickname(String user_nickname) {
                this.user_nickname = user_nickname;
            }

            public String getUser_email() {
                return user_email;
            }

            public void setUser_email(String user_email) {
                this.user_email = user_email;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getLast_login_ip() {
                return last_login_ip;
            }

            public void setLast_login_ip(String last_login_ip) {
                this.last_login_ip = last_login_ip;
            }

            public String getUser_activation_key() {
                return user_activation_key;
            }

            public void setUser_activation_key(String user_activation_key) {
                this.user_activation_key = user_activation_key;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getMore() {
                return more;
            }

            public void setMore(String more) {
                this.more = more;
            }

            public String getP_mobile() {
                return p_mobile;
            }

            public void setP_mobile(String p_mobile) {
                this.p_mobile = p_mobile;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public String getShare_code() {
                return share_code;
            }

            public void setShare_code(String share_code) {
                this.share_code = share_code;
            }

            public String getParent_share_code() {
                return parent_share_code;
            }

            public void setParent_share_code(String parent_share_code) {
                this.parent_share_code = parent_share_code;
            }

            public String getParent_id() {
                return parent_id;
            }

            public void setParent_id(String parent_id) {
                this.parent_id = parent_id;
            }

            public String getReward_num() {
                return reward_num;
            }

            public void setReward_num(String reward_num) {
                this.reward_num = reward_num;
            }

            public String getNumber_of_times() {
                return number_of_times;
            }

            public void setNumber_of_times(String number_of_times) {
                this.number_of_times = number_of_times;
            }

            public String getIs_first() {
                return is_first;
            }

            public void setIs_first(String is_first) {
                this.is_first = is_first;
            }

            public String getTx_name() {
                return tx_name;
            }

            public void setTx_name(String tx_name) {
                this.tx_name = tx_name;
            }

            public String getDeposit_bank() {
                return deposit_bank;
            }

            public void setDeposit_bank(String deposit_bank) {
                this.deposit_bank = deposit_bank;
            }

            public String getBank_no() {
                return bank_no;
            }

            public void setBank_no(String bank_no) {
                this.bank_no = bank_no;
            }

            public String getAli_account() {
                return ali_account;
            }

            public void setAli_account(String ali_account) {
                this.ali_account = ali_account;
            }

            public String getBalance() {
                return balance;
            }

            public void setBalance(String balance) {
                this.balance = balance;
            }

            public String getShopping_points() {
                return shopping_points;
            }

            public void setShopping_points(String shopping_points) {
                this.shopping_points = shopping_points;
            }

            public String getGreen_points() {
                return green_points;
            }

            public void setGreen_points(String green_points) {
                this.green_points = green_points;
            }

            public String getFrozen_balance() {
                return frozen_balance;
            }

            public void setFrozen_balance(String frozen_balance) {
                this.frozen_balance = frozen_balance;
            }
        }
    }
}

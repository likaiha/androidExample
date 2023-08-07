package com.hzbk.aichat.entity;

import java.util.List;

public class BalanceDetailListBean {


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
        private AccountDTO account;
        private List<ListDTO> list;

        public AccountDTO getAccount() {
            return account;
        }

        public void setAccount(AccountDTO account) {
            this.account = account;
        }

        public List<ListDTO> getList() {
            return list;
        }

        public void setList(List<ListDTO> list) {
            this.list = list;
        }

        public static class AccountDTO {
            private String id;
            private String user_id;
            private String balance;
            private String shopping_points;
            private String green_points;
            private String frozen_balance;
            private String status;
            private String create_time;
            private Object update_time;
            private String profit;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
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

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public Object getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(Object update_time) {
                this.update_time = update_time;
            }

            public String getProfit() {
                return profit;
            }

            public void setProfit(String profit) {
                this.profit = profit;
            }
        }

        public static class ListDTO {
            private String id;
            private String user_id;
            private String type;
            private String type_name;
            private String before_balance;
            private String after_balance;
            private String change_balance;
            private String create_time;
            private String target_id;
            private String points_type;
            private Object status;
            private String month;
            private String receipt;
            private String service;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getType_name() {
                return type_name;
            }

            public void setType_name(String type_name) {
                this.type_name = type_name;
            }

            public String getBefore_balance() {
                return before_balance;
            }

            public void setBefore_balance(String before_balance) {
                this.before_balance = before_balance;
            }

            public String getAfter_balance() {
                return after_balance;
            }

            public void setAfter_balance(String after_balance) {
                this.after_balance = after_balance;
            }

            public String getChange_balance() {
                return change_balance;
            }

            public void setChange_balance(String change_balance) {
                this.change_balance = change_balance;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getTarget_id() {
                return target_id;
            }

            public void setTarget_id(String target_id) {
                this.target_id = target_id;
            }

            public String getPoints_type() {
                return points_type;
            }

            public void setPoints_type(String points_type) {
                this.points_type = points_type;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public String getMonth() {
                return month;
            }

            public void setMonth(String month) {
                this.month = month;
            }

            public String getReceipt() {
                return receipt;
            }

            public void setReceipt(String receipt) {
                this.receipt = receipt;
            }

            public String getService() {
                return service;
            }

            public void setService(String service) {
                this.service = service;
            }
        }
    }
}

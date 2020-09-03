package com.htsc.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * created by Kimone
 * date 2020/9/2
 */
public class AccountUser implements Serializable {
    private Integer id;
    private Account account;
    private User user;

    public AccountUser() {
        this.account = new Account();
        this.user = new User();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Account properties Getter and Setter
    public Integer getUid() {
        return account.getUid();
    }

    public void setUid(Integer uid) {
        account.setUid(uid);
    }

    public Double getMoney() {
        return account.getMoney();
    }

    public void setMoney(Double money) {
        account.setMoney(money);
    }

    // User properties Getter and Setter
    public String getUsername() {
        return user.getUsername();
    }

    public void setUsername(String username) {
        user.setUsername(username);
    }

    public String getSex() {
        return user.getSex();
    }

    public void setSex(String sex) {
        user.setSex(sex);
    }

    public String getAddress() {
        return user.getAddress();
    }

    public void setAddress(String address) {
        user.setAddress(address);
    }

    public Date getBirthday() {
        return user.getBirthday();
    }

    public void setBirthday(Date birthday) {
        user.setBirthday(birthday);
    }

    @Override
    public String toString() {
        return "AccountUser{" +
                "id=" + id +
                ", account=" + account +
                ", user=" + user +
                '}';
    }
}

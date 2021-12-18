package org.example;

import java.sql.Date;

public class Account {
    private String id;
    private String name;
    private Integer money;
    private Date createtime;
    private Date updatetime;

    public Account() {
    }

    public Account(String id, String name, Integer money, Date createtime, Date updatetime) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                '}';
    }
}

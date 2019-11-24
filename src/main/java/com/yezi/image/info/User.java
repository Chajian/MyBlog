package com.yezi.image.info;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * 设置一个用户的详细信息
 * @author yezi
 * @version 1.0
 */
public class User implements Serializable {

    public static final long serialiUID = 234234234L;
    @NotEmpty(message = "账号不能为空")
    private String account;
    private String name;
    @NotEmpty(message = "密码不能为空")
    private String pass;
    private String info;
    private String gender;
    private int age;
    private int photoid;



    public boolean equls(User user){
        if(user.getAccount() == account)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", info='" + info + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", photoid=" + photoid +
                '}';
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhotoid() {
        return photoid;
    }

    public void setPhotoid(int photoid) {
        this.photoid = photoid;
    }

    public String getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}

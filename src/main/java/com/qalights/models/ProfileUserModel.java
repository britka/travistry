package com.qalights.models;

import com.qalights.annotations.ReferTo;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by brit on 1/24/17.
 */
public class ProfileUserModel {

    @ReferTo(id = "userProfileEdit_user_email")
    private String email = "";
    @ReferTo(id = "userProfileEdit_user_name")
    private String userNickName = "";
    @ReferTo(id = "userProfileEdit_user_username")
    private String loginName = "";
    @ReferTo(id = "userProfileEdit_user_password_password")
    private String password = "";

    public ProfileUserModel() {
    }

    public String getEmail() {
        return email;
    }

    public ProfileUserModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public ProfileUserModel setUserNickName(String userNickName) {
        this.userNickName = userNickName;
        return this;
    }

    public String getLoginName() {
        return loginName;
    }

    public ProfileUserModel setLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public ProfileUserModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public HashMap<Map<String, String>, Object> getDataToFillForm() {
        HashMap<Map<String, String>, Object> resultMap = new HashMap<>();
        for (Field field : getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(ReferTo.class)) {
                if (!field.getAnnotation(ReferTo.class).id().equals("")) {
                    try {
                        if (field.get(this).equals("")) {
                            continue;
                        }
                        resultMap.put(new HashMap<String, String>() {{
                            put("id", field.getAnnotation(ReferTo.class).id());
                        }}, field.get(this));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } else if (!field.getAnnotation(ReferTo.class).name().equals("")) {

                    try {
                        if (field.get(this).equals("")) {
                            continue;
                        }
                        resultMap.put(new HashMap<String, String>() {{
                            put("name", field.getAnnotation(ReferTo.class).name());
                        }}, field.get(this));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return resultMap;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("email", email)
                .append("userNickName", userNickName)
                .append("loginName", loginName)
                .append("password", password)
                .toString();
    }


}

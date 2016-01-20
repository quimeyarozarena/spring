package com.demo.models;

import java.sql.ResultSet;
import java.sql.Statement;

public class Login_Model {

    public String do_login_proces(String username, String password) {
        try {
            Database_Connectivity dc = new Database_Connectivity();
            Statement statement = dc.do_db_connection();
            ResultSet rs = statement.executeQuery(
                    "select count(*) from user where username= '" + username + "' and password= '" + password + "'");
            int count = 0;
            while (rs.next()) {

                count = rs.getInt(1);
            }
            rs.close();
            if (count == 1) {
                return "login success";
            } else {
                return "username or password doesn't match";
            }

        } catch (Exception e) {
            return "something went wrong... please try again";
        }
    }

}

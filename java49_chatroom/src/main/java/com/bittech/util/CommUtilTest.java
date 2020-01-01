package com.bittech.util;

import com.bittech.client.entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.*;

public class CommUtilTest {

    @org.junit.Test
    public void lodeProperties() {
        Properties pros = CommUtil.loadProperties("db.properties");
        Assert.assertNotNull(pros);
    }
    @Test
    public void obj2Json(){
        User user = new User();
        user.setId(4);
        user.setUserName("test6");
        user.setPassword("666");
        user.setBrief("美丽");
        String str = CommUtil.object2Json(user);
        System.out.println(str);
    }
    @Test
    public void json2Object(){
        String str = "{\"id\":4,\"userName\":\"test6\",\"password\":\"666\",\"brief\":\"美丽\"}";
        User user = (User) CommUtil.json2Object(str,User.class);
        System.out.println(user);
    }
}
package com.rain.boss;

import java.util.UUID;

/**
 * Created by Administrator on 2016/11/5.
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i<10; i++){
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }
}

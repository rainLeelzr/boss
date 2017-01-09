package com.rain.boss;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2016/11/5.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        genUUID();
//        String src = "{\"userId\": \"#{userId}\" ,\"expireTime\": #{expireTime} ,\"userAgent\": \"#{userAgent}\"}";
//        src = src.replace("#{userId}", "f91fbd08-1ad7-49dc-b589-1780a47db9a4");
//        src = src.replace("#{expireTime}", "1481704995815");
//        src = src.replace("#{userAgent}", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
//        jdkAES("wq你好");
//        genUserPwd();
//        maps();
    }

    public static void maps() throws Exception {
        Map<String, String> map = new HashMap();
        ObjectMapper mapper = new ObjectMapper();

        for (int i = 0; i < 10; i++) {
            String value;
            if (i % 2 == 0) {
                value = "vvv" + i;
            } else {
                String[] vals = new String[3];
                vals[0] = "values0" + i;
                vals[1] = "values1" + i;
                vals[2] = "values2" + i;
                value = Arrays.toString(vals);
            }
            map.put(i + "n", value);
        }

        String Json = mapper.writeValueAsString(map);
        System.out.println(map);
    }

    private static void genUserPwd() {
        String userAccount = "2";
        String pwd = "2";
        String gen = DigestUtils.md5Hex(DigestUtils.md5Hex(pwd) + userAccount);
        System.out.println(gen);
    }

    private static void jdkAES(String src) {
        String KEY_ALGORITHM = "AES";
        String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
        try {
            //生成key
            KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
            keyGenerator.init(128);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] keyBytes = secretKey.getEncoded();
            System.out.println(Base64.encodeBase64String(keyBytes));
            System.out.println("===================");

            //key转换
            Key key = new SecretKeySpec(keyBytes, KEY_ALGORITHM);

            //加密
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(src.getBytes());
            String encryptStr = Base64.encodeBase64String(result);
            System.out.println(encryptStr);

            //解密
            cipher.init(Cipher.DECRYPT_MODE, key);
            result = cipher.doFinal(result);
            System.out.println(new String(result));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void genUUID() {
        for (int i = 0; i < 10; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }
}

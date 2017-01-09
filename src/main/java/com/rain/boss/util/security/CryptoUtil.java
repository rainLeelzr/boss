package com.rain.boss.util.security;

import com.rain.boss.init.SysParam;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;

/**
 * Created by Administrator on 2016/12/14.
 */
public class CryptoUtil {

    public static final String KEY_ALGORITHM_AES = "AES";

    public static final String CIPHER_ALGORITHM_AESECBPKCS5Padding = "AES/ECB/PKCS5Padding";

    public static String aesEncrypt(String src) throws Exception {
        return Base64.encodeBase64String(encrypt(KEY_ALGORITHM_AES, CIPHER_ALGORITHM_AESECBPKCS5Padding, src.getBytes("utf-8")));
    }

    public static String aesDecrypt(String src) throws Exception {
        return new String(decrypt(KEY_ALGORITHM_AES, CIPHER_ALGORITHM_AESECBPKCS5Padding, Base64.decodeBase64(src)), "utf-8");
    }

    private static byte[] encrypt(String keyAlgorithm, String cipherAlgorithm, byte[] src) throws Exception {
        //key转换
        Key key = new SecretKeySpec(Base64.decodeBase64(SysParam.SECRET_KEY), keyAlgorithm);

        //加密
        Cipher cipher = Cipher.getInstance(cipherAlgorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(src);
    }

    private static byte[] decrypt(String keyAlgorithm, String cipherAlgorithm, byte[] src) throws Exception {
        //key转换
        Key key = new SecretKeySpec(Base64.decodeBase64(SysParam.SECRET_KEY), keyAlgorithm);

        //解密
        Cipher cipher = Cipher.getInstance(cipherAlgorithm);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(src);
    }

    public static String genSecretKey(String keyAlgorithm) throws Exception {
        //生成key
        KeyGenerator keyGenerator = KeyGenerator.getInstance(keyAlgorithm);
        keyGenerator.init(new SecureRandom());
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] encoded = secretKey.getEncoded();
        return Base64.encodeBase64String(encoded);
    }

    public static void main(String[] args) throws Exception {
//        String src = "{\"userId\": \"#{userId}\" ,\"expireTime\": #{expireTime} ,\"userAgent\": \"#{userAgent}\"}";
//        src = src.replace("#{userId}", "f91fbd08-1ad7-49dc-b589-1780a47db9a4");
//        src = src.replace("#{expireTime}", "1481704995815");
//        src = src.replace("#{userAgent}", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
//
//        System.out.println(src);
//        String encrypted = aesEncrypt(src);
//        System.out.println(encrypted);
//        String decrypted = aesDecrypt(encrypted);
//        System.out.println(decrypted);

        SysParam.SECRET_KEY = "opJZdTmIpHYciKbCCkwp1A==";
        String a = "wy86yvvSMhkitRqXAQ74gMYcpeO3nPDWKgo2qS6sqKnu3ux8Tk3jRoVuban/yaYDf/UtFaR5KkJNBMsjFReEl7JfSuDGzSmDQpVd4R+DhuiMINoOjDLAHMRa5Ef64Wd4JE+Di8s4ITkhx6/7EMDwmYV+XcwTMTX0adDAwKNL6O8V4jQVWKF+O7ERGwOpldtS5u0Wy/ULotbZnBhDH6ceWHX+2PxSI4gPW4LSBwKXxa9acZiM9LP7B2jreKXvY1QZt7hlJeZoc2Nux1Pndw6jyw==";
        String b = aesDecrypt(a);
        System.out.println(b);
//        System.out.println(genSecretKey(KEY_ALGORITHM_AES));

    }

}

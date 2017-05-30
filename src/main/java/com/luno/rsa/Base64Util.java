package com.luno.rsa;
/**
 * Created by shanlin on 2017/5/30.
 */

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * BASE64 严格地说，属于编码格式，而非加密算法
 * Base64被定义为：Base64内容传送编码被设计用来
 *     把任意序列的8位字节描述为一种不易被人直接识别的形式。
 *  常见于邮件、http加密，截取http信息，你就会发现登录操
 *  作的用户名、密码字段通过BASE64加密的。
 * @author Z10
 * @time 2014-7-4 上午10:41:11
 */
public class Base64Util {

    public static void main(String[] args) {
        String str ="我是James. 今年1岁。";
//        String str ="Ilovepolly";
        System.out.println("加密前"+str);
        String enStr = null;
        String deStr = null;
        String deStr2 = null;
        try {
            enStr = Base64Util.encryptBASE64(str.getBytes());
            deStr = (Base64Util.decryptBASE64(enStr)).toString();    //错误用法无法将byte转为string
            deStr2 = new String(Base64Util.decryptBASE64(enStr));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("加密后"+enStr);
        System.out.println("解密后"+deStr);
        System.out.println("解密后"+deStr2);

    }

    /**
     * BASE64解密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * BASE64加密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }
}
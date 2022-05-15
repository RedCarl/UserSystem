package red.kalos.usersystem.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class SHA256Password {
    /**
     * 进行AuthME方式加密
     * @param Password 需要加密的数据
     * @return 返回加密后的数据
     */
    public String setHandling(String Password){
        StringBuilder key = new StringBuilder();
        StringBuilder keyA = new StringBuilder();
        StringBuilder keyB = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            if (i%2==0){
                int leftLimit = 97; // letter 'a'
                int rightLimit = 122; // letter 'z'
                int targetStringLength = 1;
                Random random = new Random();
                StringBuilder buffer = new StringBuilder(targetStringLength);
                for (int a = 0; a < targetStringLength; a++) {
                    int randomLimitedInt = leftLimit + (int)
                            (random.nextFloat() * (rightLimit - leftLimit + 1));
                    buffer.append((char) randomLimitedInt);
                }
                String generatedString = buffer.toString();
                keyA.append(generatedString);
            }else {
                keyA.append(new Random().nextInt(9));
            }
        }
        keyB.append(getSha256Str(getSha256Str(Password)+ keyA));

        key.append("$SHA$").append(keyA).append("$").append(keyB);

        return String.valueOf(key);
    }

    /**
     * 判断密码正确性
     * @param ShaPassword 加密后的密码(原始的)
     * @param Password 未加密的密码(最新输入的)
     * @return 正确/失败
     */
    public Boolean getHandling(String ShaPassword,String Password){
        String[] stars= ShaPassword.split("\\$");
        return getSha256Str(getSha256Str(Password) + stars[2]).equals(stars[3]);
    }

    /**
     * sha256加密
     *
     * @param str 要加密的字符串
     * @return 加密后的字符串
     */
    public String getSha256Str(String str) {
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }

    /**
     * sha256加密 将byte转为16进制
     *
     * @param bytes 字节码
     * @return 加密后的字符串
     */
    private String byte2Hex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        String temp;
        for (byte aByte : bytes) {
            temp = Integer.toHexString(aByte & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuilder.append("0");
            }
            stringBuilder.append(temp);
        }
        return stringBuilder.toString();
    }
}

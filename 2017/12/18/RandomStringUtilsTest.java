/**
 * 218：生成随机字符串（Commons Lang 组件简介）
 */

import org.apache.commons.lang.RandomStringUtils;

public class RandomStringUtilsTest {
    public static void main(String[] args) {
        System.out.println("生成长度为 5 的由字母组成的字符串");
        String randomString = RandomStringUtils.randomAlphabetic(5);
        System.out.println(randomString);
        System.out.println("生长长度为 5 的由字母和数字组成的字符串");
        randomString = RandomStringUtils.randomAlphanumeric(5);
        System.out.println(randomString);
        System.out.println("生长长度为 5 的由 ASCII 编码在 32~126 间的字符组成的字符串");
        randomString = RandomStringUtils.randomAscii(5);
        System.out.println(randomString);
        System.out.println("生长长度为 5 的由数字组成的字符串");
        randomString = RandomStringUtils.randomNumeric(5);
        System.out.println(randomString);
    }
}

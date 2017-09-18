/**
 * 061：格式化当前日期（DateFormat）
 */


import java.util.Date;
import java.text.DateFormat;
import java.util.Locale;

public class FormatDate {
    public static void main(String[] args) {
        Date date = new Date();
        DateFormat formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);
        String string = formater.format(date);
        System.out.println("中国日期：\t" + string);
        formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.CANADA);
        System.out.println("加拿大日期：\t" + formater.format(date));
        formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.JAPAN);
        System.out.println("日本日期：\t" + formater.format(date));
        formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.FRANCE);
        System.out.println("法国日期：\t" + formater.format(date));
        formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.GERMAN);
        System.out.println("德国日期：\t" + formater.format(date));
        formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.ITALIAN);
        System.out.println("意大利日期：\t" + formater.format(date));
    }
}

/*
运行结果：

中国日期：	2017年9月18日 星期一
加拿大日期：	Monday, September 18, 2017
日本日期：	2017年9月18日
法国日期：	lundi 18 septembre 2017
德国日期：	Montag, 18. September 2017
意大利日期：	lunedì 18 settembre 2017

 */
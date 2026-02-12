package com.digital;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.math.RoundingMode;
import java.util.Locale;

public class DecimalFormatDemo {

    /**
     * 根据传入的格式模板格式化数字
     * @param pattern 格式规则
     * @param value   要格式化的数字
     */
    public static void customFormat(String pattern, double value) {
        // 创建格式化对象，传入格式规则
        DecimalFormat myFormatter = new DecimalFormat(pattern);

        // 按规则格式化
        String output = myFormatter.format(value);

        // 打印结果
        System.out.println(value + "  " + pattern + "  " + output);
    }

    public static void main(String[] args) {

        // ================== ① 基本格式演示 ==================
        customFormat("###,###.###", 123456.789);  // 千位分隔 + 小数
        customFormat("###.##", 123456.789);       // 最多2位小数
        customFormat("000000.000", 123.78);       // 不够补0
        customFormat("$###,###.###", 123456.789); // 加货币符号

        System.out.println("================================");

        // ================== ② 自定义分隔符 ==================

        // 创建符号对象（用于自定义小数点和千分位）
        DecimalFormatSymbols unusualSymbols =
                new DecimalFormatSymbols(Locale.getDefault());

        // 把小数点改成 '|'
        unusualSymbols.setDecimalSeparator('|');

        // 把千分位改成 '^'
        unusualSymbols.setGroupingSeparator('^');

        // 格式规则
        String pattern = "#,##0.###";

        // 使用自定义符号创建 DecimalFormat
        DecimalFormat myFormatter = new DecimalFormat(pattern, unusualSymbols);

        // 打开分组（千位分隔）
        myFormatter.setGroupingUsed(true);

        double number = 123456.789;
        String output = myFormatter.format(number);

        System.out.println("自定义分隔符结果: " + output);
        // 可能输出：123^456|789

        System.out.println("================================");

        // ================== ③ 指定舍入规则 ==================

        // 创建只保留1位小数的格式
        DecimalFormat df = new DecimalFormat("#.#");

        // 设置舍入模式：银行家舍入（HALF_EVEN）
        df.setRoundingMode(RoundingMode.HALF_EVEN);

        double num1 = 3.25;
        double num2 = 3.35;

        String result1 = df.format(num1);
        String result2 = df.format(num2);

        System.out.println("3.25 is rounded to " + result1);
        System.out.println("3.35 is rounded to " + result2);

        /*
         HALF_EVEN 规则：
         3.25 → 3.2  （5前是2，偶数，舍去）
         3.35 → 3.4  （5前是3，奇数，进位）
        */
    }
}


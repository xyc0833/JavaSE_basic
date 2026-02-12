package com.digital;

public class MathDemo {
    public static void main(String[] args) {
        // 常量
        System.out.println(Math.PI);
        System.out.println(Math.E);

        // 绝对值
        double a = -123456.36695;
        System.out.printf("abs: %.2f%n", Math.abs(a));

        // 取整
        double b = 43.4;
        System.out.printf("ceil: %.2f%n", Math.ceil(b));
        System.out.printf("floor: %.2f%n", Math.floor(b));
        System.out.printf("rint: %.2f%n", Math.rint(b));

        // 四舍五入
        System.out.println("round: " + Math.round(3.6));

        // 幂运算
        System.out.println("pow: " + Math.pow(2, 3));

        // 开方
        System.out.println("sqrt: " + Math.sqrt(16));

        // 最大最小
        System.out.println("max: " + Math.max(5, 8));

        // 随机数
        System.out.println("random: " + Math.random());

        // 额外的数学运算示例
        double x = 11.635;
        double y = 2.76;

        System.out.printf("The value of e is %.4f%n", Math.E);
        System.out.printf("exp(%.3f) is %.3f%n", x, Math.exp(x));
        System.out.printf("log(%.3f) is %.3f%n", x, Math.log(x));
        System.out.printf("pow(%.3f, %.3f) is %.3f%n", x, y, Math.pow(x, y));
        System.out.printf("sqrt(%.3f) is %.3f%n", x, Math.sqrt(x));

        double degrees = 45.0;
        double radians = Math.toRadians(degrees);

        System.out.printf("The value of pi is %.4f%n", Math.PI);
        System.out.printf("The sine of %.1f degrees is %.4f%n", degrees, Math.sin(radians));
        System.out.printf("The cosine of %.1f degrees is %.4f%n", degrees, Math.cos(radians));
        System.out.printf("The tangent of %.1f degrees is %.4f%n", degrees, Math.tan(radians));
        System.out.printf("The arcsine of %.4f is %.4f degrees%n", Math.sin(radians), Math.toDegrees(Math.asin(Math.sin(radians))));
        System.out.printf("The arccosine of %.4f is %.4f degrees%n", Math.cos(radians), Math.toDegrees(Math.acos(Math.cos(radians))));
        System.out.printf("The arctangent of %.4f is %.4f degrees%n", Math.tan(radians), Math.toDegrees(Math.atan(Math.tan(radians))));
    }
}

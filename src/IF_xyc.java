import java.util.Scanner;

import javax.xml.ws.AsyncHandler;

public class IF_xyc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 20;
		if(n>15) {
			System.out.println("优秀");
		}else if(n<30) {
			System.out.println("可以的");
		}else {
			System.out.println("ok");
		}
		//浮点数用 == 判断不靠谱
		//利用差值小于某个绝对值来判断
		double x = 1 - 9.0 / 10;
		// FIXME:
		if (Math.abs(x-0.1) < 0.0001) {
			System.out.println("x is 0.1");
		} else {
			System.out.println("x is NOT 0.1");
		}
		System.out.println("x = " + x);
		//引用类型 用 == 判断是否指向同一个对象
		//euqals()判断内容是否相等
		String s1 = "hello";
		String s2 = "HELLO".toLowerCase();
		if (s1 == s2) {
			System.out.println("s1 == s2");
		}
		if (s1.equals(s2)) {
			System.out.println("s1.equals(s2)");
		}
		/**
		 * BMI = 体重(kg)除以身高(m)的平方
		 * 
		 * 过轻：低于18.5
		 * 正常：18.5-25
		 * 过重：25-28
		 * 肥胖：28-32
		 * 非常肥胖：高于32
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.print("Height (m): ");
		double height = scanner.nextDouble();
		System.out.print("Weight (kg): ");
		double weight = scanner.nextDouble();
		// FIXME:
		//double bmi = 0;
		// TODO: 打印BMI值及结果
		double bmi = weight /(height*height);
		if(bmi<18.5) {
			System.out.println("过轻");
		}else if(bmi>=18.5 && bmi<=25) {
			System.out.println("正常");
		}else if(bmi>25 && bmi<=28) {
			System.out.println("过重");
		}else {
			System.out.println("非常肥胖");
		}
		
	}

}

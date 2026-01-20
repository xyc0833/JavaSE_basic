import java.util.Scanner;

public class IntOps_ShiftOps {
	public static void main(String[] args) {
		
		int n = 100/9;
		System.out.println(n);
		
		int m = 12312 % 100;
		System.out.println(m);
		// 注意运算结果溢出不会报错:
		int x = 2147483647 + 1;
		System.out.println(x); // -2147483648
		int y = 100000000 * 100000000;
		System.out.println(y);
		
		int a = 5;
		int a2 = a << 1;
		System.out.println(a2);
		int a3 = a >> 1;
		System.out.println(a3);
		int a4 = a3 << 23;
		System.out.println(a4);
		
		char b = 'b';
		String s = "hello";
		System.out.println(s);
		s = s + "world";
		System.out.println(s);
		
		int [] ns = new int[5];
		System.out.println(ns.length);
		
		/**
		 * 练习
		计算前N个自然数的和可以根据公示
		(1 + N) * N
		请根据公式计算前N个自然数的和
		 */
		//创建一个 scanner用于接受输入
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入正整数");
		int k = sc.nextInt();
		String nameString = sc.nextLine();
		if(k < 0) {
			System.out.println("输入必须为正整数！");
		}else {
			long sum = (1 + k) * k / 2;
			System.out.println("前 " + k + " 个自然数的和是：" + sum);
		}
		sc.close();
		int abc = k >=0 ? a : -a;
		System.out.println(abc);
		

		
	}
}

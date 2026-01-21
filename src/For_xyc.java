import java.util.Iterator;

public class For_xyc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {1,2,3,4,5};
		for(int x: arr) {
			System.out.println(x);
		}
		String[] names = {"java","python","ruby"};
		//String[] names = { "Java", "Python", "Ruby", "PHP" };
		/*
		TODO: 请输出“序号: 名称”，即：
		  1: Java
		  2: Python
		  3: Ruby
		  4: PHP
		序号从1开始
		*/
		for(int i=0;i<names.length;i++) {
			System.out.println((i+1)+": "+names[i]);
		}
		
		int[] ns = { 1, 4, 9, 16, 25 };
		// FIXME: 请输出1, 4, 9, 16, 25 
		// 即每个元素后面打印一个逗号和空格，但最后一个元素除外:
		for (int i = 0; i < ns.length-1; i++) {
			System.out.print(ns[i]);
			System.out.print(", ");
		}
		System.out.println(ns[ns.length-1]);
		// TODO: 利用for循环计算1+2+3+...+100:
		int sum = 0;
		for (int i = 1; i <=100 ; i++) {
			sum = sum + i;
		}
		System.out.println(sum); // 检查是否是5050
		int[] ns01 = { 1, 2, 3, 4, 5 };
		// TODO: 利用for each循环求数组每个元素平方的和
		// 即 1*1+2*2+3*3+4*4+5*5=?
		int sum01 = 0;
		for(int i=0;i<ns01.length;i++) {
			sum01 = sum01 + ns01[i]*ns01[i];
		}
		System.out.println(sum01); // 检查结果是否为55
		
		
		int[] ns02 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		int sum02 = 0;
		for (int i = 0; i < ns02.length; i++) {
			if (i == 5) {
				System.out.println("break");
				break;
			}
			System.out.println("add ns[" + i + "]");
			sum02 = sum02 + ns02[i];
		}
		System.out.println(sum02);
		
		
		int[] ns03 = { 31, 21, 22, 73, 79, 56, 7, 83, 19, 12, 53, 84, 68 };
		int sumOfOdds = 0;
		for (int n : ns03) {
			if (n % 2 == 0) {
				System.out.println("skip " + n);
				continue;
			}
			sumOfOdds = sumOfOdds + n;
		}
		System.out.println(sumOfOdds);
	}

}

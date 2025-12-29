
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
		
	}
}

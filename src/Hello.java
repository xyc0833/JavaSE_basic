/**
 * 注释的学习
 */
public class Hello {

	public static void main(String[] args) {
		int n = 100;
		System.out.println(n);
		n = 200;
		System.out.println(n);
		int x = n;
		System.out.println(x);
		x = x + n;
		System.out.println(x);
		System.out.println(n);
		
		float f1 = 3.14F;
		float f2 = 3.12e23F;  // 科学计数法表示的3.4x10的38次方
		double d1 = 4.123132;
		double d2 = 3.123e-123;
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(d1);
		System.out.println(d2);
		
		long abc = 9000000000000000000l;
		int i1 = 0xff0000;// 十六进制表示的十进制16711680
		int i2 = 0b1000000000;// 二进制表示的十进制512
		System.out.println(i1);
		System.out.println(i2);
		
		System.out.println(Integer.toHexString(12345677));// 输出十六进制表示的整型：
		System.out.println(Integer.toBinaryString(i1));// 输出二进制表示的整型：


	}

}

import java.util.Scanner;

public class Switch_while_xyc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int opt = sc.nextInt();
		//记得一定要加上 break
		switch(opt) {
		case 1:
			System.out.println("1");
			break;
		case 2:
			System.out.println("xyc");
			break;
		default:
			break;
	
		}
		
		int sum = 0;
		int n = 1;
		while (n < 10) {
			sum = sum + n;
			n++;
		}
		System.out.println(n);
		System.out.println(sum);
		
		int sum02 = 0;
		int n02 = 1;
		do {
			sum02 = sum02 + n02;
			n++;
		} while (n02 < 10);
		System.out.println(n02);
		System.out.println(sum02);
	}

}

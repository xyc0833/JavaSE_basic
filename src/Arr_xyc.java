import java.util.Arrays;

public class Arr_xyc {
	public static void main(String[] args) {
		int[] ns01 = { 1, 1, 2, 3, 5, 8 };
		System.out.println(ns01); // 类似 [I@7852e922
		//得到数组在 jvm 变量中的引用地址
		System.out.println(Arrays.toString(ns01));
		//Arrays.toString(ns);
		//该方法可以快速打印数组
		
		int[] ns = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
		// 排序前:
		System.out.println(Arrays.toString(ns));
		// TODO: 修改为从大到小排序:
		for (int i = 0; i < ns.length; i++) {
			for (int j = i + 1; j < ns.length; j++) {
				if (ns[i] < ns[j]) {
					// 交换ns[i]和ns[j]:
					int tmp = ns[j];
					ns[j] = ns[i];
					ns[i] = tmp;
				}
			}
		}
		// 排序后:
		System.out.println(Arrays.toString(ns));
		
		Arrays.sort(ns);
		System.out.println(Arrays.toString(ns));
		
		int [][] arr02 ;
		
		int[][] stds = {
				// 语文, 数学, 英语, 体育
				{ 68, 79, 95, 81 },
				{ 91, 89, 53, 72 },
				{ 77, 90, 87, 83 },
				{ 92, 98, 89, 85 },
				{ 94, 75, 73, 80 }
		};
		System.out.println(stds.length);
		//遇到多维数组 打印的是内存地址
		//[[I@3d24753a, [I@59a6e353, [I@7a0ac6e3, [I@71be98f5, [I@6fadae5d]
		System.out.println(Arrays.toString(stds));
		//deeptostring方法
		//把“嵌套对象 / 多维数组”的内容，递归地转换成字符串
		System.out.println(Arrays.deepToString(stds));
		// TODO: 遍历二维数组，获取每个学生的平均分:
		for (int[] std : stds) {
			int sum = 0;
			for(int i = 0;i<std.length;i++) {
				sum = sum + std[i];
			}
			int avg = sum / std.length;
			System.out.println("Average score: " + avg);
		}
		// TODO: 遍历二维数组，获取语文、数学、英语、体育的平均分:
		int[] sums = { 0, 0, 0, 0 };
		for (int[] std : stds) {
			for(int j=0;j<std.length;j++) {
				sums[j] = std[j] + sums[j]; 
			}
		}
		System.out.println("Average Chinese: " + sums[0] / stds.length);
		System.out.println("Average Math: " + sums[1] / stds.length);
		System.out.println("Average English: " + sums[2] / stds.length);
		System.out.println("Average Physical: " + sums[3] / stds.length);
		
		
		
		System.out.println("Number of args: " + args.length);
		for (String arg : args) {
			System.out.println(arg);
		}
	}
}

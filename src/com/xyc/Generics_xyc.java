package com.xyc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
//import java.util.TimSort;
//import java.util.Arrays.LegacyMergeSort;

public class Generics_xyc {

	public static void main(String[] args) {
		ArrayList<String> abc = new ArrayList<String>();
		abc.add("xyc01");
		abc.add("xyc02");
		for(String p : abc) {
			System.out.println(p);
		}
		System.out.println(abc.get(0));
		
		List<String> list = new ArrayList<String>();
		list.add("Test");
		String first = list.get(0);
		System.out.println(first);

		String[] strs = { "Apple", "Pear", "Orange" };
		Arrays.sort(strs);
		System.out.println(Arrays.toString(strs));
		

		//Arrays.sort(null, null); //带泛型的 sort方法
		
		//Score<Integer> score1 = new Score<Integer>("数据结构与算法基础", "EP074512", 90);
		//Score<String> score2 = new Score<>("数据结构与算法基础", "EP074512", "优秀");
		//这种什么类型都不写的 通过自动类型推断来得到的 称之为钻石运算符
		
		
		//如果要让某个变量支持引用确定了任意类型的泛型，那么可以使用?通配符：
		Score<String,String,Integer> s3 = new Score<>("123", "12321", 123);
		//<?> 表示匹配所有类型
		
        A a = new A();
        Integer i = a.test();
	}
	
	abstract class Test<T>{
		T name;
	}
	interface Study<T>{
		T study(T t);
	}
	
    static class A implements Study<Integer> {   
      	//在实现接口或是继承父类时，如果子类是一个普通类，那么可以直接明确对应类型
        public Integer test() {
            return null;
        }

		@Override
		public Integer study(Integer t) {
			// TODO Auto-generated method stub
			return null;
		}
    }
    
    //第一个 <T>：表示 这是一个泛型声明
    //中间的T 类似于 void 表示返回类型T 
    //括号里：T t 是方法的参数，类型为 T，也就是方法接受一个类型为 T 的值
    //在返回值类型前添加<>并填写泛型变量表示这个是一个泛型方法
    private static <T> T Test02(T t){
    	
    	return t;
    }
    
    
	
    //Arrays.sort(null, null); //带泛型的 sort方法
    //T[] a 传入T类型的数组
//    Comparator的比较规则
    //大于1 表示前面比后面大
    //小于1 表示前面比后面小
    
//	public static <T> void sort(T[] a, Comparator<? super T> c) {
//        if (c == null) {
//            sort(a);
//        } else {
//            if (LegacyMergeSort.userRequested)
//                legacyMergeSort(a, c);
//            else
//                TimSort.sort(a, 0, a.length, c, null, 0, 0);
//        }
//    }

    

public class Score02<T extends Number>{
    private final String name;
    private final String id;
    private final T value;

    public Score02(String name, String id, T value) {
        this.name = name;
        this.id = id;
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
}

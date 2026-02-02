package com.xyc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Properties;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import javax.print.DocFlavor.STRING;
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
        
        List<String> list2 = new ArrayList<String>();
        list2.add("abc");
        list2.add("piter");
        list2.add("orange");
        
        for(String p: list2) {
        	System.out.println(p);
        }
        System.out.println(list2.get(0));
        
		List<Person> list03 = new ArrayList<>();
		list03.add(new Person("Ming", 12));
		list03.add(new Person("Hong", 15));
		list03.add(new Person("Jun", 18));
		System.out.println(list03);
		//contains 用来判断：List 里有没有“某个元素”
		//返回true 或者 false
		System.out.println(list03.contains(new Person("Jun", 18)));
		System.out.println(list03.indexOf(new Person("Jun", 18)));
		
		//asList方法
		//把数组“包装成”一个 List 视图
		//不改变长度
		//只是改数组对应位置的值
		
		
		List<Person> list04 = Arrays.asList(new Person("Ming", 12), new Person("Hong", 15), new Person("Jun", 18));
		Map<String, Person> map = new HashMap<>();
		for (Person p : list04) {
			//key是 person的name value存放person本身
			map.put(p.getName(), p);
		}
		System.out.println(map.get("Jun"));
		System.out.println(map.get("Mark"));

		
		
		//keySet() 返回的是 Map 中所有 key 组成的 Set，而且这个 Set 和 Map 是“联动”的
		for(String p:map.keySet()) {
			System.out.println(p + "->" + map.get(p));
		}
		//等价于
		//entrySet() 把 Map 里的每一组 key-value 封装成一个 Entry 对象的集合
		//通过entry对象 可以同时拿到 key  和 value
		for(Map.Entry<String, Person> entry:map.entrySet()) {
			System.out.println(entry.getKey() + entry.getValue());
		}
		
		
		Map<String, Integer> map02 = new HashMap<>();
		map02.put("Tom", 18);
		map02.put("Jerry", 20);

		Set<String> keys01 = map02.keySet();
		System.out.println(keys01); // [Tom, Jerry]
		
		Properties props = new Properties();
		try {
			props.load(Generics_xyc.class.getResourceAsStream("/com/xyc/setting.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = props.getProperty("url");
		String lang = props.getProperty("language");
		String title = props.getProperty("course.title");
		String description = props.getProperty("course.description");
		System.out.println(url);
		System.out.println(lang);
		System.out.println(title);
		System.out.println(description);
		
		Queue<Person> queue = new LinkedList<Person>();
		queue.offer(new Person("ming",12));
		queue.offer(new Person("xyc",18));
		queue.offer(new Person("hong",13));
		System.out.println(queue.poll());
		
		//尝试用迭代器遍历队列
		Iterator<Person> iterator = queue.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		
		//优先队列
		//一种是通过在person类上实现comperable接口
		Queue<Person> queue02 = new PriorityQueue<>();
		queue02.offer(new Person("Ming", 12));
		queue02.offer(new Person("Hong", 15));
		queue02.offer(new Person("Jun", 17));
		System.out.println(queue02.poll());
		System.out.println(queue02.poll());
		System.out.println(queue02.poll());
		
		//还有一种写法
		Queue<Person> queue03 = new PriorityQueue<>(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				//按照名字的顺序倒叙排序
				return - o1.getName().compareTo(o2.getName());
			}
		});
		
		
		//借鉴了匿名内部类的写法
		/***
		 * new Comparator<Person>() {
		    @Override
		    public int compare(Person o1, Person o2) {
		        return 0; // 你可以自定义的比较逻辑
		    }
		}
		如果一个接口中有且只有一个待实现的抽象方法，那么我们可以将匿名内部类简写为Lambda表达式：

		初学理解：Lambda表达式就是匿名内部类的简写
		标准格式为：([参数类型 参数名称,]...) ‐> { 代码语句，包括返回值 }
		
		注意，如果方法体中只有一个返回语句，可以直接省去花括号和return关键字：
		Study study = (a) -> {
		    return "今天学会了"+a;   //这种情况是可以简化的
		};
		等价于
		Study study = (a) -> "今天学会了"+a;
		
		如果参数只有一个，那么可以省去小括号：
		Study study = a -> "今天学会了"+a;
		
		 */
		
		//再简化一下 参考Lambda表达式的写法
		Queue<Person> queue04 = new PriorityQueue<Person>((o1,o2)-> -o1.getName().compareTo(o2.getName()));
		
		Deque<String> deque = new LinkedList<>();
		deque.offerLast("end"); // "end"
		deque.offerFirst("C"); // "C", "end"
		deque.offerFirst("B"); // "B", "C", "end"
		deque.offerFirst("A"); // "A", "B", "C", "end"
		System.out.println(deque.pollLast());
		System.out.println(deque.pollFirst());
		System.out.println(deque.pollFirst());
		System.out.println(deque.pollFirst());
		System.out.println(deque.pollFirst());
		
		
		
		List<String> list05 = new ArrayList<>(Arrays.asList("A", "B", "C"));
		List<String> readOnlyList = Collections.unmodifiableList(list05);
		System.out.println(readOnlyList);
		//readOnlyList.add("X");
        
        
	}
    public static int evaluate(String expression) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : expression.split(" ")) {
            if (token.matches("\\d+")) {
                // 如果是数字，入栈
                stack.push(Integer.parseInt(token));
            } else {
                // 否则，弹出两个数，进行运算，并把结果压入栈中
                int b = stack.pop();
                int a = stack.pop();
                
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            }
        }
        
        return stack.pop(); // 最后的结果在栈顶
    }
	
	static List<String> removeDuplicate(List<String> list) {
		Set<String> set = new HashSet<>(list);
		return new ArrayList<String>(set);
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
    
    /**
     * 现在有一个新的需求，现在没有String类型的成绩了，但是成绩依然可能是整数，
	也可能是小数，这时我们不希望用户将泛型指定为除数字类型外的其他类型，
	我们就需要使用到泛型的上界定义：
     * */
    //这里T这个参数只能是 数据相关的了
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

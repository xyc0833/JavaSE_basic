package com.thread;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

public class Xyc_thread_local {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//我们可以使用ThreadLocal类，来创建工作内存中的变量，
		//它将我们的变量值存储在内部（只能存储一个变量），不同的线程访问到ThreadLocal对象时，
		//都只能获取到当前线程所属的变量。
//		ThreadLocal<String> local = new ThreadLocal<String>();
//		Thread t1 = new Thread(()->{
//			local.set("hello xyc");//将变量的值给予ThreadLocal
//			System.out.println("变量值已设定！");
//			System.out.println(local.get());   //尝试获取ThreadLocal中存放的变量
//		});
//		Thread t2 = new Thread(()->{
//			//System.out.println(local.get()); //null
//			
//	        local.set("yyds");   //将变量的值给予ThreadLocal
//	        System.out.println("线程2变量值已设定！");
//	        System.out.println(local.get()); //yyds
//		});
//	    t1.start();
//	    Thread.sleep(3000);    //间隔三秒
//	    t2.start();
	    
	    //不同线程向ThreadLocal存放数据，只会存放在线程自己的工作空间中，
	    //而不会直接存放到主内存中，因此各个线程直接存放的内容互不干扰。
		
		//多线程处理定时任务： 定时器
		
//		Timer timer = new Timer();//创建一个定时器对象
//		//注意这个是一个抽象类，不是接口，无法使用lambda表达式简化，只能使用匿名内部类
//		timer.schedule(new TimerTask() {
//	        @Override
//	        public void run() {
//	            System.out.println(Thread.currentThread().getName());    //打印当前线程名称
//	            System.out.println("123123");
//	            timer.cancel();//一定要在这里 cancel
//	        }//执行一个延时任务
//		}, 1000,10);//延迟一秒
		
		
		//守护线程
		
//	    Thread t = new Thread(() -> {
//	        while (true){
//	            try {
//	                System.out.println("程序正常运行中...");
//	                Thread.sleep(1000);
//	            } catch (InterruptedException e) {
//	                e.printStackTrace();
//	            }
//	        }
//	    });
//	    //把 t 设置为守护线程（必须在开始之前 中途是不允许转换的）
//	    t.setDaemon(true);
//	    //上面这行注释掉 程序会一直运行
//	    //设置为守护线程之后 主线程停止之后 守护线程也会跟着停止
//	    t.start();
//	    for(int i=0;i<5;i++) {
//	    	//这个是主线程 让他睡个5秒钟
//	    	Thread.sleep(1000);
//	    }
		
		//再谈集合类
		
//		Vector<Integer> list = new Vector<>();
//	    new Thread(() -> {
//	        for (int i = 0; i < 1000; i++) {
//	            list.add(i);   //两个线程同时操作集合类进行插入操作
//	        }
//	    }).start();
//	    new Thread(() -> {
//	        for (int i = 1000; i < 2000; i++) {
//	            list.add(i);
//	        }
//	    }).start();
//	    Thread.sleep(2000);
//	    System.out.println(list.size());
		
		//多线程中的流： 并行流
		
//	    List<Integer> list = new ArrayList<>(Arrays.asList(1, 4, 5, 2, 9, 3, 6, 0));
//	    int[] arr = new int[]{1, 4, 5, 2, 9, 3, 6, 0};
//	    Arrays.parallelSort(arr);
//	    System.out.println(Arrays.toString(arr));
//	    
//	    list
//	            .parallelStream()    //获得并行流
//	            //.forEach(i -> System.out.println(Thread.currentThread().getName()+" -> "+i));
//	    		//创建了很多线程 同时的去执行流水线
//	    		/** 实际打印出来不是循序执行
//	    		 * main -> 3
//				ForkJoinPool.commonPool-worker-2 -> 0
//				ForkJoinPool.commonPool-worker-1 -> 5
//				ForkJoinPool.commonPool-worker-3 -> 4
//				ForkJoinPool.commonPool-worker-3 -> 1
//				main -> 9
//				ForkJoinPool.commonPool-worker-2 -> 6
//				ForkJoinPool.commonPool-worker-1 -> 2
//	    		 */
//	    //我们可以通过调用forEachOrdered()方法来使用单线程维持原本的顺序：
//	    .forEachOrdered(i -> System.out.println(Thread.currentThread().getName()+" -> "+i));
		
	    
	    //更多地使用并行方法，可以更加充分地发挥现代计算机多核心的优势，但是同时需要注意多线程产生的异步问题
		
	    int[] arr = new int[]{1, 4, 5, 2, 9, 3, 6, 0};
	    Arrays.parallelSetAll(arr, i -> {
	        System.out.println(Thread.currentThread().getName() +" " + i);
	        return arr[i];
	    });
	    System.out.println(Arrays.toString(arr));
	}

}

package com.thread;

import java.awt.geom.Point2D;
import java.util.Timer;
import java.util.TimerTask;

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
		Timer timer = new Timer();//创建一个定时器对象
		//注意这个是一个抽象类，不是接口，无法使用lambda表达式简化，只能使用匿名内部类
		timer.schedule(new TimerTask() {
	        @Override
	        public void run() {
	            System.out.println(Thread.currentThread().getName());    //打印当前线程名称
	        }//执行一个延时任务
		}, 1000);//延迟一秒
		
	}

}

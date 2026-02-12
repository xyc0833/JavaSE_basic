package com.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class Xyc_thread {
	private static int value = 0;

	public static void main(String[] args) throws InterruptedException{
//	    ThreadMXBean bean = ManagementFactory.getThreadMXBean();
//	    long[] ids = bean.getAllThreadIds();
//	    ThreadInfo[] infos = bean.getThreadInfo(ids);
//	    for (ThreadInfo info : infos) {
//	        System.out.println(info.getThreadName());
//	    }
		
//		Thread thread = new Thread(new Runnable() {
//			public void run() {
//				
//			}
//		});
		//内部类的写法可以转化为 lambda表达式
//	    Thread t = new Thread(() -> {    //直接编写逻辑
//	        System.out.println("我是另一个线程！");
//	    });
//	    t.start();   //调用此方法来开始执行此线程
		
//	    Thread t = new Thread(() -> {
//	        System.out.println("我是线程："+Thread.currentThread().getName());
//	        System.out.println("我正在计算 0-10000 之间所有数的和...");
//	        int sum = 0;
//	        for (int i = 0; i <= 10000; i++) {
//	            sum += i;
//	        }
//	        System.out.println("结果："+sum);
//	    });
//	    t.start();
//	    System.out.println("我是主线程！");
	    //我们发现，这段代码执行输出结果并不是按照从上往下的顺序了，
	    //因为他们分别位于两个线程，他们是同时进行的！
		
//	    Thread t1 = new Thread(() -> {
//	        for (int i = 0; i < 50; i++) {
//	            System.out.println("我是一号线程："+i);
//	        }
//	    });
//	    Thread t2 = new Thread(() -> {
//	        for (int i = 0; i < 50; i++) {
//	            System.out.println("我是二号线程："+i);
//	        }
//	    });
//	    t1.start();
//	    t2.start();
//		Thread t3 = new Thread(()->{
//			
//		});
//		
//	    Thread t1 = new Thread(() -> {
//	        for (int i = 0; i < 10000; i++) value++;
//	        System.out.println("线程1完成");
//	    });
//	    Thread t2 = new Thread(() -> {
//	        for (int i = 0; i < 10000; i++) value++;
//	        System.out.println("线程2完成");
//	    });
//	    t1.start();
//	    t2.start();
//	    Thread.sleep(1000);  //主线程停止1秒，保证两个线程执行完成
//	    System.out.println(value);
	     
	    
//	    Thread t = new Thread(() -> {
//	        try {
//	            Thread.sleep(10000);  //休眠10秒
//	        } catch (InterruptedException e) {
//	            e.printStackTrace();
//	        }
//	    });
//	    t.start();
//	    try {
//	        Thread.sleep(3000);   //休眠3秒，一定比线程t先醒来
//	        t.interrupt(); //调用t的interrupt方法
//	    } catch (InterruptedException e) {
//	        e.printStackTrace();
//	    }
		
//	    Thread t = new Thread(() -> {
//	        System.out.println("线程开始运行！");
//	        while (true){   //无限循环
//	            if(Thread.currentThread().isInterrupted()){   //判断是否存在中断标志
//	                break;   //响应中断
//	            }
//	        }
//	        System.out.println("线程被中断了！");
//	    });
//	    t.start();
//	    try {
//	        Thread.sleep(3000);   //休眠3秒，一定比线程t先醒来
//	        t.interrupt();   //调用t的interrupt方法
//	    } catch (InterruptedException e) {
//	        e.printStackTrace();
//	    }
		
		
		/**
		 * MIN_PRIORITY 最低优先级
		MAX_PRIORITY 最高优先级
		NOM_PRIORITY 常规优先级
		 */
//		Thread t = new Thread(()->{
//			System.out.println("线程开始运行");
//		});
//		t.setPriority(Thread.MIN_PRIORITY);
		
		//在当前线程的工作不重要时，将CPU资源让位给其他线程
		//使用yield()方法来将当前资源让位给其他同优先级线程
//		Thread t1 = new Thread(()->{
//	        System.out.println("线程1开始运行！");
//	        for (int i = 0; i < 50; i++) {
//	            if(i % 5 == 0) {
//	                System.out.println("让位！");
//	                Thread.yield();
//	            }
//	            System.out.println("1打印："+i);
//	        }
//	        System.out.println("线程1结束！");
//		});
//	    Thread t2 = new Thread(() -> {
//	        System.out.println("线程2开始运行！");
//	        for (int i = 0; i < 50; i++) {
//	            System.out.println("2打印："+i);
//	        }
//	    });
//	    t1.start();
//	    t2.start();
		
	    //当我们希望一个线程等待另一个线程执行完成后再继续进行，我们可以使用join()方法来实现线程的加入：
//	    Thread t1 = new Thread(() -> {
//	        System.out.println("线程1开始运行！");
//	        for (int i = 0; i < 50; i++) {
//	            System.out.println("1打印："+i);
//	        }
//	        System.out.println("线程1结束！");
//	    });
//	    Thread t2 = new Thread(() -> {
//	        System.out.println("线程2开始运行！");
//	        for (int i = 0; i < 50; i++) {
//	            System.out.println("2打印："+i);
//	            if(i == 10){
//	                try {
//	                    System.out.println("线程1加入到此线程！");
//	                    t1.join();    //在i==10时，让线程1加入，先完成线程1的内容，在继续当前内容
//	                } catch (InterruptedException e) {
//	                    e.printStackTrace();
//	                }
//	            }
//	        }
//	    });
//	    t1.start();
//	    t2.start(); 
	    
	    
	    //线程锁
//	    Thread t1 = new Thread(() -> {
//	        for (int i = 0; i < 10000; i++) {
//	            synchronized (Xyc_thread.class){  //使用synchronized关键字创建同步代码块
//	                value++;
//	            }
//	        }
//	        System.out.println("线程1完成");
//	    });
//	    Thread t2 = new Thread(() -> {
//	        for (int i = 0; i < 10000; i++) {
//	        	//这里的代码细节注意：synchronized是针对同一个类取上锁的
//	            synchronized (Xyc_thread.class){
//	                value++;
//	            }
//	        }
//	        System.out.println("线程2完成");
//	    });
//	    t1.start();
//	    t2.start();
//	    Thread.sleep(1000);  //主线程停止1秒，保证两个线程执行完成
//	    System.out.println(value);
		
		//经典死锁代码
//		Object o1 = new Object();
//	    Object o2 = new Object();
//	    Thread t1 = new Thread(() -> {
//	        synchronized (o1){
//	            try {
//	                Thread.sleep(1000);
//	                synchronized (o2){
//	                    System.out.println("线程1");
//	                }
//	            } catch (InterruptedException e) {
//	                e.printStackTrace();
//	            }
//	        }
//	    });
//	    Thread t2 = new Thread(() -> {
//	        synchronized (o2){
//	            try {
//	                Thread.sleep(1000);
//	                synchronized (o1){
//	                    System.out.println("线程2");
//	                }
//	            } catch (InterruptedException e) {
//	                e.printStackTrace();
//	            }
//	        }
//	    });
//	    t1.start();
//	    t2.start();
		
		//wait和notify方法
		//等于是一个 wait 一个 notify是吗
		Object o1 = new Object();
	    Thread t1 = new Thread(() -> {
	        synchronized (o1){
	            try {
	                System.out.println("开始等待");
	                o1.wait();     //进入等待状态并释放锁
	                System.out.println("等待结束！");
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    });
	    Thread t2 = new Thread(() -> {
	        synchronized (o1){
	            System.out.println("开始唤醒！");
	            o1.notify();     //唤醒处于等待状态的线程
	          	for (int i = 0; i < 50; i++) {
	               	System.out.println(i);   
	            }
	          	//唤醒后依然需要等待这里的锁释放之前等待的线程才能继续
	        }
	    });
	    t1.start();
	    Thread.sleep(1000);
	    t2.start();
		
	    
	}

}

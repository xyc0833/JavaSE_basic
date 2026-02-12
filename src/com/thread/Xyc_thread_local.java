package com.thread;

public class Xyc_thread_local {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//我们可以使用ThreadLocal类，来创建工作内存中的变量，
		//它将我们的变量值存储在内部（只能存储一个变量），不同的线程访问到ThreadLocal对象时，
		//都只能获取到当前线程所属的变量。
		ThreadLocal<String> local = new ThreadLocal<String>();
		Thread t1 = new Thread(()->{
			local.set("hello xyc");
			
			
		});
		
	}

}

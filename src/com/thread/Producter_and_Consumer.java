package com.thread;

import java.awt.TexturePaint;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.bouncycastle.crypto.tls.NewSessionTicket;

public class Producter_and_Consumer {

	private static Queue<Object> queue = new LinkedList<Object>();
	
	public static void main(String[] args) {
		new Thread(Producter_and_Consumer::product,"厨师1").start();
		new Thread(Producter_and_Consumer::product,"厨师2").start();
		
		new Thread(Producter_and_Consumer::consum,"顾客1").start();
		new Thread(Producter_and_Consumer::consum,"顾客2").start();
		new Thread(Producter_and_Consumer::consum,"顾客3").start();

	}

	//生产方法
	private static void product() {
		while (true) {
			try {
				//先休眠3秒钟
				Thread.sleep(3000);
				synchronized (queue) {
					//然后可以出餐了
					String nameString = Thread.currentThread().getName();
					System.out.println(new Date() + " " + nameString + "出餐了");
					queue.offer(new Object());
					queue.notifyAll();//厨师出餐的时候应该提醒一下顾客 我们这边出餐了
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//消费方法
	private static void consum() {
		while (true) {
			try {
				synchronized (queue) {
					//如果队列为空 进入等待状态
					while(queue.isEmpty() == true) {
						queue.wait();//让当前线程暂时处于阻塞状态 除非别人去唤醒他
					}
					queue.poll();//取出并删除队头元素 //同一时间只能有一个人 拿菜
					String nameString = Thread.currentThread().getName();
					System.out.println(new Date() + " " + nameString + "在吃饭了");

					Thread.sleep(4000);
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

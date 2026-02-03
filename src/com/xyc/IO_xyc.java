package com.xyc;

import java.io.BufferedReader;
import java.io.Writer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.omg.CosNaming.NamingContextPackage.NotEmpty;

public class IO_xyc {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		File macFile = new File("/Users/xuyaochen/eclipse-workspace/JavaSE_basic/README.md");
		System.out.println(macFile.isFile());
		System.out.println(macFile.getPath());
		System.out.println(macFile.getAbsolutePath());
		System.out.println(macFile.getCanonicalPath());
		
		
		//参考学习这种写法
		

	    //注意，这种语法只支持实现了AutoCloseable接口的类！
	    try(FileInputStream inputStream = new FileInputStream("/Users/xuyaochen/eclipse-workspace/JavaSE_basic/README.md")) {  
	    	 //直接在try()中定义要在完成之后释放的资源
//			int n;
//			while ((n = inputStream.read()) != -1) {
//				System.out.println(n);
//			}
	    	
	    } catch (IOException e) {   
	    	//这里变成IOException是因为调用close()可能会出现，而FileNotFoundException是继承自IOException的
	        e.printStackTrace();
	    }
	    //无需再编写finally语句块，因为在最后自动帮我们调用了close()
	    
	    //FileInputStream 主要用于处理 文件的字节流。
	    //它是 InputStream 的一个实现，用于读取文件中的字节数据，因此它适合处理 二进制数据 或者需要按字节读取的内容。
	    
	    //文本文件的方式读取文件，使用 BufferedReader 来按行读取
	    
        // 使用 try-with-resources 确保文件资源自动关闭
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/xuyaochen/eclipse-workspace/JavaSE_basic/README.md"))) {
            String line;
            // 按行读取文件并输出内容
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  // 输出每一行内容
            }
        } catch (IOException e) {
            e.printStackTrace();  // 异常处理
        }
        
        //这里 写入的地方放在项目的根目录下  我想把写入的地方 放到com.xyc的包下面 就是相对目录下的话应该怎么操作
		try (OutputStream output = new FileOutputStream("output.txt")) {
			byte[] b1 = "Hello".getBytes("UTF-8");
			output.write(b1);
			byte[] b2 = "你好".getBytes("UTF-8");
			output.write(b2);
		}
		
//		try (OutputStream output = new FileOutputStream("src/com/xyc/output.txt")) {
		
		
//		if (args.length != 2) {
//			System.out.println("Usage: java com.feiyangedu.sample.Main <src-file> <dest-file>");
//			return;
//		}
//		String src = args[0];
//		String dest = args[1];
//		copy(src, dest);
		
		try (InputStream input = new GZIPInputStream(new BufferedInputStream(new FileInputStream("src/com/xyc/test.txt.gz")))) {
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int n;
			while ((n = input.read(buffer)) != -1) {
				output.write(buffer, 0, n);
			}
			byte[] data = output.toByteArray();
			String text = new String(data, "UTF-8");
			System.out.println(123123);
			System.out.println(text);
		}
		
		
		try (ZipInputStream zip = new ZipInputStream(new BufferedInputStream(new FileInputStream("src/com/xyc/test.jar")))) {
			ZipEntry entry = null;
			while ((entry = zip.getNextEntry()) != null) {
				if (entry.isDirectory()) {
					System.out.println("D " + entry.getName());
				} else {
					System.out.println("F " + entry.getName() + " " + entry.getSize());
					printFileContent(zip);
				}
			}
		}
		
		// 从classpath读取txt文件:
		//这里应该是自动读取到 src目录下的
		String data = "output.txt";
		try (InputStream input = IO_xyc.class.getResourceAsStream(data)) {
			if (input != null) {
				System.out.println("Read " + data + "...");
				BufferedReader reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
				System.out.println(reader.readLine());//读了一行的数据
			} else {
				System.out.println("Resource not found: " + data);
			}
		}
		
		String dataFile = "saved.data";
		try (ObjectOutputStream output = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(dataFile)))) {
			// 依次写入 int, String, Person:
			output.writeInt(999);
			output.writeUTF("Hello, world!");
			output.writeObject(new Person("Xiao Ming",17));
		}
		System.out.println("Read...");
		try (ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
			// 依次读入 int, String, Person:
			System.out.println(input.readInt());
			System.out.println(input.readUTF());
			Person p = (Person) input.readObject();
			System.out.println(p);
		}
		
		try(Reader reader = new FileReader("output.txt")){
			int n;
			while((n=reader.read())!= -1 ) {
				System.out.print((char) n);
			}
		}
		
		try (Writer writer = new FileWriter("output.txt")) {
			writer.write("Hello");
			writer.write("xyc  加油");
		}
		
	}
	static void printFileContent(ZipInputStream zip) throws IOException {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int n;
		while ((n = zip.read(buffer)) != -1) {
			output.write(buffer, 0, n);
		}
		byte[] data = output.toByteArray();
		System.out.println("  size: " + data.length);
	}
	
	
//    static void copy(String src, String dest) {
//        try (InputStream inputStream = new FileInputStream(src);
//             OutputStream outputStream = new FileOutputStream(dest)) {
//
//            byte[] buffer = new byte[1024];
//            int bytesRead;
//
//            // 读取源文件并写入目标文件
//            while ((bytesRead = inputStream.read(buffer)) != -1) {
//                outputStream.write(buffer, 0, bytesRead);
//            }
//
//            System.out.println("文件复制完成。");
//        } catch (IOException e) {
//            System.out.println("文件操作出错: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
	
	
	
	static void copy(String src, String dest) {
		// TODO: 将src复制为dest
		try(InputStream inputStream01 = new FileInputStream(src);
				OutputStream outputStream01 = new FileOutputStream(dest)){
			byte[] buffer = new byte[1024];
			int byteRead;
			//读取源文件并写入目标文件
			while((byteRead = inputStream01.read(buffer))!= -1) {
				outputStream01.write(buffer,0,byteRead);
			}
			
			 System.out.println("文件复制完成。");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            System.out.println("文件操作出错: " + e.getMessage());
            e.printStackTrace();
		}
	}

}

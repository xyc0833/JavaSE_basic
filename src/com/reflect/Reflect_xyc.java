package com.reflect;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Reflect_xyc {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException, URISyntaxException, InterruptedException {
		//获取到每个类对应的Class对象
	    Class<String> clazz = String.class;   //使用class关键字，通过类名获取
	    //使用Class类静态方法forName()，通过包名.类名获取，注意返回值是Class<?>
	    Class<?> clazz2 = Class.forName("java.lang.String");  
	    Class<?> clazz3 = new String("cpdd").getClass();  //通过实例对象获取
	    
	    System.out.println(clazz == clazz2);
	    System.out.println(clazz == clazz3);
	    //在JVM中每个类始终只存在一个Class对象，无论通过什么方法获取，都是一样的
	    
	    Class<String[]> calzz01 = String[].class;
	    System.out.println(calzz01.getName());//获取类名称（得到的是包名+类名的完整名称）
	    System.out.println(calzz01.getSimpleName());
	    System.out.println(calzz01.getTypeName());
	    System.out.println(calzz01.getClassLoader());//获取它的类加载器
	   // System.out.println(calzz01.cast(new Integer("10")));//强制类型转换
	    
	    String str = "";
	    System.out.println(str instanceof String);
	    //等价于
	    System.out.println(str.getClass() == String.class);
	    
//	    Class<?> clazz02 = Class.forName("com.xyc.Person");
//	    Object instance = clazz02.newInstance();//创建出person对象
//	    Method method = clazz02.getMethod("test", String.class);
//	    
//	    method.invoke(instance, "what's up");
	    
//	    我们还可以通过反射访问一个类中定义的成员字段也可以修改一个类的对象中的成员字段值，
	    //通过getField()方法来获取一个类定义的指定字段：
//	    Class<?> clazz = Class.forName("com.test.Student");
//	    Object instance = clazz.newInstance();
//
//	    Field field = clazz.getField("i");   //获取类的成员字段i
//	    field.set(instance, 100);   //将类实例instance的成员字段i设置为100
//
//	    Method method = clazz.getMethod("test");
//	    method.invoke(instance);

	    
	    //类加载器
        System.out.println(Reflect_xyc.class.getClassLoader());   //查看当前类的类加载器
        System.out.println(Reflect_xyc.class.getClassLoader().getParent());  //父加载器
        System.out.println(Reflect_xyc.class.getClassLoader().getParent().getParent());  //爷爷加载器
        System.out.println(String.class.getClassLoader());   //JDK中String类的加载器
        
        
        //在之前，如果我们想要快速创建一个Map只能：
        Map<String, Integer> map = new HashMap<>();   //要快速使用Map，需要先创建一个Map对象，然后再添加数据
        map.put("AAA", 19);
        map.put("BBB", 23);

        System.out.println(map);
        //而在Java 9之后，我们可以直接通过of方法来快速创建了
        Map<String, Integer> map02 = Map.of("AAA",18,"bbb",39);
        System.out.println(map02);
        
        //复习stream流
        Stream
        .of("A", "B", "B", "C")   //这里我们可以直接将一些元素封装到Stream中
        .filter(s -> s.equals("B"))   //通过过滤器过滤
        .distinct()   //去重
        //双冒号 表示方法引用

        .forEach(System.out::println);   //最后打印
        
//        Stream
//        .of(null)   //如果传入null会报错
//        .forEach(System.out::println);

        Stream
        .ofNullable(null) //使用新增的ofNullable方法，这样就不会了，不过这样的话流里面就没东西了
        .forEach(System.out::println);
        
        Stream
        .iterate(0, i -> i + 1)   //Java8只能像这样生成无限的流，第一个参数是种子，
        //就是后面的UnaryOperator的参数i一开始的值，最后会返回一个值作为i的新值，
        //每一轮都会执行UnaryOperator并生成一个新值到流中，这个是源源不断的，
        //如果不加limit()进行限制的话，将无限生成下去。
  			.limit(20)   //这里限制生成20个
        .forEach(System.out::println); 
        
        Stream
        //不知道怎么写？参考一下：for (int i = 0;i < 20;i++)
        .iterate(0, i -> i < 20, i -> i + 1)  //快速生成一组0~19的int数据，中间可以添加一个断言，表示什么时候结束生成
        .forEach(System.out::println);
        
        System.out.println("+++=============");
        //Stream还新增了对数据的截断操作，比如我们希望在读取到某个元素时截断，不再继续操作后面的元素
        Stream
        .iterate(0, i -> i + 1)
        .limit(20)
        .takeWhile(i -> i < 10)   //当i小于10时正常通过，一旦大于等于10直接截断
        .forEach(System.out::println);
        
        System.out.println("================");
        
        Stream
        .iterate(0, i -> i + 1)
        .limit(20)
        .dropWhile(i -> i < 10)   //和上面相反，上来就是截断状态，只有当满足条件时再开始通过
        .forEach(System.out::println);
        
        //java 7 的 Try-with-resource
        //Try-with-resource语法现在不需要再完整的声明一个变量了，我们可以直接将现有的变量丢进去
        
        InputStream inputStream = Files.newInputStream(Paths.get("saved.data"));
        try (inputStream) {   //单独丢进try中，效果是一样的
            for (int i = 0; i < 100; i++)
                System.out.print((char) inputStream.read());
        }
        System.out.println("====================");
        
//        Test<String> test = new Test<>("AAA") {   //在低版本这样写是会直接报错的，因为匿名内部类不支持自动类型推断，
//        	//但是很明显我们这里给的参数是String类型的，所以明明有机会进行类型推断，却还是要我们自己填类型，就很蠢
//            //在Java 9之后，这样的写法终于可以编译通过了
//              @Override
//              public String test() {
//                  return t;
//              }
//          };
        
        //java 10新特性
        // String a = "Hello World!";   之前我们定义变量必须指定类型
        var a = "Hello World!";   //现在我们使用var关键字来自动进行类型推断，因为完全可以从后面的值来判断是什么类型
        
        //java 11针对 string 的一些增强
        var str01 = "123123AB\nC\nD 12312312";
        System.out.println("====================");
        System.out.println(str01.isBlank());    //isBlank方法用于判断是否字符串为空或者是仅包含空格
        str
                .lines()   //根据字符串中的\n换行符进行切割，分为多个字符串，并转换为Stream进行操作
                .forEach(System.out::println);
        
        String str02 = "ABCD";   //比如现在我们有一个ABCD，但是现在我们想要一个ABCDABCD这样的基于原本字符串的重复字符串
        System.out.println(str02.repeat(2));  //一个repeat就搞定了
        
        
        String str03 = " A B C D ";
        System.out.println(str03.strip());   //去除首尾空格
        System.out.println(str03.stripLeading());  //去除首部空格
        System.out.println(str03.stripTrailing());   //去除尾部空格
        
        //全新的HttpClient使用  //这个可能暂时没学到 java Web相关内容
//        HttpClient client = HttpClient.newHttpClient();   //直接创建一个新的HttpClient
//      	//现在我们只需要构造一个Http请求实体，就可以让客户端帮助我们发送出去了（实际上就跟浏览器访问类似）
//        HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://www.baidu.com")).build();
//      	//现在我们就可以把请求发送出去了，注意send方法后面还需要一个响应体处理器（内置了很多）这里我们选择ofString直接吧响应实体转换为String字符串
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//      	//来看看响应实体是什么吧
//        System.out.println(response.body());
        
        
//        HttpClient client = HttpClient.newHttpClient();
//        for (int i = 0; i < 10; i++) {  //先不要一次性获取太多，先来10个
//            HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://pic.netbian.com/tupian/"+(29327 + i)+".html")).build();  //这里我们按照规律，批量获取
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//            System.out.println(response.body());  //这里打印一下看看网页
//            String html = response.body();
//            
//            String prefix = "<a href=\"\" id=\"img\"><img src=\"";  //先找好我们要截取的前面一段，作为前缀去匹配位置
//            String suffix = "\" data-pic=";   //再找好我们要截取的屁股后面紧接着的位置，作为后缀去匹配位置
//          	//直接定位，然后前后截取，得到最终的图片地址
//            html = html.substring(html.indexOf(prefix) + prefix.length());
//            html = html.substring(0, html.indexOf(suffix));
//            System.out.println(html);  //最终的图片地址就有了
//        	
//			//创建请求，把图片取到
//            HttpRequest imageRequest = HttpRequest.newBuilder().uri(new URI("https://pic.netbian.com"+html)).build();
//          	//这里以输入流的方式获取，不过貌似可以直接下载文件，各位小伙伴可以单独试试看
//            HttpResponse<InputStream> imageResponse = client.send(imageRequest, HttpResponse.BodyHandlers.ofInputStream());
//          	//拿到输入流和文件输出流
//            InputStream imageInput = imageResponse.body();
//            FileOutputStream stream = new FileOutputStream("images/"+i+".jpg"); //一会要保存的格式
//            try (stream;imageInput){  //直接把要close的变量放进来就行，简洁一些了
//                int size;   //下面具体保存过程的不用我多说了吧
//                byte[] data = new byte[1024];  
//                while ((size = imageInput.read(data)) > 0) {  
//                    stream.write(data, 0, size);
//                }
//            }
//        }
        
        
        
	}
	
	public static String grade(int score){
	    score /= 10;  //既然分数段都是整数，那就直接整除10
	    return switch (score) {   //增强版switch语法
	        case 10, 9 -> "优秀";   //语法那是相当的简洁，而且也不需要我们自己考虑break或是return来结束switch了（有时候就容易忘记，这样的话就算忘记也没事了）
	        case 8, 7 -> "良好"; 
	        case 6 -> "及格";
	        default -> "不及格";
	    };
	}

}

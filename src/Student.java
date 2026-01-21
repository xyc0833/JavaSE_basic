
public class Student extends Person{
	public Student() {
		super();
		System.out.println("创建学生");
	}
	private int score;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void run() {
//		@Override
		System.out.println(name+"student run" + " is running!");
	}
	
	//super 可以调用父类的方法
	public String hello() {
		return super.hello()+"我是学生";
	}
}

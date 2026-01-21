
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
}


	public class Person {

		private static int number;
		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + "]";
		}

		protected String name;
		private int age;
		
		public Person(String name, int age) {
			this.name = name;
			this.age = age;
			number = number+1;
		}
		public Person() {
			this.name = "unnamed";
			this.age = 17;
			number++;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		

		public void setName(String firstName, String lastName) {
			this.name = firstName + " " + lastName;
		}

		public void run() {
			System.out.println(name + " is running!");
		}
		public String hello() {
			return "hello"+ name;
		}
		
		public static int getNumber() {
			return number;
		}

	}

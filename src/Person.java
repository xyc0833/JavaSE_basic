
	public class Person {

		protected String name;
		private int age;
		
		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}
		public Person() {
			this.name = "unnamed";
			this.age = 17;
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
		

	}

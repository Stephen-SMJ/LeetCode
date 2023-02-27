public class User {
	private static int id; //成员变量
	private static String name;
	private int num; //成员变量
	private String address;

	public static void setUser(int id, String name) {
		//int id2; //局部变量
		User.id = id;  //'User.this' cannot be referenced from a static context 静态方法是属于类的，
		User.name = name;
	}

	public void setAddress(int num, String address) {
		this.num=num;
		this.address=address;
	}
	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}

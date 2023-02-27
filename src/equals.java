import java.util.*;
import java.lang.Comparable;

/**
 * @desc equals()的测试程序。
 *
 * @author skywang
 * @emai kuiwu-wang@163.com
 */
public class equals{

	public static void main(String[] args) {
		// 新建2个相同内容的Person对象，
		// 再用equals比较它们是否相等
		Person p1 = new Person("eee", 100);
		Person p2 = new Person("eee", 100);
		System.out.printf("%s\n", p1.equals(p2));
	}

	/**
	 * @desc Person类。
	 */
	private static class Person {
		int age;
		String name;

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public String toString() {
			return name + " - " +age;
		}

		/**
		 * @desc 重写equals方法
		 */
		@Override
		public boolean equals(Object obj){
			if(obj == null){
				return false;
			}

			//如果是同一个对象返回true，反之返回false
			if(this == obj){
				return true;
			}

			//判断是否类型相同
			if(this.getClass() != obj.getClass()){
				return false;
			}
			//与==不同的地方
			Person person = (Person)obj;
			return name.equals(person.name) && age==person.age;
		}
	}
}
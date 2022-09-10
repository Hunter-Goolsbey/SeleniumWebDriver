package Section07;

public class L13_Parameters {
	
	public static void main(String[] args) {
		getName("John", "Smith");
		
	}
	
	public static void getName(String firstName, String lastName) {
		System.out.println("Hello my name is " + firstName + " " + lastName);
	}
}

package testpackage;

public class Test {
	
	
	String name;
	Integer age;
	
//		
//	public String getName()
//	{
//		return name;
//	}
//	
////	Setter method
//		
//	public void setName(String name)
//	{
//		this.name = name;
//	}
//	
//	public Integer getAge()
//	{
//		return age;
//	}
//	
//	public void setAge(Integer age)
//	{
//		this.age = age;
//	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public static void main(String[] args) {
		
		Test t = new Test();
		
		t.setName("Eder");
		
		
		String value = t.getName();
		
		System.out.println(value);//Eder
		
	}
	

}

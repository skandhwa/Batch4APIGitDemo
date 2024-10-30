package POJOMapper;

public class CreateUser {
	
	public static Object createUser()
	{
		
		CreateUserPOJO emp=new CreateUserPOJO();
		emp.setName("Harish");
		emp.setId(12345);
		emp.setSalary(60000);
		emp.setAddress("Delhi");
		
		return emp;
		
		
	}
	
	
	
	

}

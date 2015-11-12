
public class User {
	
	private int userId, age;
	private String firstName, surname, gender, occupation;
	
	public User(int userId, int age, String firstName, String surname, String gender, String occupation)
	{
		this.userId = userId;
		this.age = age;
		this.firstName = firstName;
		this.surname = surname;
		this.gender = gender;
		this.occupation = occupation;
	}
	
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	

}

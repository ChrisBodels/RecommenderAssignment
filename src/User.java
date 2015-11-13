import java.io.File;
import java.util.ArrayList;

import edu.princeton.cs.introcs.In;

public class User {
	
	private int userId, age;
	private String firstName, surname, gender, occupation;
	
	public User(int userId, String firstName, String surname, int age, String gender, String occupation) throws Exception
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
		return this.userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	
	public int getAge()
	{
		return this.age;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public String getfirstName()
	{
		return this.firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getSurname()
	{
		return this.surname;
	}
	
	public void setSurname(String surname)
	{
		this.surname = surname;
	}
	
	public String getGender()
	{
		return this.gender;
	}
	
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	
	public String getOccupation()
	{
		return this.occupation;
	}
	
	public void setOccupation(String occupation)
	{
		this.occupation = occupation;
	}

}

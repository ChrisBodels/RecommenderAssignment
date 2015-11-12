import java.io.File;
import java.util.ArrayList;

import edu.princeton.cs.introcs.In;


public class Recommender 
{
	private ArrayList<Movie> movies;
	private ArrayList<User> users;
	private ArrayList<Rating> ratings;
	
	public static void main(String[] args) throws Exception
	{
		Recommender app = new Recommender();
		app.readInData();
	}
	
	public void readInData() throws Exception //HARD CODED STUFF HERE?
	{
		File usersFile = new File("Small_Data_Set/users5.dat");
		In inUsers = new In(usersFile);
		//each field is separated(delimited) by a '|'
		String delims = "[|]";
		while (!inUsers.isEmpty()) 
		{
			// get user and rating from data source
			String userDetails = inUsers.readLine();

			// parse user details string
			String[] userTokens = userDetails.split(delims);

			// output user data to console.
			if (userTokens.length == 7) 
			{
				System.out.println("UserID: "+userTokens[0]+",First Name:"+
            		 userTokens[1]+",Surname:" + userTokens[2]+",Age:"+
                     Integer.parseInt(userTokens[3])+",Gender:"+userTokens[4]+",Occupation:"+
                     userTokens[5]);
				//users.add(new User())
			}
			else
			{
				throw new Exception("Invalid member length: "+userTokens.length);
			}
		}
	}
	
	public void addUser(String firstName, String lastName, int age, String gender, String occupation)
	{
		
	}
	
	public void removeUser(int userID)
	{
		
	}
	
	public void addMovie(String title, int year, String url)
	{
		
	}
	
	public void addRating(int userID, int movieID, int rating)
	{
		
	}
	
	public Movie getMovie(int movieID)
	{
		return null; //FIX THIS 
	}
	
	public void getUserRatings(int userID) //NOT SURE ABOUT VOID HERE
	{
		
	}
	
	public void getUserRecommendations(int userID) //NOT SURE ABOUT VOID HERE
	{
		
	}
	
	public void getTopTenMovies() //NOT SURE ABOUT VOID HERE
	{
		
	}
	
	public void load()
	{
		
	}
	
	public void write()
	{
		
	}
}
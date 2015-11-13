import java.io.File;
import java.util.ArrayList;

import edu.princeton.cs.introcs.In;


public class Recommender 
{
	private ArrayList<Movie> movies;
	private ArrayList<User> users;
	private ArrayList<Rating> ratings;
	
	public Recommender()
	{
		users = new ArrayList<User>();
		movies = new ArrayList<Movie>();
		ratings = new ArrayList<Rating>();
	}
	
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
				users.add(new User(Integer.parseInt(userTokens[0]), userTokens[1], userTokens[2],
						Integer.parseInt(userTokens[3]), userTokens[4], userTokens[5]));
			}
			else
			{
				throw new Exception("Invalid member length: "+userTokens.length);
			}
		}
		File moviesFile = new File("Small_Data_Set/items5.dat");
		In inMovies = new In(moviesFile);
		while(!inMovies.isEmpty())
		{
			String movieDetails = inMovies.readLine();
			String[] movieTokens = movieDetails.split(delims);
			
			if(movieTokens.length == 23)
			{
				movies.add(new Movie(Integer.parseInt(movieTokens[0]), movieTokens[1],
						movieTokens[2], movieTokens[3], genreTranslator(Integer.parseInt(movieTokens[4])), 
						genreTranslator(Integer.parseInt(movieTokens[5])), genreTranslator(Integer.parseInt(movieTokens[6])), 
						genreTranslator(Integer.parseInt(movieTokens[7])), genreTranslator(Integer.parseInt(movieTokens[8])), 
						genreTranslator(Integer.parseInt(movieTokens[9])), genreTranslator(Integer.parseInt(movieTokens[10])), 
						genreTranslator(Integer.parseInt(movieTokens[11])), genreTranslator(Integer.parseInt(movieTokens[12])), 
						genreTranslator(Integer.parseInt(movieTokens[13])), genreTranslator(Integer.parseInt(movieTokens[14])), 
						genreTranslator(Integer.parseInt(movieTokens[15])), genreTranslator(Integer.parseInt(movieTokens[16])), 
						genreTranslator(Integer.parseInt(movieTokens[17])), genreTranslator(Integer.parseInt(movieTokens[18])), 
						genreTranslator(Integer.parseInt(movieTokens[19])), genreTranslator(Integer.parseInt(movieTokens[20])), 
						genreTranslator(Integer.parseInt(movieTokens[21])), genreTranslator(Integer.parseInt(movieTokens[22]))));
			}
			else
			{
				throw new Exception("Invalid movie length: "+movieTokens.length);
			}
		}
		System.out.println(movies.get(5).getTitle());
		File ratingsFile = new File("Small_Data_Set/ratings5.dat");
		In inRatings = new In(ratingsFile);
		while(!inRatings.isEmpty())
		{
			String ratingsDetails = inRatings.readLine();
			String[] ratingsTokens = ratingsDetails.split(delims);
			if(ratingsTokens.length == 4)
			{
				ratings.add(new Rating(Integer.parseInt(ratingsTokens[0]),
						Integer.parseInt(ratingsTokens[1]), Integer.parseInt(ratingsTokens[2])));
			}
			else
			{
				throw new Exception("Invalid ratings length: "+ratingsTokens.length);
			}
		}
		System.out.println(ratings.get(49).getMovieId());
	}
	
	public void addUser(String firstName, String lastName, int age, String gender, String occupation) throws Exception
	{
		users.add(new User(users.size(), firstName, lastName, age, gender, occupation));
	}
	
	public void removeUser(int userId)
	{
		users.remove(userId - 1);
	}
	
	/*public void addMovie(String title, String longDate, String url)
	{
		movies.add(new Movie(movies.size(), title, longDate, url));
	}*/
	
	public void addRating(int userId, int movieId, int rating)
	{
		ratings.add(new Rating(userId, movieId, rating));
	}
	
	public Movie getMovie(int movieId)
	{
		Movie movie = movies.get(movieId - 1);
		return movie;
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
	
	public boolean genreTranslator(int input)
	{
		if(input == 1)
			return true;
		else
			return false;
	}
}
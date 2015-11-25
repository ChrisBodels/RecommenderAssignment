import java.io.File;
import java.util.Collections;
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
		//app.load(); MAKE SURE TO FIX THIS
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
		System.out.println(movies.get(1).getGenre());
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
		System.out.println(getMovieDetails(9));
		System.out.println(getUserRatings(1));
		addTotalMovieRatings();
		for(int i = 0; i < movies.size(); i++)
		{
			System.out.println("Total rating: " + movies.get(i).getTotalRating() + ". Movie: " + movies.get(i).getTitle() + ". Movie ID: " + movies.get(i).getMovieId());
		}
		System.out.println("");
		
		getTopTenMovies();
		
		System.out.println("");
		
		for(int i = 0; i < movies.size(); i++)
		{
			System.out.println("Total rating: " + movies.get(i).getTotalRating() + ". Movie: " + movies.get(i).getTitle() + ". Movie ID: " + movies.get(i).getMovieId());
		}
	}
	
	public void setUserScores() //can probably move this to User class in order to make it not quadratic using the userRatings arraylist
	{
		int unknownScore, actionScore, adventureScore, animationScore, childrensScore, comedyScore, 
		crimeScore, documentaryScore, dramaScore, fantasyScore, filmNoirScore, horrorScore, musicalScore, mysteryScore,
		romanceScore, sciFiScore, thrillerScore, warScore, westernScore;
		for(int i = 0; i < users.size(); i++)
		{
			unknownScore = 0;
			actionScore = 0;
			adventureScore = 0;
			animationScore = 0;
			childrensScore = 0;
			comedyScore = 0;
			crimeScore = 0;
			documentaryScore = 0;
			dramaScore = 0;
			fantasyScore = 0;
			filmNoirScore = 0;
			horrorScore = 0;
			musicalScore = 0;
			mysteryScore = 0;
			romanceScore = 0;
			sciFiScore = 0;
			thrillerScore = 0;
			warScore = 0;
			westernScore = 0;
			
			for(int n = 0; n < ratings.size(); n++)
			{
				if(ratings.get(n).getUserId() == users.get(i).getUserId())
				{
					int currentMovieId = ratings.get(n).getMovieId() -1;
					if(movies.get(currentMovieId).getUnknown())
					{
						unknownScore += ratings.get(n).getRating();
					}
					if(movies.get(currentMovieId).getAction())
					{
						actionScore += ratings.get(n).getRating();
					}
					if(movies.get(currentMovieId).getAdventure())
					{
						adventureScore += ratings.get(n).getRating();
					}
					if(movies.get(currentMovieId).getAnimation())
					{
						animationScore += ratings.get(n).getRating();
					}
					if(movies.get(currentMovieId).getChildrens())
					{
						childrensScore += ratings.get(n).getRating();
					}
					if(movies.get(currentMovieId).getComedy())
					{
						comedyScore += ratings.get(n).getRating();
					}
					if(movies.get(currentMovieId).getCrime())
					{
						crimeScore += ratings.get(n).getRating();
					}
					if(movies.get(currentMovieId).getDocumentary())
					{
						documentaryScore += ratings.get(n).getRating();
					}
					if(movies.get(currentMovieId).getDrama())
					{
						dramaScore += ratings.get(n).getRating();
					}
					if(movies.get(currentMovieId).getFantasy())
					{
						fantasyScore += ratings.get(n).getRating();
					}
					if(movies.get(currentMovieId).getFilmNoir())
					{
						filmNoirScore += ratings.get(n).getRating();
					}
					if(movies.get(currentMovieId).getHorror())
					{
						horrorScore += ratings.get(n).getRating();
					}
					if(movies.get(currentMovieId).getMusical())
					{
						musicalScore += ratings.get(n).getRating();
					}
					if(movies.get(currentMovieId).getMystery())
					{
						mysteryScore += ratings.get(n).getRating();
					}
					if(movies.get(currentMovieId).getRomance())
					{
						romanceScore += ratings.get(n).getRating();
					}
					if(movies.get(currentMovieId).getSciFi())
					{
						sciFiScore += ratings.get(n).getRating();
					}
					if(movies.get(currentMovieId).getThriller())
					{
						thrillerScore += ratings.get(n).getRating();
					}
					if(movies.get(currentMovieId).getWar())
					{
						warScore += ratings.get(n).getRating();
					}
					if(movies.get(currentMovieId).getWestern())
					{
						westernScore += ratings.get(n).getRating();
					}
				}
			}
			users.get(i).setScores(unknownScore, actionScore, adventureScore, animationScore,
					childrensScore, comedyScore, crimeScore, documentaryScore, dramaScore, fantasyScore,
					filmNoirScore, horrorScore, musicalScore, mysteryScore, romanceScore, sciFiScore, thrillerScore,
					warScore, westernScore);
		}
	}
	
	public void setUsersRatings()  //Not efficient, try to fix
	{
		ArrayList<Rating> userRatings = new ArrayList<Rating>();
		for(int i = 0; i < users.size(); i++)
		{
			userRatings.clear();
			for(int n = 0; n < ratings.size(); n++)
			{
				if(ratings.get(n).getUserId() == users.get(i).getUserId())
					userRatings.add(ratings.get(n));
			}
			users.get(i).importUserRatings(userRatings);
		}
		setUserScores();
	}
	
	public void getUserRecommendations(int userId)
	{
		for(int i = 0; i < users.size(); i++)
		{
			
		}
	}
	
	public void addUser(String firstName, String lastName, int age, String gender, String occupation) throws Exception
	{
		users.add(new User(users.size(), firstName, lastName, age, gender, occupation));
	}
	
	public void removeUser(int userId)
	{
		users.remove(userId - 1);
	}
	
	public void addMovie(String title, String longDate, String url, boolean unkown, boolean action, boolean adventure,
			boolean animation, boolean childrens, boolean comedy, boolean crime, boolean documentary, boolean drama, 
			boolean fantasy, boolean filmNoir, boolean horror, boolean musical, boolean mystery, boolean romance, 
			boolean sciFi, boolean thriller, boolean war, boolean western)
	{
		movies.add(new Movie(movies.size(), title, longDate, url, unkown, action, adventure, animation, childrens,
				comedy, crime, documentary, fantasy, filmNoir, horror, musical, mystery, romance, drama, sciFi,
				thriller, war, western));
	}
	
	public void removeMovie(int movieId)
	{
		movies.remove(movieId - 1);
	}
	
	public String getMovieDetails(int movieId)
	{
		return movies.get(movieId).toString();
	}
	
	public void addRating(int userId, int movieId, int rating)
	{
		ratings.add(new Rating(userId, movieId, rating));
	}
	
	public Movie getMovie(int movieId)
	{
		Movie movie = movies.get(movieId - 1);
		return movie;
	}
	
	public String getUserRatings(int userId) 
	{
		setUsersRatings(); //take this out at some point
		ArrayList<Rating> userRatings = new ArrayList<Rating>();
		userRatings = users.get(userId - 1).getUserRatings();
		String usersRatings = "";
		for(int i = 0; i < userRatings.size(); i++)
		{
			usersRatings += "Movie: " + movies.get(userRatings.get(i).getMovieId()-1).getTitle() + ". Rating: " + userRatings.get(i).getRating() + ". \n";
		}
		if(usersRatings == "")
			return "No ratings for this user ID, go rate some movies!";
		else
			return usersRatings;
	}
	
	public void load() throws Exception
	{
		users = HandleXML.readUsers();
		movies = HandleXML.readMovies();
		ratings = HandleXML.readRatings();
		if(users.isEmpty() && movies.isEmpty() && ratings.isEmpty())
		{
			readInData();
		}
		setUsersRatings();
	}
	
	public void write() throws Exception
	{
		HandleXML.writeUsers(users);
		HandleXML.writeMovies(movies);
		HandleXML.writeRatings(ratings);
	}
	
	public void addTotalMovieRatings()
	{
		double rating;
		double numOfRatings;
		for(int i = 0; i < movies.size(); i++)
		{
			numOfRatings = 0;
			rating = 0;
			for(int n = 0; n < ratings.size(); n++)
			{
				if(ratings.get(n).getMovieId() == movies.get(i).getMovieId())
				{
					rating += ratings.get(n).getRating();
					numOfRatings++;
				}
			}
			movies.get(i).setTotalRating(rating/numOfRatings);
		}
	}
	
	public void getTopTenMovies()
	{
		Collections.sort(movies);
		for(int i = 0; i < movies.size(); i++)
		{
			System.out.println("Total rating: " + movies.get(i).getTotalRating() + ". Movie: " + movies.get(i).getTitle());
		}
	}
	
	public boolean genreTranslator(int input)
	{
		if(input == 1)
			return true;
		else
			return false;
	}
}
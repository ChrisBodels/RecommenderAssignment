import java.io.File;
import java.util.Collections;
import java.util.ArrayList;
import edu.princeton.cs.introcs.In;


public class Recommender 
{
	private ArrayList<Movie> movies;
	private ArrayList<User> users;
	private ArrayList<Rating> ratings;
	
	public Recommender() throws Exception
	{
		users = new ArrayList<User>();
		movies = new ArrayList<Movie>();
		ratings = new ArrayList<Rating>();
	}
	
	
	public ArrayList<User> getUsers()
	{
		return users;
	}
	
	public User getUser(int userId)
	{
		User user = users.get(userId - 1);
		return user;
	}
	
	public void readInData() throws Exception
	{
		File usersFile = new File("data_movieLens/users.dat");
		In inUsers = new In(usersFile);
		String delims = "[|]";
		while (!inUsers.isEmpty()) 
		{
			String userDetails = inUsers.readLine();

			String[] userTokens = userDetails.split(delims);

			if (userTokens.length == 7) 
			{
				users.add(new User(Integer.parseInt(userTokens[0]), userTokens[1], userTokens[2],
						Integer.parseInt(userTokens[3]), userTokens[4], userTokens[5]));
			}
			else
			{
				throw new Exception("Invalid member length: "+userTokens.length);
			}
		}
		File moviesFile = new File("data_movieLens/items.dat");
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
		File ratingsFile = new File("data_movieLens/ratings.dat");
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
		addTotalMovieRatings();
		setUsersRatings();
	}
	
	public void setUsersRatings()
	{
		int unknownScore, actionScore, adventureScore, animationScore, childrensScore, comedyScore, 
		crimeScore, documentaryScore, dramaScore, fantasyScore, filmNoirScore, horrorScore, musicalScore, mysteryScore,
		romanceScore, sciFiScore, thrillerScore, warScore, westernScore, unknownCount, actionCount, adventureCount, 
		animationCount, childrensCount, comedyCount, crimeCount, documentaryCount, dramaCount, fantasyCount, 
		filmNoirCount, horrorCount, musicalCount, mysteryCount, romanceCount, sciFiCount, thrillerCount, 
		warCount, westernCount;
		ArrayList<Rating> userRatings = new ArrayList<Rating>();
		for(int i = 0; i < users.size(); i++)
		{
			unknownCount = 0;
			actionCount = 0;
			adventureCount = 0;
			animationCount = 0;
			childrensCount = 0;
			comedyCount = 0;
			crimeCount = 0;
			documentaryCount = 0;
			dramaCount = 0;
			fantasyCount = 0;
			filmNoirCount = 0;
			horrorCount = 0;
			musicalCount = 0;
			mysteryCount = 0;
			romanceCount = 0;
			sciFiCount = 0;
			thrillerCount = 0;
			warCount = 0;
			westernCount = 0;
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
			userRatings.clear();
			for(int n = 0; n < ratings.size(); n++)
			{
				if(ratings.get(n).getUserId() == users.get(i).getUserId())
				{
					int currentMovieId = ratings.get(n).getMovieId() -1;
					if(movies.get(currentMovieId).getUnknown())
					{
						unknownScore += ratings.get(n).getRating();
						unknownCount++;
					}
					if(movies.get(currentMovieId).getAction())
					{
						actionScore += ratings.get(n).getRating();
						actionCount++;
					}
					if(movies.get(currentMovieId).getAdventure())
					{
						adventureScore += ratings.get(n).getRating();
						adventureCount++;
					}
					if(movies.get(currentMovieId).getAnimation())
					{
						animationScore += ratings.get(n).getRating();
						animationCount++;
					}
					if(movies.get(currentMovieId).getChildrens())
					{
						childrensScore += ratings.get(n).getRating();
						childrensCount++;
					}
					if(movies.get(currentMovieId).getComedy())
					{
						comedyScore += ratings.get(n).getRating();
						comedyCount++;
					}
					if(movies.get(currentMovieId).getCrime())
					{
						crimeScore += ratings.get(n).getRating();
						crimeCount++;
					}
					if(movies.get(currentMovieId).getDocumentary())
					{
						documentaryScore += ratings.get(n).getRating();
						documentaryCount++;
					}
					if(movies.get(currentMovieId).getDrama())
					{
						dramaScore += ratings.get(n).getRating();
						dramaCount++;
					}
					if(movies.get(currentMovieId).getFantasy())
					{
						fantasyScore += ratings.get(n).getRating();
						fantasyCount++;
					}
					if(movies.get(currentMovieId).getFilmNoir())
					{
						filmNoirScore += ratings.get(n).getRating();
						filmNoirCount++;
					}
					if(movies.get(currentMovieId).getHorror())
					{
						horrorScore += ratings.get(n).getRating();
						horrorCount++;
					}
					if(movies.get(currentMovieId).getMusical())
					{
						musicalScore += ratings.get(n).getRating();
						musicalCount++;
					}
					if(movies.get(currentMovieId).getMystery())
					{
						mysteryScore += ratings.get(n).getRating();
						mysteryCount++;
					}
					if(movies.get(currentMovieId).getRomance())
					{
						romanceScore += ratings.get(n).getRating();
						romanceCount++;
					}
					if(movies.get(currentMovieId).getSciFi())
					{
						sciFiScore += ratings.get(n).getRating();
						sciFiCount++;
					}
					if(movies.get(currentMovieId).getThriller())
					{
						thrillerScore += ratings.get(n).getRating();
						thrillerCount++;
					}
					if(movies.get(currentMovieId).getWar())
					{
						warScore += ratings.get(n).getRating();
						warCount++;
					}
					if(movies.get(currentMovieId).getWestern())
					{
						westernScore += ratings.get(n).getRating();
						westernCount++;
					}
					userRatings.add(ratings.get(n));
				}
			}
			users.get(i).importUserRatings(userRatings);
			users.get(i).setScores(unknownScore/zeroAvoider(unknownCount), actionScore/zeroAvoider(actionCount), 
					adventureScore/zeroAvoider(adventureCount), animationScore/zeroAvoider(animationCount),
					childrensScore/zeroAvoider(childrensCount), comedyScore/zeroAvoider(comedyCount), 
					crimeScore/zeroAvoider(crimeCount), documentaryScore/zeroAvoider(documentaryCount), 
					dramaScore/zeroAvoider(dramaCount), fantasyScore/zeroAvoider(fantasyCount),
					filmNoirScore/zeroAvoider(filmNoirCount), horrorScore/zeroAvoider(horrorCount), 
					musicalScore/zeroAvoider(musicalCount), mysteryScore/zeroAvoider(mysteryCount), 
					romanceScore/zeroAvoider(romanceCount), sciFiScore/zeroAvoider(sciFiCount), thrillerScore/zeroAvoider(thrillerCount),
					warScore/zeroAvoider(warCount), westernScore/zeroAvoider(westernCount));
		}
	}
	
	public void getUserRecommendations(int userId)
	{
		User recommendee = users.get((userId-1));
		if(recommendee.getUserRatings().size() > 9) // only recommends movies based on other users if the user has rated at least 10 movies
		{
			String genre = recommendee.getTopGenre();
			int count = 0;
				if(genre == "unknown")
				{
					for(int i = 0; i < users.size(); i++)
					{
						for(int n = 0; n < users.get(i).getUserRatings().size(); n++)
						{
							if(users.get(i).getUserRatings().get(n).getRating() > 3 && movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getUnknown())
							{
								System.out.println("Recommendation " + (count +1) + ": " + movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getTitle());
								count++;
							}
						}
					}
				}
				if(genre == "action")
				{
					for(int i = 0; i < users.size(); i++)
					{
						for(int n = 0; n < users.get(i).getUserRatings().size(); n++)
						{
							if(users.get(i).getUserRatings().get(n).getRating() > 3 && movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getAction())
							{
								System.out.println("Recommendation " + (count +1) + ": " + movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getTitle());
								count++;
							}
						}
					}
				}
				if(genre == "adventure")
				{
					for(int i = 0; i < users.size(); i++)
					{
						for(int n = 0; n < users.get(i).getUserRatings().size(); n++)
						{
							if(users.get(i).getUserRatings().get(n).getRating() > 3 && movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getAdventure())
							{
								System.out.println("Recommendation " + (count +1) + ": " + movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getTitle());
								count++;
							}
						}
					}
				}
				if(genre == "animation")
				{
					for(int i = 0; i < users.size(); i++)
					{
						for(int n = 0; n < users.get(i).getUserRatings().size(); n++)
						{
							if(users.get(i).getUserRatings().get(n).getRating() > 3 && movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getAnimation())
							{
								System.out.println("Recommendation " + (count +1) + ": " + movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getTitle());
								count++;
							}
						}
					}
				}
				if(genre == "childrens")
				{
					for(int i = 0; i < users.size(); i++)
					{
						for(int n = 0; n < users.get(i).getUserRatings().size(); n++)
						{
							if(users.get(i).getUserRatings().get(n).getRating() > 3 && movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getChildrens())
							{
								System.out.println("Recommendation " + (count +1) + ": " + movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getTitle());
								count++;
							}
						}
					}
				}
				if(genre == "comedy")
				{
					for(int i = 0; i < users.size(); i++)
					{
						for(int n = 0; n < users.get(i).getUserRatings().size(); n++)
						{
							if(users.get(i).getUserRatings().get(n).getRating() > 3 && movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getComedy())
							{
								System.out.println("Recommendation " + (count +1) + ": " + movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getTitle());
								count++;
							}
						}
					}
				}
				if(genre == "crime")
				{
					for(int i = 0; i < users.size(); i++)
					{
						for(int n = 0; n < users.get(i).getUserRatings().size(); n++)
						{
							if(users.get(i).getUserRatings().get(n).getRating() > 3 && movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getCrime())
							{
								System.out.println("Recommendation " + (count +1) + ": " + movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getTitle());
								count++;
							}
						}
					}
				}
				if(genre == "documentary")
				{
					for(int i = 0; i < users.size(); i++)
					{
						for(int n = 0; n < users.get(i).getUserRatings().size(); n++)
						{
							if(users.get(i).getUserRatings().get(n).getRating() > 3 && movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getDocumentary())
							{
								System.out.println("Recommendation " + (count +1) + ": " + movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getTitle());
								count++;
							}
						}
					}
				}
				if(genre == "drama")
				{
					for(int i = 0; i < users.size(); i++)
					{
						for(int n = 0; n < users.get(i).getUserRatings().size(); n++)
						{
							if(users.get(i).getUserRatings().get(n).getRating() > 3 && movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getDrama())
							{
								System.out.println("Recommendation " + (count +1) + ": " + movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getTitle());
								count++;
							}
						}
					}
				}
				if(genre == "fantasy")
				{
					for(int i = 0; i < users.size(); i++)
					{
						for(int n = 0; n < users.get(i).getUserRatings().size(); n++)
						{
							if(users.get(i).getUserRatings().get(n).getRating() > 3 && movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getFantasy())
							{
								System.out.println("Recommendation " + (count +1) + ": " + movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getTitle());
								count++;
							}
						}
					}
				}
				if(genre == "filmNoir")
				{
					for(int i = 0; i < users.size(); i++)
					{
						for(int n = 0; n < users.get(i).getUserRatings().size(); n++)
						{
							if(users.get(i).getUserRatings().get(n).getRating() > 3 && movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getFilmNoir())
							{
								System.out.println("Recommendation " + (count +1) + ": " + movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getTitle());
								count++;
							}
						}
					}
				}
				if(genre == "horror")
				{
					for(int i = 0; i < users.size(); i++)
					{
						for(int n = 0; n < users.get(i).getUserRatings().size(); n++)
						{
							if(users.get(i).getUserRatings().get(n).getRating() > 3 && movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getHorror())
							{
								System.out.println("Recommendation " + (count +1) + ": " + movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getTitle());
								count++;
							}
						}
					}
				}
				if(genre == "musical")
				{
					for(int i = 0; i < users.size(); i++)
					{
						for(int n = 0; n < users.get(i).getUserRatings().size(); n++)
						{
							if(users.get(i).getUserRatings().get(n).getRating() > 3 && movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getMusical())
							{
								System.out.println("Recommendation " + (count +1) + ": " + movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getTitle());
								count++;
							}
						}
					}
				}
				if(genre == "mystery")
				{
					for(int i = 0; i < users.size(); i++)
					{
						for(int n = 0; n < users.get(i).getUserRatings().size(); n++)
						{
							if(users.get(i).getUserRatings().get(n).getRating() > 3 && movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getMystery())
							{
								System.out.println("Recommendation " + (count +1) + ": " + movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getTitle());
								count++;
							}
						}
					}
				}
				if(genre == "romance")
				{
					for(int i = 0; i < users.size(); i++)
					{
						for(int n = 0; n < users.get(i).getUserRatings().size(); n++)
						{
							if(users.get(i).getUserRatings().get(n).getRating() > 3 && movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getRomance())
							{
								System.out.println("Recommendation " + (count +1) + ": " + movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getTitle());
								count++;
							}
						}
					}
				}
				if(genre == "sciFi")
				{
					for(int i = 0; i < users.size(); i++)
					{
						for(int n = 0; n < users.get(i).getUserRatings().size(); n++)
						{
							if(users.get(i).getUserRatings().get(n).getRating() > 3 && movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getSciFi())
							{
								System.out.println("Recommendation " + (count +1) + ": " + movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getTitle());
								count++;
							}
						}
					}
				}
				if(genre == "thriller")
				{
					for(int i = 0; i < users.size(); i++)
					{
						for(int n = 0; n < users.get(i).getUserRatings().size(); n++)
						{
							if(users.get(i).getUserRatings().get(n).getRating() > 3 && movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getThriller())
							{
								System.out.println("Recommendation " + (count +1) + ": " + movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getTitle());
								count++;
							}
						}
					}
				}
				if(genre == "war")
				{
					for(int i = 0; i < users.size(); i++)
					{
						for(int n = 0; n < users.get(i).getUserRatings().size(); n++)
						{
							if(users.get(i).getUserRatings().get(n).getRating() > 3 && movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getWar())
							{
								System.out.println("Recommendation " + (count+1) + ": " + movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getTitle());
								count++;
							}
						}
					}
				}
				if(genre == "western")
				{
					for(int i = 0; i < users.size(); i++)
					{
						for(int n = 0; n < users.get(i).getUserRatings().size(); n++)
						{
							if(users.get(i).getUserRatings().get(n).getRating() > 3 && movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getWestern())
							{
								System.out.println("Recommendation " + (count +1) + ": " + movies.get(users.get(i).getUserRatings().get(n).getMovieId()).getTitle());
								count++;
							}
						}
					}
				}
			}
		else
		{
			System.out.println("We see that yo have not rated many movies yet, until you do here is the top ten movies by users' ratings: ");
			getTopTenMovies();
		}
	}
	
	public void addUser(String firstName, String lastName, int age, String gender, String occupation) throws Exception
	{
		users.add(new User(users.size() + 1, firstName, lastName, age, gender, occupation));
	}
	
	public void removeUser(int userId)
	{
		users.remove(userId - 1);
	}
	
	public void addMovie(String title, String longDate, String url, boolean unknown, boolean action, boolean adventure,
			boolean animation, boolean childrens, boolean comedy, boolean crime, boolean documentary, boolean drama, 
			boolean fantasy, boolean filmNoir, boolean horror, boolean musical, boolean mystery, boolean romance, 
			boolean sciFi, boolean thriller, boolean war, boolean western)
	{
		movies.add(new Movie(movies.size(), title, longDate, url, unknown, action, adventure, animation, childrens,
				comedy, crime, documentary, drama, fantasy, filmNoir, horror, musical, mystery, romance, sciFi,
				thriller, war, western));
	}
	
	public void removeMovie(int movieId)
	{
		movies.remove(movieId - 1);
	}
	
	public String getMovieDetails(int movieId)
	{
		if(movieId > 0 && movieId <= movies.size())
		{
			return movies.get(movieId -1).toString();
		}
		else
		{
			return "Invalid movie ID entered. Please enter a valid movie ID.";
		}
	}
	
	public void addRating(int userId, int movieId, int rating)
	{
		if(rating > 0 && rating < 6)
		{
			ratings.add(new Rating(userId, movieId, rating));
		}
		else
		{
			System.out.println("Invalid rating entered. Please enter a rating from 1-5.");
		}
	}
	
	public Movie getMovie(int movieId)
	{
		Movie movie = movies.get(movieId - 1);
		return movie;
	}
	
	public String getUserRatings(int userId) 
	{
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
		setUsersRatings();
		addTotalMovieRatings();
	}
	
	public void save() throws Exception
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
		for(int i = 0; i < 10; i++)
		{
			System.out.println("Total rating: " + movies.get(i).getTotalRating() + ". Movie: " + movies.get(i).getTitle());
		}
	}
	
	public String getAllMovies()
	{
		String moviesString = "";
		for(int i = 0; i < movies.size(); i++)
		{
			moviesString += "Movie ID: " + movies.get(i).getMovieId() + ". " + movies.get(i).toString() + "\n ";
		}
		return moviesString;
	}
	
	public boolean genreTranslator(int input)
	{
		if(input == 1)
			return true;
		else
			return false;
	}
	
	private int zeroAvoider(int num)
	{
		if(num == 0)
		{
			return 1;
		}
		else
		{
			return num;
		}
	}
}
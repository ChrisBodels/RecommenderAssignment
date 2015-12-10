import java.io.File;
import java.util.Collections;
import java.util.ArrayList;
import edu.princeton.cs.introcs.In;

/**
 * 
 * @author Chris Bodels
 *
 */
public class Recommender 
{
	private ArrayList<Movie> movies;
	private ArrayList<User> users;
	private ArrayList<Rating> ratings;
	
	/**
	 * Constructor for objects of type recommender
	 * 
	 * @throws Exception
	 */
	public Recommender() throws Exception
	{
		users = new ArrayList<User>();
		movies = new ArrayList<Movie>();
		ratings = new ArrayList<Rating>();
	}
	
	/**
	 * Returns the ArrayList that contains all the users
	 * 
	 * @return The ArrayList that contains all the users
	 */
	public ArrayList<User> getUsers()
	{
		return users;
	}
	
	/**
	 * Returns a specific user based on their user ID
	 * 
	 * @param userId The user ID of the user to be returned
	 * @return The specified user
	 */
	public User getUser(int userId)
	{
		User user = users.get(userId - 1);
		return user;
	}
	
	/**
	 * This method reads in the data about the users, movies and ratings from the specified files
	 * 
	 * @throws Exception
	 */
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
	
	/**
	 * This method sets the ratings and scores for each user by going through the ratings and users ArrayLists
	 */
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
	
	/**
	 * This method recommends movies to a user specified by their user ID by checking what their favourite genre is based on previous ratings
	 * and recommends to them highly rated movies in that genre
	 * 
	 * @param userId The user ID of the user that is getting recommendations
	 */
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
	
	/**
	 * Creates and adds a new user to the users ArrayList
	 * 
	 * @param firstName The new user's first name
	 * @param lastName The new user's last name
	 * @param age The new user's age
	 * @param gender The new users's gender
	 * @param occupation The new user's occupation 
	 * @throws Exception
	 */
	public void addUser(String firstName, String lastName, int age, String gender, String occupation) throws Exception
	{
		users.add(new User(users.size() + 1, firstName, lastName, age, gender, occupation));
	}
	
	/**
	 * Deletes a user from the ArrayList of users
	 * 
	 * @param userId The user ID of the user that is to be deleted
	 */
	public void removeUser(int userId)
	{
		users.remove(userId - 1);
	}
	
	/**
	 * Creates and adds a movie to the movies ArrayList
	 * 
	 * @param title The title of the movie
	 * @param longDate The date the movie was released in String format
	 * @param url The url for the imdb page of the movie
	 * @param unknown A boolean which sets whether the movie is in the unknown genre or not
	 * @param action A boolean which sets whether the movie is in the action genre or not
	 * @param adventure A boolean which sets whether the movie is in the adventure genre or not
	 * @param animation A boolean which sets whether the movie is in the animation genre or not
	 * @param childrens A boolean which sets whether the movie is in the children's genre or not
	 * @param comedy A boolean which sets whether the movie is in the comedy genre or not
	 * @param crime A boolean which sets whether the movie is in the crime genre or not
	 * @param documentary A boolean which sets whether the movie is in the documentary genre or not
	 * @param drama A boolean which sets whether the movie is in the drama genre or not
	 * @param fantasy A boolean which sets whether the movie is in the fantasy genre or not
	 * @param filmNoir A boolean which sets whether the movie is in the film noir genre or not
	 * @param horror A boolean which sets whether the movie is in the horror genre or not
	 * @param musical A boolean which sets whether the movie is in the musical genre or not
	 * @param mystery A boolean which sets whether the movie is in the mystery genre or not
	 * @param romance A boolean which sets whether the movie is in the romance genre or not
	 * @param sciFi A boolean which sets whether the movie is in the Sci-Fi genre or not
	 * @param thriller A boolean which sets whether the movie is in the thriller genre or not
	 * @param war A boolean which sets whether the movie is in the war genre or not
	 * @param western A boolean which sets whether the movie is in the western genre or not
	 */
	public void addMovie(String title, String longDate, String url, boolean unknown, boolean action, boolean adventure,
			boolean animation, boolean childrens, boolean comedy, boolean crime, boolean documentary, boolean drama, 
			boolean fantasy, boolean filmNoir, boolean horror, boolean musical, boolean mystery, boolean romance, 
			boolean sciFi, boolean thriller, boolean war, boolean western)
	{
		movies.add(new Movie(movies.size(), title, longDate, url, unknown, action, adventure, animation, childrens,
				comedy, crime, documentary, drama, fantasy, filmNoir, horror, musical, mystery, romance, sciFi,
				thriller, war, western));
	}
	
	/**
	 * Deletes a movie from the movies ArrayList
	 * 
	 * @param movieId The movie ID of the movie that is to be deleted
	 */
	public void removeMovie(int movieId)
	{
		movies.remove(movieId - 1);
	}
	
	/**
	 * Gets the details of a specified movie
	 * 
	 * @param movieId The movie ID of the movie that the details are to be gotten
	 * @return The toString of the specified movie
	 */
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
	
	/**
	 * Creates and adds a rating to the ratings ArrayList
	 * 
	 * @param userId The user ID of the user who made the rating
	 * @param movieId The movie ID of the movie that is being rated
	 * @param rating The rating itself
	 */
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
	
	/**
	 * Returns a movie object based on a specific movie ID
	 * 
	 * @param movieId The movie ID of the movie to be returned
	 * @return
	 */
	public Movie getMovie(int movieId)
	{
		Movie movie = movies.get(movieId - 1);
		return movie;
	}
	
	/**
	 * Returns a String of a specific user's ratings
	 * 
	 * @param userId The user ID of the user whose ratings are to be checked
	 * @return The ratings of the specific user
	 */
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

	/**
	 * This method loads the data from saved xml files
	 * 
	 * @throws Exception
	 */
	public void load() throws Exception
	{
		users = HandleXML.readUsers();
		movies = HandleXML.readMovies();
		ratings = HandleXML.readRatings();
		setUsersRatings();
		addTotalMovieRatings();
	}
	
	/**
	 * This method saves the data to xml files
	 * 
	 * @throws Exception
	 */
	public void save() throws Exception
	{
		HandleXML.writeUsers(users);
		HandleXML.writeMovies(movies);
		HandleXML.writeRatings(ratings);
	}
	
	/**
	 * This method calculates the average rating for a movie, taking into account all ratings for the movie
	 */
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
	
	/**
	 * This method prints to the screen the top ten highest rated movies in the database
	 */
	public void getTopTenMovies()
	{
		Collections.sort(movies);
		for(int i = 0; i < 10; i++)
		{
			System.out.println("Total rating: " + movies.get(i).getTotalRating() + ". Movie: " + movies.get(i).getTitle());
		}
	}
	
	/**
	 * This method returns a String with all the movies' toString information
	 * 
	 * @return The toString of all movies in the movies arrayList
	 */
	public String getAllMovies()
	{
		String moviesString = "";
		for(int i = 0; i < movies.size(); i++)
		{
			moviesString += "Movie ID: " + movies.get(i).getMovieId() + ". " + movies.get(i).toString() + "\n ";
		}
		return moviesString;
	}
	
	/**
	 * This method is used when reading in the movies data to convert the binary genre information to boolean
	 * 
	 * @param input The binary input
	 * @return The boolean output
	 */
	private boolean genreTranslator(int input)
	{
		if(input == 1)
			return true;
		else
			return false;
	}
	
	/**
	 * This method is used to avoid division by zero errors in the setUserRatings method
	 * 
	 * @param num The number to be checked
	 * @return The number or 1 if the number was 0
	 */
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
import java.util.ArrayList;

/**
 * 
 * @author Chris Bodels
 *
 */
public class User {
	
	private int userId, age;
	private double unknownScore, actionScore, adventureScore, animationScore, childrensScore, comedyScore, 
	crimeScore, documentaryScore, dramaScore, fantasyScore, filmNoirScore, horrorScore, musicalScore, mysteryScore,
	romanceScore, sciFiScore, thrillerScore, warScore, westernScore;
	private String firstName, surname, gender, occupation;
	private ArrayList<Rating> ratings;
	
	/**
	 * The constructor for objects of type User. Takes in user id and a number of details about the user
	 * 
	 * @param userId An int used to identify the user
	 * @param firstName The user's first name
	 * @param surname The user's surname
	 * @param age The user's age
	 * @param gender The user's gender
	 * @param occupation The user's occupation
	 * @throws Exception
	 */
	public User(int userId, String firstName, String surname, int age, String gender, String occupation) throws Exception
	{
		this.userId = userId;
		this.age = age;
		this.firstName = firstName;
		this.surname = surname;
		this.gender = gender;
		this.occupation = occupation;
		ratings = new ArrayList<Rating>();
	}
	
	/**
	 * This method sets the users "score" for each genre which means that if they rated a movie of a certain genre highly then the "score" for that
	 * genre will go up. These scores are used for recommending movies based on genres they like.
	 * 
	 * @param unknownScore An double which shows how the user tends to like movies in the unknown genre
	 * @param actionScore An double which shows how the user tends to like movies in the action genre
	 * @param adventureScore An double which shows how the user tends to like movies in the adventure genre
	 * @param animationScore An double which shows how the user tends to like movies in the animation genre
	 * @param childrensScore An double which shows how the user tends to like movies in the children's genre
	 * @param comedyScore An double which shows how the user tends to like movies in the comedy genre
	 * @param crimeScore An double which shows how the user tends to like movies in the crime genre
	 * @param documentaryScore An double which shows how the user tends to like movies in the documentary genre
	 * @param dramaScore An double which shows how the user tends to like movies in the drama genre
	 * @param fantasyScore An double which shows how the user tends to like movies in the fantasy genre
	 * @param filmNoirScore An double which shows how the user tends to like movies in the film-noir genre
	 * @param horrorScore An double which shows how the user tends to like movies in the horror genre
	 * @param musicalScore An double which shows how the user tends to like movies in the musical genre
	 * @param mysteryScore An double which shows how the user tends to like movies in the mystery genre
	 * @param romanceScore An double which shows how the user tends to like movies in the romance genre
	 * @param sciFiScore An double which shows how the user tends to like movies in the sci-fi genre
	 * @param thrillerScore An double which shows how the user tends to like movies in the thriller genre
	 * @param warScore An double which shows how the user tends to like movies in the war genre
	 * @param westernScore An double which shows how the user tends to like movies in the western genre
	 */
	public void setScores(double unknownScore,double actionScore,double adventureScore,double animationScore,double childrensScore,double comedyScore, 
			double crimeScore,double documentaryScore,double dramaScore,double fantasyScore,double filmNoirScore,double horrorScore,double musicalScore,double mysteryScore,
			double romanceScore,double sciFiScore,double thrillerScore,double warScore,double westernScore)
	{
		this.unknownScore = unknownScore;
		this.actionScore = actionScore;
		this.adventureScore = adventureScore;
		this.animationScore = animationScore;
		this.childrensScore = childrensScore;
		this.comedyScore = comedyScore;
		this.crimeScore = crimeScore;
		this.documentaryScore = documentaryScore;
		this.dramaScore = dramaScore;
		this.fantasyScore = fantasyScore;
		this.filmNoirScore = filmNoirScore;
		this.horrorScore = horrorScore;
		this.musicalScore = musicalScore;
		this.mysteryScore = mysteryScore;
		this.romanceScore = romanceScore;
		this.sciFiScore = sciFiScore;
		this.thrillerScore = thrillerScore;
		this.warScore = warScore;
		this.westernScore = westernScore;
	}
	
	/**
	 * Imports an Arralylist of ratings that only contains ratings by this user
	 * 
	 * @param ratings The Arraylist of ratings that belong to this user
	 */
	public void importUserRatings(ArrayList<Rating> ratings)
	{
		this.ratings = ratings;
	}
	
	/**
	 * Returns the Arraylist of ratings that belong to this user
	 * 
	 * @return The Arraylist of ratings that belong to this user
	 */
	public ArrayList<Rating> getUserRatings()
	{
		return this.ratings;
	}
	
	/**
	 * This method gets the user's top genre based on movies they have rated in order to make recommendations
	 * 
	 * @return A String of the user's top rated genre
	 */
	public String getTopGenre()
	{
		String currentTop = "unknown";
		double currentTopScore = unknownScore;
		if(actionScore > currentTopScore)
		{
			currentTop = "action";
			currentTopScore = actionScore;
		}	
		if(adventureScore > currentTopScore)
		{
			currentTopScore = adventureScore;
			currentTop = "adventure";
		}
		if(animationScore > currentTopScore)
		{
			currentTop = "animation";
			currentTopScore = animationScore;
		}
		if(childrensScore > currentTopScore)
		{
			currentTop = "childrens";
			currentTopScore = childrensScore;
		}
		if(comedyScore > currentTopScore)
		{
			currentTop = "comedy";
			currentTopScore = comedyScore;
		}
		if(crimeScore > currentTopScore)
		{
			currentTop = "crime";
			currentTopScore = crimeScore;
		}
		if(documentaryScore > currentTopScore)
		{
			currentTop = "documentary";
			currentTopScore = documentaryScore;
		}
		if(dramaScore > currentTopScore)
		{
			currentTop = "drama";
			currentTopScore = dramaScore;
		}
		if(fantasyScore > currentTopScore)
		{
			currentTop = "fantasy";
			currentTopScore = fantasyScore;
		}
		if(filmNoirScore > currentTopScore)
		{
			currentTop = "filmNoir";
			currentTopScore = filmNoirScore;
		}
		if(horrorScore > currentTopScore)
		{
			currentTop = "horror";
			currentTopScore = horrorScore;
		}
		if(musicalScore > currentTopScore)
		{
			currentTop = "musical";
			currentTopScore = musicalScore;
		}
		if(mysteryScore > currentTopScore)
		{
			currentTop = "mystery";
			currentTopScore = mysteryScore;
		}
		if(romanceScore > currentTopScore)
		{
			currentTop = "romance";
			currentTopScore = romanceScore;
		}	
		if(sciFiScore > currentTopScore)
		{
			currentTop = "sciFi";
			currentTopScore = sciFiScore;
		}
		if(thrillerScore > currentTopScore)
		{
			currentTop = "thriller";
			currentTopScore = thrillerScore;
		}
		if(warScore > currentTopScore)
		{
			currentTop = "war";
			currentTopScore = warScore;
		}
		if(westernScore > currentTopScore)
		{
			currentTop = "western";
			currentTopScore = westernScore;
		}
		return currentTop;
	}
	
	/**
	 * Gets the "score" of the user's ratings for movies in the unknown genre
	 * 
	 * @return The "score of the user's ratings for movies in the unknown genre
	 */
	public double getUnknownScore()
	{
		return toTwoDecimalPlaces(unknownScore);
	}
	
	/**
	 * Gets the "score" of the user's ratings for movies in the action genre
	 * 
	 * @return The "score of the user's ratings for movies in the action genre
	 */
	public double getActionScore()
	{
		return toTwoDecimalPlaces(actionScore);
	}
	
	/**
	 * Gets the "score" of the user's ratings for movies in the adventure genre
	 * 
	 * @return The "score of the user's ratings for movies in the adventure genre
	 */
	public double getAdventureScore()
	{
		return toTwoDecimalPlaces(adventureScore);
	}
	
	/**
	 * Gets the "score" of the user's ratings for movies in the animation genre
	 * 
	 * @return The "score of the user's ratings for movies in the animation genre
	 */
	public double getAnimationScore()
	{
		return toTwoDecimalPlaces(animationScore);
	}
	
	/**
	 * Gets the "score" of the user's ratings for movies in the children's genre
	 * 
	 * @return The "score of the user's ratings for movies in the children's genre
	 */
	public double getChildrensScore()
	{
		return toTwoDecimalPlaces(childrensScore);
	}
	
	/**
	 * Gets the "score" of the user's ratings for movies in the comedy genre
	 * 
	 * @return The "score of the user's ratings for movies in the comedy genre
	 */
	public double getComedyScore()
	{
		return toTwoDecimalPlaces(comedyScore);
	}
	
	/**
	 * Gets the "score" of the user's ratings for movies in the crime genre
	 * 
	 * @return The "score of the user's ratings for movies in the crime genre
	 */
	public double getCrimeScore()
	{
		return toTwoDecimalPlaces(crimeScore);
	}
	
	/**
	 * Gets the "score" of the user's ratings for movies in the documentary genre
	 * 
	 * @return The "score of the user's ratings for movies in the documentary genre
	 */
	public double getDocumentaryScore()
	{
		return toTwoDecimalPlaces(documentaryScore);
	}
	
	/**
	 * Gets the "score" of the user's ratings for movies in the drama genre
	 * 
	 * @return The "score of the user's ratings for movies in the drama genre
	 */
	public double getDramaScore()
	{
		return toTwoDecimalPlaces(dramaScore);
	}
	
	/**
	 * Gets the "score" of the user's ratings for movies in the fantasy genre
	 * 
	 * @return The "score of the user's ratings for movies in the fantasy genre
	 */
	public double getFantasyScore()
	{
		return toTwoDecimalPlaces(fantasyScore);
	}
	
	/**
	 * Gets the "score" of the user's ratings for movies in the film-noir genre
	 * 
	 * @return The "score of the user's ratings for movies in the film-noir genre
	 */
	public double getFilmNoirScore()
	{
		return toTwoDecimalPlaces(filmNoirScore);	
	}
	
	/**
	 * Gets the "score" of the user's ratings for movies in the horror genre
	 * 
	 * @return The "score of the user's ratings for movies in the horror genre
	 */
	public double getHorrorScore()
	{
		return toTwoDecimalPlaces(horrorScore);
	}
	
	/**
	 * Gets the "score" of the user's ratings for movies in the musical genre
	 * 
	 * @return The "score of the user's ratings for movies in the musical genre
	 */
	public double getMusicalScore()
	{
		return toTwoDecimalPlaces(musicalScore);
	}
	
	/**
	 * Gets the "score" of the user's ratings for movies in the mystery genre
	 * 
	 * @return The "score of the user's ratings for movies in the mystery genre
	 */
	public double getMysteryScore()
	{
		return toTwoDecimalPlaces(mysteryScore);
	}
	
	/**
	 * Gets the "score" of the user's ratings for movies in the romance genre
	 * 
	 * @return The "score of the user's ratings for movies in the romance genre
	 */
	public double getRomanceScore()
	{
		return toTwoDecimalPlaces(romanceScore);
	}
	
	/**
	 * Gets the "score" of the user's ratings for movies in the sci-fi genre
	 * 
	 * @return The "score of the user's ratings for movies in the sci-fi genre
	 */
	public double getSciFiScore()
	{
		return toTwoDecimalPlaces(sciFiScore);
	}
	
	/**
	 * Gets the "score" of the user's ratings for movies in the thriller genre
	 * 
	 * @return The "score of the user's ratings for movies in the thriller genre
	 */
	public double getThrillerScore()
	{
		return toTwoDecimalPlaces(thrillerScore);
	}
	
	/**
	 * Gets the "score" of the user's ratings for movies in the war genre
	 * 
	 * @return The "score of the user's ratings for movies in the war genre
	 */
	public double getWarScore()
	{
		return toTwoDecimalPlaces(warScore);
	}
	
	/**
	 * Gets the "score" of the user's ratings for movies in the western genre
	 * 
	 * @return The "score of the user's ratings for movies in the western genre
	 */
	public double getWesternScore()
	{
		return toTwoDecimalPlaces(westernScore);
	}
	
	/**
	 * Gets the user ID
	 * 
	 * @return The user ID
	 */
	public int getUserId()
	{
		return this.userId;
	}
	
	/**
	 * Sets the user ID
	 * 
	 * @param userId The user ID to be changed to
	 */
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	
	/**
	 * Gets the user's age
	 * 
	 * @return The user's age
	 */
	public int getAge()
	{
		return this.age;
	}
	
	/**
	 * Sets the user's age
	 * 
	 * @param age The user's age to be changed to
	 */
	public void setAge(int age)
	{
		this.age = age;
	}
	
	/**
	 * Gets the user's first name
	 * 
	 * @return The user's first name
	 */
	public String getFirstName()
	{
		return this.firstName;
	}
	
	/**
	 * Sets the user's first name
	 * 
	 * @param firstName The user's first name to be changed to
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	/**
	 * Gets the user's surname
	 * 
	 * @return The user's surname
	 */
	public String getSurname()
	{
		return this.surname;
	}
	
	/**
	 * Sets the user's surname
	 * 
	 * @param surname The user's surname to be changed to
	 */
	public void setSurname(String surname)
	{
		this.surname = surname;
	}
	
	/**
	 * Gets the user's gender
	 * 
	 * @return The user's gender
	 */
	public String getGender()
	{
		return this.gender;
	}
	
	/**
	 * Sets the user's gender
	 * 
	 * @param gender The user's gender to be changed to
	 */
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	
	/**
	 * Gets the user's occupation
	 * 
	 * @return The user's occupation
	 */
	public String getOccupation()
	{
		return this.occupation;
	}
	
	/**
	 * Sets the user's occupation
	 * 
	 * @param occupation The user's occupation to be changed to
	 */
	public void setOccupation(String occupation)
	{
		this.occupation = occupation;
	}
	
	/**
	 * This method takes a double and rounds it off to 2 decimal places
	 * 
	 * @param number The number that is being taken in to be rounded
	 * @return The rounded result of the number
	 */
	private double toTwoDecimalPlaces(double number)
	{
		return (int) (number *100 ) /100.0;
	}

}

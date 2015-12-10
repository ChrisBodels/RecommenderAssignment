
import java.util.ArrayList;

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
	
	public void importUserRatings(ArrayList<Rating> ratings)
	{
		this.ratings = ratings;
	}
	
	public ArrayList<Rating> getUserRatings()
	{
		return this.ratings;
	}
	
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
	 * 
	 * 
	 * @return
	 */
	public double getUnknownScore()
	{
		return toTwoDecimalPlaces(unknownScore);
	}
	
	public double getActionScore()
	{
		return toTwoDecimalPlaces(actionScore);
	}
	
	public double getAdventureScore()
	{
		return toTwoDecimalPlaces(adventureScore);
	}
	
	public double getAnimationScore()
	{
		return toTwoDecimalPlaces(animationScore);
	}
	
	public double getChildrensScore()
	{
		return toTwoDecimalPlaces(childrensScore);
	}
	
	public double getComedyScore()
	{
		return toTwoDecimalPlaces(comedyScore);
	}
	
	public double getCrimeScore()
	{
		return toTwoDecimalPlaces(crimeScore);
	}
	
	public double getDocumentaryScore()
	{
		return toTwoDecimalPlaces(documentaryScore);
	}
	
	public double getDramaScore()
	{
		return toTwoDecimalPlaces(dramaScore);
	}
	
	public double getFantasyScore()
	{
		return toTwoDecimalPlaces(fantasyScore);
	}
	
	public double getFilmNoirScore()
	{
		return toTwoDecimalPlaces(filmNoirScore);	
	}
	
	public double getHorrorScore()
	{
		return toTwoDecimalPlaces(horrorScore);
	}
	
	public double getMusicalScore()
	{
		return toTwoDecimalPlaces(musicalScore);
	}
	
	public double getMysteryScore()
	{
		return toTwoDecimalPlaces(mysteryScore);
	}
	
	public double getRomanceScore()
	{
		return toTwoDecimalPlaces(romanceScore);
	}
	
	public double getSciFiScore()
	{
		return toTwoDecimalPlaces(sciFiScore);
	}
	
	public double getThrillerScore()
	{
		return toTwoDecimalPlaces(thrillerScore);
	}
	
	public double getWarScore()
	{
		return toTwoDecimalPlaces(warScore);
	}
	
	public double getWesternScore()
	{
		return toTwoDecimalPlaces(westernScore);
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
	
	public String getFirstName()
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
	
	private double toTwoDecimalPlaces(double number)
	{
		return (int) (number *100 ) /100.0;
	}

}

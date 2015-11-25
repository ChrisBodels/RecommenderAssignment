import java.io.File;
import java.util.ArrayList;

import edu.princeton.cs.introcs.In;

public class User {
	
	private int userId, age, unknownScore, actionScore, adventureScore, animationScore, childrensScore, comedyScore, 
	crimeScore, documentaryScore, dramaScore, fantasyScore, filmNoirScore, horrorScore, musicalScore, mysteryScore,
	romanceScore, sciFiScore, thrillerScore, warScore, westernScore;
	private String firstName, surname, gender, occupation;
	private ArrayList<Rating> ratings;
	private int[] scores;
	
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
	
	public void setScores(int unknownScore,int actionScore,int adventureScore,int animationScore,int childrensScore,int comedyScore, 
			int crimeScore,int documentaryScore,int dramaScore,int fantasyScore,int filmNoirScore,int horrorScore,int musicalScore,int mysteryScore,
			int romanceScore,int sciFiScore,int thrillerScore,int warScore,int westernScore)
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
	
	//user should have list of rated movies
	public void importUserRatings(ArrayList<Rating> ratings)
	{
		this.ratings = ratings;
	}
	
	public ArrayList<Rating> getUserRatings()
	{
		return this.ratings;
	}
	
	public void sortArray()
	{
		int[] scores = new int[18];
		scores[0] = unknownScore;
		scores[1] = actionScore;
		scores[2] = adventureScore;
		scores[3] = animationScore;
		scores[4] = childrensScore;
		scores[5] = comedyScore;
		scores[6] = crimeScore;
		scores[7] = documentaryScore;
		scores[8] = dramaScore;
		scores[9] = fantasyScore;
		scores[10] = filmNoirScore;
		scores[11] = horrorScore;
		scores[12] = musicalScore;
		scores[13] = mysteryScore;
		scores[14] = romanceScore;
		scores[15] = sciFiScore;
		scores[16] = thrillerScore;
		scores[17] = warScore;
		scores[18] = westernScore;
	}
	
	public int getTopGenre()
	{
		int currentTop = unknownScore;
		if(actionScore > currentTop)
			currentTop = actionScore;
		if(adventureScore > currentTop)
			currentTop = adventureScore;
		if(animationScore > currentTop)
			currentTop = animationScore;
		if(childrensScore > currentTop)
			currentTop = childrensScore;
		if(comedyScore > currentTop)
			currentTop = comedyScore;
		if(crimeScore > currentTop)
			currentTop = crimeScore;
		if(documentaryScore > currentTop)
			currentTop = documentaryScore;
		if(dramaScore > currentTop)
			currentTop = dramaScore;
		if(fantasyScore > currentTop)
			currentTop = fantasyScore;
		if(filmNoirScore > currentTop)
			currentTop = filmNoirScore;
		if(horrorScore > currentTop)
			currentTop = horrorScore;
		if(musicalScore > currentTop)
			currentTop = musicalScore;
		if(mysteryScore > currentTop)
			currentTop = mysteryScore;
		if(romanceScore > currentTop)
			currentTop = romanceScore;
		if(sciFiScore > currentTop)
			currentTop = sciFiScore;
		if(thrillerScore > currentTop)
			currentTop = thrillerScore;
		if(warScore > currentTop)
			currentTop = warScore;
		if(westernScore > currentTop)
			currentTop = westernScore;
		return currentTop;
	}
	
	//public int getSecondTopGenre()
	{
		
	}
	
	//public int getThirdTopGenre()
	{
		
	}
	
	public int getUnknownScore()
	{
		return unknownScore;
	}
	
	public int getActionScore()
	{
		return actionScore;
	}
	
	public int getAdventureScore()
	{
		return adventureScore;
	}
	
	public int getAnimationScore()
	{
		return animationScore;
	}
	
	public int getChildrensScore()
	{
		return childrensScore;
	}
	
	public int getComedyScore()
	{
		return comedyScore;
	}
	
	public int getCrimeScore()
	{
		return crimeScore;
	}
	
	public int getDocumentaryScore()
	{
		return documentaryScore;
	}
	
	public int getDramaScore()
	{
		return dramaScore;
	}
	
	public int getFantasyScore()
	{
		return fantasyScore;
	}
	
	public int getFilmNoirScore()
	{
		return filmNoirScore;	
	}
	
	public int getHorrorScore()
	{
		return horrorScore;
	}
	
	public int getMusicalScore()
	{
		return musicalScore;
	}
	
	public int getMysteryScore()
	{
		return mysteryScore;
	}
	
	public int getRomanceScore()
	{
		return romanceScore;
	}
	
	public int getSciFiScore()
	{
		return sciFiScore;
	}
	
	public int getThrillerScore()
	{
		return thrillerScore;
	}
	
	public int getWarScore()
	{
		return warScore;
	}
	
	public int getWesternScore()
	{
		return westernScore;
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

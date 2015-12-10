/**
 * 
 * @author Chris Bodels
 *
 */
public class Movie implements Comparable<Movie> {
	
	private String title, url, longDate;
	private int movieId;
	private boolean unknown, action, adventure, animation, childrens, comedy, crime, documentary, drama, 
					fantasy, filmNoir, horror, musical, mystery, romance, sciFi, thriller, war, western;
	double totalRating;
	
	/**
	 * The constructor for objects of type Movie. Takes in a lot of parameters to ascertain the genre(s) of the film
	 * 
	 * @param movieId The id used to identify the movie
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
	public Movie(int movieId, String title, String longDate, String url/*, int year*/, boolean unknown, 
			boolean action, boolean adventure, boolean animation, boolean childrens, boolean comedy, 
			boolean crime, boolean documentary, boolean drama, boolean fantasy, boolean filmNoir, 
			boolean horror, boolean musical, boolean mystery, boolean romance, boolean sciFi, 
			boolean thriller, boolean war, boolean western)
	{
		this.title = title;
		this.url = url;
		this.longDate = longDate;
		this.movieId = movieId;
		this.unknown = unknown;
		this.action = action;
		this.adventure = adventure;
		this.animation = animation;
		this.childrens = childrens;
		this.comedy = comedy;
		this.crime = crime;
		this.documentary = documentary;
		this.drama = drama;
		this.fantasy = fantasy;
		this.filmNoir = filmNoir;
		this.horror = horror;
		this.musical = musical;
		this.mystery = mystery;
		this.romance = romance;
		this.sciFi = sciFi;
		this.thriller = thriller;
		this.war = war;
		this.western = western;
	}
	
	/** 
	 * Method that is used to compare total ratings of the films in order to get the top ten movies
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Movie compareMovie) //IF STATEMENTS TO GET -1, 1 OR 0
	{
		double compareTotalRating = compareMovie.getTotalRating();
		
		if(compareTotalRating < this.totalRating)
		{
			return -1;
		}
		if(compareTotalRating > this.totalRating)
		{
			return 1;
		}
		return 0;
		
		//return (int) ((int)compareTotalRating - Math.round(this.totalRating));
	}
	
	/**
	 * Returns the total rating for this movie
	 * 
	 * @return The total rating for this movie
	 */
	public double getTotalRating()
	{
		return this.totalRating;
	}
	
	/**
	 * Sets the total rating for the movie
	 * 
	 * @param rating The total rating for the movie
	 */
	public void setTotalRating(double rating)
	{
		this.totalRating = toTwoDecimalPlaces(rating);
	}
	
	/**
	 * Returns the title of the movie
	 * 
	 * @return The title of the movie
	 */
	public String getTitle()
	{
		return this.title;
	}
	
	/**
	 * Sets the title of the movie
	 * 
	 * @param title The title of the movie
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	/**
	 * Returns the url of the imdb page for the movie
	 * 
	 * @return The url of the imdb page for the movie
	 */
	public String getUrl()
	{
		return this.url;
	}
	
	/**
	 * Sets the url of the imdb page for the movie
	 * 
	 * @param url The url of the imdb page for the movie
	 */
	public void seturl(String url)
	{
		this.url = url;
	}
	
	/**
	 * Gets the release date of the movie in String form
	 * 
	 * @return The release date of the movie in String form
	 */
	public String getLongDate()
	{
		return longDate;
	}
	
	/**
	 * Sets the release date of the movie in String form
	 * 
	 * @param longDate The release date of the movie in String form
	 */
	public void setLongDate(String longDate)
	{
		this.longDate = longDate;
	}
	
	/**
	 * Returns the id that is used to identify the movie
	 * 
	 * @return The id that is used to identify the movie
	 */
	public int getMovieId()
	{
		return this.movieId;
	}
	
	/**
	 * Sets the id that is used to identify the movie
	 * 
	 * @param movieId The id that is used to identify the movie
	 */
	public void setMovieId(int movieId)
	{
		this.movieId = movieId;
	}
	
	/**
	 * Gets the boolean result of whether the movie is in the unknown genre or not
	 * 
	 * @return True or false based on whether it is in the unknown genre
	 */
	public boolean getUnknown()
	{
		return this.unknown;
	}
	
	/**
	 * Gets the boolean result of whether the movie is in the action genre or not
	 * 
	 * @return True or false based on whether it is in the action genre
	 */
	public boolean getAction()
	{
		return this.action;
	}
	
	/**
	 * Gets the boolean result of whether the movie is in the adventure genre or not
	 * 
	 * @return True or false based on whether it is in the adventure genre
	 */
	public boolean getAdventure()
	{
		return this.adventure;
	}
	
	/**
	 * Gets the boolean result of whether the movie is in the animation genre or not
	 * 
	 * @return True or false based on whether it is in the animation genre
	 */
	public boolean getAnimation()
	{
		return this.animation;
	}
	
	/**
	 * Gets the boolean result of whether the movie is in the children's genre or not
	 * 
	 * @return True or false based on whether it is in the children's genre
	 */
	public boolean getChildrens()
	{
		return this.childrens;
	}
	
	/**
	 * Gets the boolean result of whether the movie is in the comedy genre or not
	 * 
	 * @return True or false based on whether it is in the comedy genre
	 */
	public boolean getComedy()
	{
		return this.comedy;
	}
	
	/**
	 * Gets the boolean result of whether the movie is in the crime genre or not
	 * 
	 * @return True or false based on whether it is in the crime genre
	 */
	public boolean getCrime()
	{
		return this.crime;
	}
	
	/**
	 * Gets the boolean result of whether the movie is in the documentary genre or not
	 * 
	 * @return True or false based on whether it is in the documentary genre
	 */
	public boolean getDocumentary()
	{
		return this.documentary;
	}
	
	/**
	 * Gets the boolean result of whether the movie is in the drama genre or not
	 * 
	 * @return True or false based on whether it is in the drama genre
	 */
	public boolean getDrama()
	{
		return this.drama;
	}
	
	/**
	 * Gets the boolean result of whether the movie is in the fantasy genre or not
	 * 
	 * @return True or false based on whether it is in the fantasy genre
	 */
	public boolean getFantasy()
	{
		return this.fantasy;
	}
	
	/**
	 * Gets the boolean result of whether the movie is in the film noir genre or not
	 * 
	 * @return True or false based on whether it is in the film noir genre
	 */
	public boolean getFilmNoir()
	{
		return this.filmNoir;
	}
	
	/**
	 * Gets the boolean result of whether the movie is in the horror genre or not
	 * 
	 * @return True or false based on whether it is in the horror genre
	 */
	public boolean getHorror()
	{
		return this.horror;
	}
	
	/**
	 * Gets the boolean result of whether the movie is in the musical genre or not
	 * 
	 * @return True or false based on whether it is in the musical genre
	 */
	public boolean getMusical()
	{
		return this.musical;
	}
	
	/**
	 * Gets the boolean result of whether the movie is in the mystery genre or not
	 * 
	 * @return True or false based on whether it is in the mystery genre
	 */
	public boolean getMystery()
	{
		return this.mystery;
	}
	
	/**
	 * Gets the boolean result of whether the movie is in the romance genre or not
	 * 
	 * @return True or false based on whether it is in the romance genre
	 */
	public boolean getRomance()
	{
		return this.romance;
	}
	
	/**
	 * Gets the boolean result of whether the movie is in the sci-fi genre or not
	 * 
	 * @return True or false based on whether it is in the sci-fi genre
	 */
	public boolean getSciFi()
	{
		return this.sciFi;
	}
	
	/**
	 * Gets the boolean result of whether the movie is in the thriller genre or not
	 * 
	 * @return True or false based on whether it is in the thriller genre
	 */
	public boolean getThriller()
	{
		return this.thriller;
	}
	
	/**
	 * Gets the boolean result of whether the movie is in the war genre or not
	 * 
	 * @return True or false based on whether it is in the war genre
	 */
	public boolean getWar()
	{
		return this.war;
	}
	
	/**
	 * Gets the boolean result of whether the movie is in the western genre or not
	 * 
	 * @return True or false based on whether it is in the western genre
	 */
	public boolean getWestern()
	{
		return this.western;
	}
	
	/**
	 * Returns a String of all the genres that the movie is in
	 * 
	 * @return String that says which genres the movie is in
	 */
	public String getGenre()
	{
		String genre = "Genre(s): ";
		if(this.unknown)
			genre += "Unkown. ";
		if(this.action)
			genre += "Action. ";
		if(this.adventure)
			genre += "Adventure. ";
		if(this.animation)
			genre += "Animation. ";
		if(this.childrens)
			genre += "Children's. ";
		if(this.comedy)
			genre += "Comedy. ";
		if(this.crime)
			genre += "Crime. ";
		if(this.documentary)
			genre += "Documentary. ";
		if(this.drama)
			genre += "Drama. ";
		if(this.fantasy)
			genre += "Fantasy. ";
		if(this.filmNoir)
			genre += "Film Noir. ";
		if(this.horror)
			genre += "Horror. ";
		if(this.musical)
			genre += "Musical. ";
		if(this.mystery)
			genre += "Mystery. ";
		if(this.romance)
			genre += "Romance. ";
		if(this.sciFi)
			genre += "Sci-Fi. ";
		if(this.thriller)
			genre += "Thriller. ";
		if(this.war)
			genre += "War. ";
		if(this.western)
			genre += "Western. ";
		return genre;
	}
	
	/**
	 * This method is used to round doubles down to two decimal places
	 * 
	 * @param num The number to be rounded
	 * @return The rounded down number
	 */
	private double toTwoDecimalPlaces(double num)
	{
		return (int) (num *100 ) /100.0; 
	}
	
	/**
	 * Returns a String version of the movie object
	 */
	public String toString()
	{
		return "Movie title: " + title + ". Release Date: " + longDate + ". Movie ID: " + movieId + ". " + getGenre() + "URL: " + url +"";
	}

}


public class Movie implements Comparable<Movie> {
	
	private String title, url, longDate;
	private int year, movieId;
	private boolean unknown, action, adventure, animation, childrens, comedy, crime, documentary, drama, 
					fantasy, filmNoir, horror, musical, mystery, romance, sciFi, thriller, war, western;
	double totalRating;
	
	public Movie(int movieId, String title, String longDate, String url/*, int year*/, boolean unknown, 
			boolean action, boolean adventure, boolean animation, boolean childrens, boolean comedy, 
			boolean crime, boolean documentary, boolean drama, boolean fantasy, boolean filmNoir, 
			boolean horror, boolean musical, boolean mystery, boolean romance, boolean sciFi, 
			boolean thriller, boolean war, boolean western)
	{
		this.title = title;
		this.url = url;
		this.longDate = longDate;
		this.year = year;
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
	
	public double getTotalRating()
	{
		return this.totalRating;
	}
	
	public void setTotalRating(double rating)
	{
		this.totalRating = toTwoDecimalPlaces(rating);
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getUrl()
	{
		return this.url;
	}
	
	public void seturl(String url)
	{
		this.url = url;
	}
	
	public String getLongDate()
	{
		return longDate;
	}
	
	public void setLongDate(String longDate)
	{
		this.longDate = longDate;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public void setYear(int year)
	{
		this.year = year;
	}
	
	public int getMovieId()
	{
		return this.movieId;
	}
	
	public void setMovieId(int movieId)
	{
		this.movieId = movieId;
	}
	
	public boolean getUnknown()
	{
		return this.unknown;
	}
	
	public boolean getAction()
	{
		return this.action;
	}
	
	public boolean getAdventure()
	{
		return this.adventure;
	}
	
	public boolean getAnimation()
	{
		return this.animation;
	}
	
	public boolean getChildrens()
	{
		return this.childrens;
	}
	
	public boolean getComedy()
	{
		return this.comedy;
	}
	
	public boolean getCrime()
	{
		return this.crime;
	}
	
	public boolean getDocumentary()
	{
		return this.documentary;
	}
	
	public boolean getDrama()
	{
		return this.drama;
	}
	
	public boolean getFantasy()
	{
		return this.fantasy;
	}
	
	public boolean getFilmNoir()
	{
		return this.filmNoir;
	}
	
	public boolean getHorror()
	{
		return this.horror;
	}
	
	public boolean getMusical()
	{
		return this.musical;
	}
	
	public boolean getMystery()
	{
		return this.mystery;
	}
	
	public boolean getRomance()
	{
		return this.romance;
	}
	
	public boolean getSciFi()
	{
		return this.sciFi;
	}
	
	public boolean getThriller()
	{
		return this.thriller;
	}
	
	public boolean getWar()
	{
		return this.war;
	}
	
	public boolean getWestern()
	{
		return this.western;
	}
	
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
	
	private double toTwoDecimalPlaces(double num)
	{
		return (int) (num *100 ) /100.0; 
	}
	
	public String toString()
	{
		return "Movie title: " + title + ". Release Date: " + longDate + ". Movie ID: " + movieId + ". " + getGenre() + "URL: " + url +"";
	}

}

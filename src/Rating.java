
public class Rating {
	
	private int userId, movieId, rating;
	
	public Rating(int userId, int movieId, int rating)
	{
		this.userId = userId;
		this.movieId = movieId;
		this.rating = rating;
	}
	
	public int getUserId()
	{
		return this.userId;
	}
	
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	
	public int getMovieId()
	{
		return this.movieId;
	}
	
	public void setMovieId(int movieId)
	{
		this.movieId = movieId;
	}
	
	public int getRating()
	{
		return this.rating;
	}
	
	public void setRating(int rating)
	{
		this.rating = rating;
	}

}

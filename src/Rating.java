
/**
 * @author Chris Bodels
 *
 */
public class Rating {
	
	private int userId, movieId, rating;
	
	/**
	 * Constructor for objects of type Rating. Takes in user id, movie id and rating to create the rating.
	 * 
	 * @param userId The user id of the user who created the rating
	 * @param movieId The movie id of the movie that is being rated
	 * @param rating The actual rating that the user gave (int 1-5).
	 */
	public Rating(int userId, int movieId, int rating)
	{
		this.userId = userId;
		this.movieId = movieId;
		this.rating = rating;
	}
	
	/**
	 * Returns the user id of the user who made the rating
	 *  
	 * @return The user id of the user who made this rating
	 */
	public int getUserId()
	{
		return this.userId;
	}
	
	/**
	 * Sets the user id of the user who made the rating
	 * 
	 * @param userId The user id of the user who made the rating
	 */
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	
	/**
	 * Returns the movie id of the movie that is being rated
	 * 
	 * @return The movie id of the movie that is being rated
	 */
	public int getMovieId()
	{
		return this.movieId;
	}
	
	/**
	 * Sets the movie id of the movie that is being rated
	 * 
	 * @param movieId The movie id of the movie that is being rated
	 */
	public void setMovieId(int movieId)
	{
		this.movieId = movieId;
	}
	
	/**
	 * Returns the rating that the user gave to the movie (int 1-5)
	 * 
	 * @return The rating that the user gave to the movie (int 1-5)
	 */
	public int getRating()
	{
		return this.rating;
	}
	
	/**
	 * Sets the rating that the user gave to the movie (int 1-5)
	 * 
	 * @param rating The rating that the user gave to the movie (int 1-5)
	 */
	public void setRating(int rating)
	{
		this.rating = rating;
	}

}

import java.util.ArrayList;
import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;

public class Main 
{
	
	private ArrayList<User> users;
	public Recommender recommenderAPI;
	
	public Main() throws Exception
	{
		recommenderAPI = new Recommender();
		users = recommenderAPI.getUsers();
	}

	public static void main(String[] args) throws Exception
	{
		Main app = new Main();
		
		Shell shell = ShellFactory.createConsoleShell("pm", "Welcome to the movie Recommender. Please start by reading in data"
				+ " or loading if data has been previously saved - ?help for instructions", app);
	    shell.commandLoop();
	}
	
	@Command(description="Get all users details")
	 public void getUsers ()
	 {
		for(int i =0; i < users.size(); i++)
		{
			System.out.println("UserId: " + users.get(i).getUserId() + ". Name: " + users.get(i).getFirstName() + " "
					+ users.get(i).getSurname() + ". Age: " + users.get(i).getAge() + ". Gender: " + users.get(i).getGender() 
					+ ". Occupation: " + users.get(i).getOccupation());
		}
	 }
	
	@Command(description="Get a specific user's details")
	public void getUser(@Param(name="user id") int userId)
	{
		User user = recommenderAPI.getUser(userId);
		System.out.println("UserId: " + user.getUserId() + ". Name: " + user.getFirstName() + " " + user.getSurname() + 
				". Age: " + user.getAge() + ". Gender: " + user.getGender() + ". Occupation: " + user.getOccupation());
	}
	
	@Command(description="Create a new User")
	public void createUser(@Param(name="first name") String firstName, @Param(name="last name") String surname,
			@Param(name="age") int age, @Param(name="gender") String gender, @Param(name="occupation") String occupation) throws Exception
	{
		recommenderAPI.addUser(firstName, surname, age, gender, occupation);
	}
	
	@Command(description="Delete an existing user")
	public void deleteUser(@Param(name="user id") int userId)
	{
		recommenderAPI.removeUser(userId);
	}
	
	@Command(description="Get top ten movies")
	public void getTopTenMovies()
	{
		recommenderAPI.getTopTenMovies();
	}
	
	@Command(description="Get movie details")
	public void getMovieDetails(@Param(name="movie id") int movieId)
	{
		System.out.println(recommenderAPI.getMovieDetails(movieId));
	}
	
	@Command(description="Add movie")
	public void addMovie(@Param(name="title") String title, @Param(name="long date") String longDate, @Param(name="url") String url,
			@Param(name="unknown") boolean unknown, @Param(name="action") boolean action, @Param(name="adventure") boolean adventure,
			@Param(name="animation") boolean animation, @Param(name="childrens") boolean childrens, @Param(name="comedy") boolean comedy,
			@Param(name="crime") boolean crime, @Param(name="documentary") boolean documentary, @Param(name="drama") boolean drama, 
			@Param(name="fantasy") boolean fantasy, @Param(name="film noir") boolean filmNoir, @Param(name="horror") boolean horror,
			@Param(name="musical") boolean musical, @Param(name="mystery") boolean mystery, @Param(name="romance") boolean romance,
			@Param(name="sci fi") boolean sciFi, @Param(name="thriller") boolean thriller, @Param(name="war") boolean war,
			@Param(name="western") boolean western)
	{
		recommenderAPI.addMovie(title, longDate, url, unknown, action, adventure, animation, childrens, comedy, crime, documentary,
				drama, fantasy, filmNoir, horror, musical, mystery, romance, sciFi, thriller, war, western);
	}
	
	@Command(description="Remove Movie")
	public void removeMovie(@Param(name="movie id") int movieId)
	{
		recommenderAPI.removeMovie(movieId);
	}
	
	@Command(description="Add rating")
	public void addRating(@Param(name="user id") int userId, @Param(name="movie id") int movieId, @Param(name="rating") int rating)
	{
		recommenderAPI.addRating(userId, movieId, rating);
	}

	@Command(description="Read in data")
	public void readInData() throws Exception
	{
		recommenderAPI.readInData();
	}
	
	/*@Command(description="Load data from file")
	public void load() throws Exception
	{
		recommenderAPI.load();
	}
	
	@Command(description="Save existing data from the running application")
	public void save() throws Exception
	{
		recommenderAPI.save();
	}*/
	
	@Command(description="Recommend movies")
	public void recommend(@Param(name="user id") int userId)
	{
		recommenderAPI.getUserRecommendations(userId);
	}
	
	@Command(description="Get a user's ratings")
	public void getUsersRatings(@Param(name="user id") int userId)
	{
		System.out.println(recommenderAPI.getUserRatings(userId));
	}
	
	@Command(description="Get all movies")
	public void getMovies()
	{
		System.out.println(recommenderAPI.getAllMovies());
	}
	
}

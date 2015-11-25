import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.*;
import java.util.ArrayList;
public class HandleXML {
	
	public static ArrayList<User> readUsers() throws Exception
	{
		XMLDecoder decoder =
				new XMLDecoder(new BufferedInputStream(
						new FileInputStream("Users")));
		ArrayList<User> users = (ArrayList<User>) decoder.readObject();
		decoder.close();
		return users;
	}
	
	public static void writeUsers(ArrayList<User> users) throws Exception
	{
		XMLEncoder encoder =
				new XMLEncoder(
						new BufferedOutputStream(
								new FileOutputStream("Users")));
		encoder.writeObject(users);
		encoder.close();
	}
	
	public static ArrayList<Movie> readMovies() throws Exception
	{
		XMLDecoder decoder =
				new XMLDecoder(new BufferedInputStream(
						new FileInputStream("Movies")));
		ArrayList<Movie> movies = (ArrayList<Movie>) decoder.readObject();
		decoder.close();
		return movies;
	}
	
	public static void writeMovies(ArrayList<Movie> movies) throws Exception
	{
		XMLEncoder encoder =
				new XMLEncoder(
						new BufferedOutputStream(
								new FileOutputStream("Movies")));
		encoder.writeObject(movies);
		encoder.close();
	}
	
	public static ArrayList<Rating> readRatings() throws Exception
	{
		XMLDecoder decoder =
				new XMLDecoder(new BufferedInputStream(
						new FileInputStream("Ratings")));
		ArrayList<Rating> ratings = (ArrayList<Rating>) decoder.readObject();
		decoder.close();
		return ratings;
	}
	
	public static void writeRatings(ArrayList<Rating> ratings) throws Exception
	{
		XMLEncoder encoder =
				new XMLEncoder(
						new BufferedOutputStream(
								new FileOutputStream("Ratings")));
		encoder.writeObject(ratings);
		encoder.close();
	}

}
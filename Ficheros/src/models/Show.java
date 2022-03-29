package models;

import java.sql.Date;
import java.time.Year;
import java.util.ArrayList;

public class Show {
	private String show_id;
	private String type;
	private String title;
	private String director;
	private String cast;
	private String country;
	private String date_added;
	private String release_year;
	private String rating;
	private String duration;
	private String listed_in;
	private String description;
	/**
	 * @param show_id
	 * @param type
	 * @param title
	 * @param director
	 * @param cast
	 * @param country
	 * @param date_added
	 * @param release_year
	 * @param rating
	 * @param duration
	 * @param listed_in
	 * @param description
	 */
	public Show(String[] tristeza) {
		super();
		this.show_id = tristeza[0];
		this.type = tristeza[1];
		this.title = tristeza[2];
		this.director = tristeza[3];
		this.cast = tristeza[4].replace("\"", "");
		this.country = tristeza[5];
		this.date_added = tristeza[6];
		this.release_year = tristeza[7];
		this.rating = tristeza[8];
		this.duration = tristeza[9];
		this.listed_in = tristeza[10];
		this.description = tristeza[11];
	}
	
	public Show(String a, String b, String c, String d, String e,String f, String g, String h, String i, String j, String k, String l) {
		super();
		this.show_id = a;
		this.type = b;
		this.title = c;
		this.director = d;
		this.cast = e;
		this.country = f;
		this.date_added = g;
		this.release_year = h;
		this.rating = i;
		this.duration = j;
		this.listed_in = k;
		this.description = l;
	}
	
	/**
	 * @return the release_year
	 */
	public String getRelease_year() {
		return release_year;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @return the cast
	 */
	public String getCast() {
		return cast;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return the date_added
	 */
	public String getDate_added() {
		return date_added;
	}

	/**
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * @return the listed_in
	 */
	public String getListed_in() {
		return listed_in;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the id
	 */
	public String getID() {
		return show_id;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Show [show_id=");
		builder.append(show_id);
		builder.append(", type=");
		builder.append(type);
		builder.append(", title=");
		builder.append(title);
		builder.append(", director=");
		builder.append(director);
		builder.append(", cast=");
		builder.append(cast);
		builder.append(", country=");
		builder.append(country);
		builder.append(", date_added=");
		builder.append(date_added);
		builder.append(", release_year=");
		builder.append(release_year);
		builder.append(", rating=");
		builder.append(rating);
		builder.append(", duration=");
		builder.append(duration);
		builder.append(", listed_in=");
		builder.append(listed_in);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}
	
	
}

package utils;

import java.util.Comparator;

import models.Show;

public class Compa implements Comparator<Show>{

	@Override
	public int compare(Show o1, Show o2) {
		return o1.getRelease_year().compareTo(o2.getRelease_year());
	}

}

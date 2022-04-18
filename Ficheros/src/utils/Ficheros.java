package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import models.Show;
import models.Users;

public class Ficheros {

	public static void insertarFav(Show a, char b) {
		try {
			File f = new File("fav.csv");

			boolean creado = false;
			String s = a.getID() + b + a.getType() + b + a.getTitle() + b + a.getDirector() + b + a.getCast() + b
					+ a.getCountry() + b + a.getDate_added() + b + a.getRelease_year() + b + a.getRating() + b
					+ a.getDuration() + b + a.getListed_in() + b + a.getDescription()+"\n";
			if (!f.exists())
				f.createNewFile();
			Scanner sc = null;

			sc = new Scanner(f, "UTF-8");

			FileWriter fi = new FileWriter("fav.csv", true);

			if (sc.hasNextLine()) {
				while (sc.hasNextLine()) {
					String sa = sc.nextLine();
					String[] info = sa.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);	
					if (info[0].equals(a.getID())) {
						creado = true;
					}
				}

				if (!creado) {
					fi.write(s);
					fi.flush();
				}
			} else {
				fi.write(s);
				fi.flush();
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

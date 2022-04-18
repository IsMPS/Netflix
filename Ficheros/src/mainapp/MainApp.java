package mainapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

import dao.NetflixDAO;
import models.Show;
import views.MenuPrincipal;

public class MainApp {
	
	public static void main(String[] args) {
		/**
		ArrayList<Show> show = new ArrayList<Show>();
		File f = new File("netflix_titles.csv");
		Scanner sc = null;
		try {
			sc = new Scanner(f, "UTF-8");
			sc.nextLine();
			while (sc.hasNextLine()) {
				String s = sc.nextLine();
				s = s.replace(",,", ",desconocido,");
				s = s.replace("'", " ");
				String[] info = s.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				Show m = new Show(info);
				show.add(m);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		for (Show n : show) {
			NetflixDAO.insert(n);
		} 
		sc.close();
		*/
		new MenuPrincipal();
		
	}
}

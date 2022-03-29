package mainapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

import models.Show;
import utils.Compa;
import utils.Emails;

public class MainApp {

	public static void main(String[] args) {
		TreeSet<Show> show = new TreeSet<Show>(new Compa());
//		ArrayList<Show> show = new ArrayList<Show>();
		File f = new File("netflix_titles.csv");
		Scanner sc = null;
		try {
			sc = new Scanner(f, "UTF-8");
			sc.nextLine();
			while (sc.hasNextLine()) {
				String s = sc.nextLine();
				s = s.replace(",,", ",null,");
				String[] info = s.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				Show m = new Show(info);
				show.add(m);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		for (Show n : show) {
			System.out.println(n);
		}
		sc.close();
		
		Emails.sendConfirm(null);
	}
}

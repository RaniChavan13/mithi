package mithi;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;

public class MithiAssignment {
	static String P1 = "";
	static String P2 = "";
	static String P3 = "";
	static String excludeWords = "";

	public static void main(String[] args) {
		File directory = new File("C:\\Users\\wellcome\\OneDrive\\Desktop\\Internshala");
		// the location differs based on the system folders
		String[] file1 = { "Page1.txt" };
		String[] file2 = { "Page2.txt" };
		String[] file3 = { "Page3.txt" };
		String[] exclude = { "exclude-words.txt" };

		TreeSet<String> set = new TreeSet<String>();
		TreeSet<String> set1 = new TreeSet<String>();
		TreeSet<String> set2 = new TreeSet<String>();
		TreeSet<String> set3 = new TreeSet<String>();
		ArrayList<String> arraylist = new ArrayList<String>();

		for (String filename : exclude) {
			File file = new File(directory, filename);

			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = reader.readLine()) != null) {

					excludeWords = excludeWords + " " + line;
				}
				String[] s1 = excludeWords.split(" ");

				for (int i = 0; i < s1.length; i++) {
					arraylist.add(s1[i].toLowerCase());
				}

				reader.close();
			} catch (IOException e) {
				System.err.println("Error: " + file.getAbsolutePath());
			}
		}

		for (String filename : file1) {
			File file = new File(directory, filename);

			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = reader.readLine()) != null) {

					line = line.replace(",", " ").replace(".", " ").replace("-", " ").replace(":", "")
							.replace("\"", " ").replace("(", " ").replace(")", " ").replace("/", " ").replace("1", "")
							.replace("2", "").replace("3", "").replace("4", "").replace("5", "").replace("6", "")
							.replace("7", "").replace("8", "").replace("9", "").replace("0", "");

					P1 = P1 + " " + line;
				}
				String[] s1 = P1.split(" ");
				for (int i = 0; i < s1.length; i++) {
					set.add(s1[i].toLowerCase());
					set1.add(s1[i].toLowerCase());
				}

				reader.close();
			} catch (IOException e) {
				System.err.println("Error: " + file.getAbsolutePath());
			}
		}

		for (String filename : file2) {
			File file = new File(directory, filename);

			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = reader.readLine()) != null) {

					line = line.replace(",", " ").replace(".", " ").replace("-", " ").replace(":", "")
							.replace("\"", " ").replace("(", " ").replace(")", " ").replace("/", " ").replace("1", "")
							.replace("2", "").replace("3", "").replace("4", "").replace("5", "").replace("6", "")
							.replace("7", "").replace("8", "").replace("9", "").replace("0", "");

					P2 = P2 + " " + line;
				}
				String[] s2 = P2.split(" ");
				for (int i = 0; i < s2.length; i++) {
					set.add(s2[i].toLowerCase());
					set2.add(s2[i].toLowerCase());
				}

				reader.close();
			} catch (IOException e) {
				System.err.println("Error: " + file.getAbsolutePath());
			}
		}

		for (String filename : file3) {
			File file = new File(directory, filename);

			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = reader.readLine()) != null) {

					line = line.replace(",", " ").replace(".", " ").replace("-", " ").replace(":", "")
							.replace("\"", " ").replace("(", " ").replace(")", " ").replace("/", " ").replace("1", "")
							.replace("2", "").replace("3", "").replace("4", "").replace("5", "").replace("6", "")
							.replace("7", "").replace("8", "").replace("9", "").replace("0", "");
					P3 = P3 + " " + line;
				}
				String[] s3 = P3.split(" ");
				for (int i = 0; i < s3.length; i++) {
					set.add(s3[i].toLowerCase());
					set3.add(s3[i].toLowerCase());
				}
				reader.close();
			} catch (IOException e) {
				System.err.println("Error: " + file.getAbsolutePath());
			}
		}

		ArrayList<String> al = new ArrayList<String>(set);
		ArrayList<String> al1 = new ArrayList<String>(set1);
		ArrayList<String> al2 = new ArrayList<String>(set2);
		ArrayList<String> al3 = new ArrayList<String>(set3);

		for (String string : arraylist) {
			if (al.contains(string)) {
				al.remove(string);
			}
		}

		File location = new File("C:\\Users\\wellcome\\OneDrive\\Desktop\\Internshala\\index.txt");

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(location)))
		{
			bw.write("Word : Page Numbers");
			bw.newLine();
			bw.write("-------------------");
			bw.newLine();

			for (String obj : al) {
				if (al1.contains(obj) && al2.contains(obj) && al3.contains(obj)) {
					bw.write(obj + " : 1,2,3");
					bw.newLine();
				
				} else if (al1.contains(obj) && al2.contains(obj)) {
					bw.write(obj + " : 1,2");
					bw.newLine();
					
				} else if (al1.contains(obj) && al3.contains(obj)) {
					bw.write(obj + " : 1,3");
					bw.newLine();
					
				} else if (al2.contains(obj) && al3.contains(obj)) {
					bw.write(obj + " : 2,3");
					bw.newLine();
				
				} else if (al1.contains(obj)) {
					bw.write(obj + " : 1");
					bw.newLine();
				
				} else if (al2.contains(obj)) {
					bw.write(obj + " : 2");
					bw.newLine();
				
				} else if (al3.contains(obj)) {
					bw.write(obj + " : 3");
					bw.newLine();
				
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
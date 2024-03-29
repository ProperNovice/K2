package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class File {

	private static java.io.File file = new java.io.File("txt.txt");

	private File() {

	}

	public static void createFileIfItDoesntExist() {

		if (file.exists())
			return;

		createNewFile();

	}

	public static void writeToFile(ArrayList<String> list) {

		if (file.exists())
			file.delete();

		createNewFile();

		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
				file))) {

			while (!list.isEmpty()) {

				bufferedWriter.write(list.remove(0));
				bufferedWriter.newLine();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static ArrayList<String> readFromFile() {

		ArrayList<String> fileList = new ArrayList<>();

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
				file))) {

			String line = null;

			while (true) {

				line = bufferedReader.readLine();

				if (line == null)
					break;

				fileList.add(line);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return fileList;

	}

	private static void createNewFile() {
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

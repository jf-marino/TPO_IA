package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ResultReader {
	
	
	public static List<String> read(String filename) {
		FileInputStream fstream;
		List<String> results = new ArrayList<String>();
		try {
			fstream = new FileInputStream(filename);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			//Read File Line By Line
			try {
				while ((strLine = br.readLine()) != null)   {
				  results.add(strLine);
				}
				fstream.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error while reading a line from file: "+filename);
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(String.format("File <%s> does not exist.", filename));
			e.printStackTrace();
		}
		return results;
	}
}

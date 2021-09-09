package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner (System.in);
		
		Map<String, Integer> votes = new LinkedHashMap<>();
		
		System.out.print("Enter file full path: ");
		String path = sc.next();
		
		try (BufferedReader bf = new BufferedReader(new FileReader(path))){
			
					
			String line = bf.readLine();
			while(line != null) {
				
				String [] vect = line.split(",");
				String name = vect[0];
				int number = Integer.parseInt(vect[1]);
				
				if(votes.containsKey(name)) {
					int newVote = votes.get(name);
					votes.put(name, number + newVote);
				}
				else {
					votes.put(name, number);
				}
				
				line = bf.readLine();
			}
			
			for(String key : votes.keySet()) {
				
				System.out.println(key + ": " + votes.get(key));
				
			}
		}

		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		
		
		sc.close();

	}

}

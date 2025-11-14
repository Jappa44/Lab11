

/**
 * File: Lab11Prob01.java
 * @author Ben Bearth, Tyler Pridgen
 * Created on: 11/14/2025
 * Modified on: 11/14/2025
 * Description: reads and creates an exact copy of an input .dat file
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Lab11Prob02 {
	public static void main(String[] args) {
		ArrayList<Person> people = new ArrayList<>();
		try (DataInputStream input = new DataInputStream(new FileInputStream(new File("src/people.dat")));) {
			int age, zipCode;
			String name, address;
			double salary;

			while (true) {
				age = input.readInt();
				name = input.readUTF();
				address = input.readUTF();
				zipCode = input.readInt();
				salary = input.readDouble();

				Person guy = new Person(age, name, address, zipCode, salary);
				people.add(guy);

				System.out.printf("%d %s %s %d %.2f%n", age, name, address, zipCode, salary);

			}
		} catch (FileNotFoundException ex) {
			System.out.println("Could not find the specified file.");
			ex.printStackTrace();
		} catch (EOFException ex) {
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("An unexpected error occured.");
			e.printStackTrace();
		}
		java.util.Collections.sort(people);

		try (DataOutputStream output = new DataOutputStream(new FileOutputStream(new File("src/people-salary-sorted.dat")));
		) {
			for (Person guy: people) {
				output.writeUTF(guy.toString());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("An unexpected error occured.");
			e.printStackTrace();
		}

	}
}
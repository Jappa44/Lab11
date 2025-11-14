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

public class Lab11Prob01 {
	public static void main(String[] args) {
		try (
			DataInputStream input = new DataInputStream(new FileInputStream(new File("src/people.dat")));
			DataOutputStream output = new DataOutputStream(new FileOutputStream(new File("src/people-copy.dat")));
		) {
			int age, zipCode;
			String name, address;
			double salary;
			
			
			while (true) {
				age = input.readInt();
				name = input.readUTF();
				address = input.readUTF();
				zipCode = input.readInt();
				salary = input.readDouble();
				
				System.out.printf("%d %s %s %d %.2f%n", age, name, address, zipCode, salary);
				
				output.writeInt(age);
				output.writeUTF(name);
				output.writeUTF(address);
				output.writeInt(zipCode);
				output.writeDouble(salary);
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
	}
}

/* File CabbageClient.java
 * Author: Saran Vadlamudi
 * Date: December 12, 2017
 * Description: In this class the client will use the registry, created by the server, to look up an object 
 * 				also exported by the server.
 */
package client;

import java.rmi.Naming;
import java.util.Scanner;
import java.util.UUID;

import datatransfer.Cabbage;
import remoteinterface.CabbageService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;

public class CabbageClient {
    /* code here please */

	public static void main(String[] args) {
		Cabbage cabbage = new Cabbage();
		boolean shutdown = false;// Used to stop the program based on user response
		String response = "";// used to store user response whether or not the client should continue
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner keyboard = new Scanner(System.in);
		
		try {             
			do {
				
				System.out.print("Enter data for new cabbage: ");
				// Lines 36 to 59 reads data from the user to be inserted into a cabbage object
				System.out.print("\nPlease enter line number: ");
				
				cabbage.setLineNumber(Integer.valueOf(br.readLine()));
				
				System.out.print("\nPlease enter alpha: ");
				
				cabbage.setAlpha(br.readLine());
				
				System.out.print("\nPlease enter beta: ");
				
				cabbage.setBeta(br.readLine());
				
				System.out.print("\nPlease enter charlie: ");
				
				cabbage.setCharlie(br.readLine());
				
				System.out.print("\nPlease enter delta: ");
				
				cabbage.setDelta(br.readLine());
				
				// Following two statements generates a random uuid and inserts into cabbage object
				UUID uuid = UUID.randomUUID();
				String uuidStr = String.valueOf(uuid);				
				cabbage.setUUID(uuidStr);
				

				CabbageService cS = (CabbageService)
									Naming.lookup("Cabbage");// Searches for an object in registry under the name Cabbage
				
				cS.insert(cabbage);// Will now invoke a method on the remote object to insert cabbage data
				System.out.println("Inserted: " + cS.findByUUID(cabbage.getUUID().toString()));// Displays the recently inserted cabbage data
				
				// Asks the user if another cabbage needs to be inserted
				System.out.print("\nDo you want to insert another cabbage?(y or n): ");
				response = keyboard.nextLine();
				
				/*
				 * If user declines then it will exit the do-while loop by checking if boolean shutdown is false.
				 * Since it will equal to true in the if condition it will exit. 
				 */
				if(response.equals("n")) {
		                System.out.println("shutting down connection to server");
		                System.out.println("Client run by Saran");
		                shutdown = true;
				}
			 
			} while (shutdown == false);
			keyboard.close();
		} catch (IOException exception) {
			System.out.println(exception.getMessage());
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

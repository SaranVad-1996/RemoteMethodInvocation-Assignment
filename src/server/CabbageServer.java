/* File CabbageServer.java

 * Author: Saran Vadlamudi
 * Date: December 12, 2017
 * Description: RMI Server startup. This class will create the registry, export the object and bind it under a name that the client can
 * use to look it up in the registry.
 */
package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import remoteinterface.CabbageService;

public class CabbageServer {
	public static void main(String saran[]) {
		try {
			CabbageService cs = new CabbageServiceImpl();
			
			LocateRegistry.createRegistry(1099);// Default port to create registry is 1099
			UnicastRemoteObject.exportObject(cs, 0);// Exports object cs on port 0
			Naming.rebind("Cabbage", cs);// Name "Cabbage" will be binded to object cs
			
			// Notifies that the server is ready
			System.out.println("Server is ready");
			System.out.println("Server ran by Saran Vadlamudi");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

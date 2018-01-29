/* File CabbageServiceImpl.java
 * Author: Saran Vadlamudi
 * Date: December 12, 2017
 * Description: Remote Object that permits clients to insert
 *              Cabbage records into a database, as well as
 *              retrieve them using String based uuid.
 */
package server;

import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;

import datatransfer.Cabbage;

import dataaccesslayer.CabbageDaoImpl;

import remoteinterface.CabbageService;

public class CabbageServiceImpl extends RemoteServer implements CabbageService  {
	/**
	 * Eclipse generated serial version uid
	 */
	private static final long serialVersionUID = 1L;

	protected CabbageServiceImpl() throws RemoteException {
		super();
	}
	
	// Calls the singleton method's insert to insert the data found in cabbage object
	@Override
	public void insert(Cabbage cabbage) throws RemoteException {
		CabbageDaoImpl.INSTANCE.insert(cabbage);
	}
	
	// Calls the singleton method's findByUUID to display the information of a cabbage object with a specifically supplied UUID
	@Override
	public Cabbage findByUUID(String uuid) throws RemoteException {
		Cabbage cab = CabbageDaoImpl.INSTANCE.findByUUID(uuid);
		return cab;
	}
}

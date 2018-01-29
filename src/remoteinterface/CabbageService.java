/* File CabbageService.java
 * Author: Saran Vadlamudi
 * Date: December 12, 2017
 * Description: Remote (RMI) interface for a Remote Object
 *              that will allow Cabbage objects to be inserted
 *              and searched by uuid String.
 */
package remoteinterface;

import java.rmi.Remote;
import datatransfer.Cabbage;

/** Remote interface for the RMI-based CabbageService object
 */
public interface CabbageService extends Remote {
	public void insert(Cabbage cabbage) throws java.rmi.RemoteException;
	public Cabbage findByUUID(String uuid) throws java.rmi.RemoteException;
}

/* File: CabbageDao.java
 * Author: Saran Vadlamudi
 * Date: December 12, 2017
 * Description: Interface for Data Access Layer for Cabbage objects
 */
package dataaccesslayer;

// import java.util.List;
import datatransfer.Cabbage; 

/**
 * Interface with abstract methods for CRUD operations
 * with findByUUID and insert for Cabbages table.
 * @author Saran Vadlamudi
 *
 */
public interface CabbageDao {
	Cabbage findByUUID(String uuid);
	void insert(Cabbage cabbage);
}

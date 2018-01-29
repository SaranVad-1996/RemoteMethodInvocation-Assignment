/* File CabbageClient.java
 * Author: Saran Vadlamudi
 * Modifed On: December 12, 2017
 * Description: Data transfer object for Cabbage records,
 *              updated with Hibernate annotations.
 */
package datatransfer;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="cabbages")// If table doesn't exist, Hibernate will create a table in MySQL under the supplied name 
public class Cabbage implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private int lineNumber;
	private String alpha;
	private String beta;
	private String charlie;
	private String delta;
	private String uuid;
	
	public Cabbage() {
		this(0,0,"","","","");
	}
	
	public Cabbage(Integer id, int lineNumber, String alpha, String beta, String charlie, String delta) {
		this.id = id;
		this.lineNumber = lineNumber;
		this.alpha = alpha;
		this.beta = beta;
		this.charlie = charlie;
		this.delta = delta;
	}
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column
	public int getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	@Column
	public String getAlpha() {
		return alpha;
	}
	public void setAlpha(String alpha) {
		this.alpha = alpha;
	}
	
	@Column
	public String getBeta() {
		return beta;
	}
	public void setBeta(String beta) {
		this.beta = beta;
	}
	
	@Column
	public String getCharlie() {
		return charlie;
	}
	public void setCharlie(String charlie) {
		this.charlie = charlie;
	}
	
	@Column
	public String getDelta() {
		return delta;
	}
	public void setDelta(String delta) {
		this.delta = delta;
	}
	
	@Column
	public String getUUID() {
		return uuid;
	}
	public void setUUID(String uuid) {
		this.uuid = uuid;
	}
	
	@Override
	public String toString() {
		return String.format("%d,%d,%s,%s,%s,%s,%s",id, lineNumber, alpha, beta, charlie, delta,uuid);
	}
}

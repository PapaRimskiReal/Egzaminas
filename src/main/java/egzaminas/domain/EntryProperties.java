package egzaminas.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "entryPorperties")
public class EntryProperties {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String comment;
	private String answer;
	private String userName;
	
	@ManyToOne
 	@JoinColumn(name = "entry_id")
	private Entry entry;

	public EntryProperties() {
		
	}

	public EntryProperties(String comment, String answer, String userName) {
		super();
		this.comment = comment;
		this.answer = answer;
		this.setUserName(userName);
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * @return the entry
	 */
	public Entry getEntry() {
		return entry;
	}

	/**
	 * @param entry the entry to set
	 */
	public void setEntry(Entry entry) {
		this.entry = entry;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	
	
}

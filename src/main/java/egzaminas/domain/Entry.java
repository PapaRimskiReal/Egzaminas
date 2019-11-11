package egzaminas.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "entry", uniqueConstraints = @UniqueConstraint(columnNames = { "title" }))
public class Entry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String text;
	private String author;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "entry")
	private List<EntryProperties> entryProperties = new ArrayList<EntryProperties>();

	public Entry() {
	}

	public Entry(String title, String text, String author) {
		super();
		this.title = title;
		this.text = text;
		this.author = author;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the entryProperties
	 */
	public List<EntryProperties> getEntryProperties() {
		return entryProperties;
	}

	/**
	 * @param entryProperties the entryProperties to set
	 */
	public void setEntryProperties(List<EntryProperties> entryProperties) {
		this.entryProperties = entryProperties;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	
}

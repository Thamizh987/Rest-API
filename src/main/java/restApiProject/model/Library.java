package restApiProject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="LibraryManagementDetails")
/*@Entity-->It identifies a class as an entity class
 * A table is created with this class name(in lower case)by default in DB,we can also change the table name*/
public class Library {

	//Attributes--->columns of the table
	@Id //Primary key of the table
	@GeneratedValue(strategy = GenerationType.IDENTITY)////IDENTITY-->always starts with 1 and incremented by 1 
	@Column(name = "BookId",length=4)//@Column-->to change the column properties(name,length,nullable)
	private Integer bookId;

	@Column(name = "BookName",length=20, nullable = false)
	private String bookName;

	@Column(name = "AuthorName",length=20, nullable = false)
	private String authorName;

	@Column(name = "Journal",length=20, nullable = false)
	private String journal;

	@Column(name = "Edition", nullable = false)
	private Integer edition;

	@Column(name = "NoOfCopies", nullable = false)
	private Integer noOfCopies;

	//Public getters and setters for the above mentioned attributes
	public  Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getJournal() {
		return journal;
	}
	public void setJournal(String journal) {
		this.journal = journal;
	}

	public Integer getEdition() {
		return edition;
	}
	public void setEdition(Integer edition) {
		this.edition = edition;
	}

	public Integer getNoOfCopies() {
		return noOfCopies;
	}
	public void setNoOfCopies(Integer noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
	@Override
	public String toString() {
		return "Library [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + ", journal="
				+ journal + ", edition=" + edition + ", noOfCopies=" + noOfCopies + "]";
	}

}








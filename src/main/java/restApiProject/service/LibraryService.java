package restApiProject.service;

import java.util.List;
import restApiProject.model.Library;

public interface LibraryService {

	//Interface ---> only method declaration
	//to save the records
	Library saveLibraryRecords(Library library);
	//to read all the records from the table in database
	List<Library>  getRecordsFromDb();
	//to read particular book by bookId
	Library getBookById(int BookId);
	//to update the book details by bookId
	Library updateLibraryDetails(Library value, int BookId);
	//to delete the record using bookId
	void deleteRecordById(int BookId);
}









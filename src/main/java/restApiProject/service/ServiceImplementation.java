package restApiProject.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import restApiProject.exception.ResourceNotFoundException;
import restApiProject.model.Library;
import restApiProject.repository.LibraryRepository;

@Service
//@Service annotation is used with classes that provide some business logics.
public class ServiceImplementation implements LibraryService {

    //declaring variable of type LibraryRepository
	LibraryRepository libraryRepo;

	//Constructor Injection to libraryRepo
	public ServiceImplementation(LibraryRepository libraryRepo) {
		this.libraryRepo = libraryRepo;
	}

	//Overriding the methods from service class
	@Override 
	public Library saveLibraryRecords(Library library) {
		return libraryRepo.save(library);
	}

	@Override 
	public List<Library> getRecordsFromDb() {
		return libraryRepo.findAll();	
	}

	@Override
	public Library getBookById(int bookId) {
		Optional<Library> library = libraryRepo.findById(bookId);
		if(library.isPresent()) {
			return library.get();
		}
		else {
			throw new ResourceNotFoundException("Book does not exist with id :" + bookId);
		}
	}

	@Override
	public Library updateLibraryDetails(Library newValue, int bookId) {
		Optional<Library> library = libraryRepo.findById(bookId);
		if(library.isPresent()) {
			Library existingLibRecord = library.get();  
			existingLibRecord.setNoOfCopies(newValue.getNoOfCopies());
			libraryRepo.save(existingLibRecord);
			return existingLibRecord;
		}
		else {
			throw new ResourceNotFoundException("Book does not exist with id :" + bookId);
		}
	}

	@Override
	public void deleteRecordById(int bookId) {
		Optional<Library> library = libraryRepo.findById(bookId);
		if(library.isPresent()) {
			libraryRepo.deleteById(bookId);		
		}
		else {
			throw new ResourceNotFoundException("Book does not exist with id :" + bookId);

		}
	}
}









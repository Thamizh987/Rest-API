package restApiProject.controller;

	import java.util.List;
	import java.util.Scanner;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import restApiProject.model.Library;
import restApiProject.service.ServiceImplementation;
@RestController
/*@ResponseBody-tells a controller that the object returned is automatically 
 * serialized into JSON and passed back into the HttpResponse object.
 * @Controller->The dispatcher will scan such annotated classes for mapped methods.*/
	@RequestMapping("/RestAPIproject")
//@RequestMapping Annotation which is used to map HTTP requests to handler methods REST controllers
	public class LibraryController {

		private static Scanner scan=new Scanner(System.in);

		// libServ attribute
		public ServiceImplementation libServ;
		// constructor Injection to libServ
		public LibraryController(ServiceImplementation libServ) {
			this.libServ = libServ;
		}

		//CREATE RECORD REST API
		@PostMapping("/saveLibraryRecord")
		/*@PostMapping annotation maps HTTP POST requests onto specific handler methods.
		Shortcut for-->@RequestMapping(method = RequestMethod.POST)*/
		public ResponseEntity<Library> saveLibraryRecords(@RequestBody Library library){
			return new ResponseEntity<Library>(libServ.saveLibraryRecords(library), HttpStatus.CREATED);
		}

		//UPDATE RECORDS BY BOOKID
		@PutMapping("/updateLibrary/{bookId}")
		//@PutMapping annotated methods handle the HTTP PUT requests matched with the given URI expression
		/*@RequestBody used to convert JSON to Java Objects
		 Spring automatically deserializes the JSON into a Java type*/
		public ResponseEntity<Library> updateLibraryDetails(@PathVariable("bookId") int id,@RequestBody Library library){
			System.out.println("Enter the bookId you need to update: "); 
			return new ResponseEntity<Library>(libServ.updateLibraryDetails(library,scan.nextInt()), HttpStatus.OK);
		}

		//GET RECORDS REST API
		@GetMapping("/readAllRecords")
		//@GetMapping annotated methods handle the HTTP GET requests matched with the given URI expression
		public List<Library> getRecordsFromDb(){
			return libServ.getRecordsFromDb();
		}

		//GET RECORD BY BOOKID REST API
		@GetMapping("/readRecord/{bookId}")
		//@GetMapping annotated methods handle the HTTP GET requests matched with the given URI expression
		/*@PathVariable-->annotation which indicates that a method parameter should be bound to a URI template variable.
		  If we want to extract particular record by its ID,then we can use @PathVariable*/
		public ResponseEntity<Library>  getBookById(@PathVariable  int bookId){
			System.out.println("Enter the bookId you need to display: "); 
			return new ResponseEntity<Library>(libServ.getBookById(scan.nextInt()), HttpStatus.OK);
		}

		//DELETE RECORD BY BOOK ID
		@DeleteMapping("/deleteRecord/{bookId}")
		//@DeleteMapping annotated methods handle the HTTP DELETE requests matched with the given URI expression
		//@ResponseEntity represents the whole HTTP response: status code.we can use it to fully configure the HTTP response.
		public ResponseEntity<String> deleteRecordById(@PathVariable("bookId")  int Id){
			System.out.println("Enter the bookId you need to delete: "); 
			libServ.deleteRecordById(scan.nextInt());
			return new ResponseEntity<String>("deleted successfully", HttpStatus.OK);
		}
	}








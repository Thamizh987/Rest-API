package restApiProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restApiProject.model.Library;

//Interface extending the JPARepository Interface
public interface LibraryRepository extends JpaRepository<Library, Integer> {

}






package pastryApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pastryApp.model.Form;

public interface FormsRepository extends JpaRepository<Form, Integer> {
}

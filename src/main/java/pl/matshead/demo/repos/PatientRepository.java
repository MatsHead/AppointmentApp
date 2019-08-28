package pl.matshead.demo.repos;

import org.springframework.data.repository.CrudRepository;
import pl.matshead.demo.entities.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
}

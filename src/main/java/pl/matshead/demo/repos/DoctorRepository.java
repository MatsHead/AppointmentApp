package pl.matshead.demo.repos;

import org.springframework.data.repository.CrudRepository;
import pl.matshead.demo.entities.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
}

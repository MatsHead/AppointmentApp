package pl.matshead.demo.repos;

import org.springframework.data.repository.CrudRepository;
import pl.matshead.demo.entities.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
}

package pl.matshead.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.matshead.demo.entities.Appointment;
import pl.matshead.demo.entities.Doctor;
import pl.matshead.demo.entities.Insurance;
import pl.matshead.demo.entities.Patient;
import pl.matshead.demo.repos.AppointmentRepository;
import pl.matshead.demo.repos.DoctorRepository;
import pl.matshead.demo.repos.PatientRepository;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    AppointmentRepository appointmentRepository;


    @Test
    public void createDoctor() {
        Doctor doctor = new Doctor();
        doctor.setFirstName("Jan");
        doctor.setLastName("Brok");
        doctor.setSpeciality("Neuro");
        doctorRepository.save(doctor);
    }

    @Test
    public void createPatient(){
        Patient patient = new Patient();
        patient.setFirstName("gregory");
        patient.setLastName("Obrog");
        patient.setPhone("311311311");
        Insurance insurance = new Insurance();
        insurance.setProviderName("Nlue Crocs");
        insurance.setCopay(240d);
        patient.setInsurance(insurance);
        Doctor doctor = doctorRepository.findById(1).get();
        List<Doctor> doctors = Arrays.asList(doctor);
        patient.setDoctors(doctors);
        patientRepository.save(patient);
    }

    @Test
    public void createAppointment() throws ParseException {
        Appointment appointment = new Appointment();
        appointment.setReason("Runny nose");
        java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf("2019-09-23 10:10:10.0");
        appointment.setAppointmentTime(timestamp);
        appointment.setStarted(false);
        appointment.setEnded(false);
        appointment.setPatient(patientRepository.findById(2).get());
        appointment.setDoctor(doctorRepository.findById(1).get());
        appointmentRepository.save(appointment);
    }
}

package za.ac.cput.hospitalsystem.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.hospitalsystem.domain.Patient;

/**
 * Created by student on 2015/05/18.
 */
public interface PatientRepository extends CrudRepository<Patient,Long> {
}

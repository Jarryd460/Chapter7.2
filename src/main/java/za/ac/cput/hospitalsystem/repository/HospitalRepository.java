package za.ac.cput.hospitalsystem.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.hospitalsystem.domain.Hospital;

/**
 * Created by student on 2015/05/14.
 */
public interface HospitalRepository extends CrudRepository<Hospital,Long> {
}

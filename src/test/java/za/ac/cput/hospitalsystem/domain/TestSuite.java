package za.ac.cput.hospitalsystem.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by student on 2015/05/13.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestAddress.class,
        TestAppointment.class,
        TestBill.class,
        TestContact.class,
        TestDoctor.class,
        TestHospital.class,
        TestPatient.class,
        TestWard.class
})
public class TestSuite {
}

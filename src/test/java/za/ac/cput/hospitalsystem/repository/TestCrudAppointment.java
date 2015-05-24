package za.ac.cput.hospitalsystem.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.junit.Assert;
import za.ac.cput.hospitalsystem.App;
import za.ac.cput.hospitalsystem.config.factory.AppointmentFactory;
import za.ac.cput.hospitalsystem.domain.Appointment;
import org.testng.annotations.Test;

/**
 * Created by student on 2015/05/18.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudAppointment  extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    AppointmentRepository repository;

    @Test
    public void testCreate() throws Exception {
        Appointment appointment = AppointmentFactory.createAppointment(null, 2000, null);
        repository.save(appointment);
        id = appointment.getId();
        Assert.assertNotNull(appointment.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Appointment appointment = repository.findOne(id);
        Assert.assertEquals(2000, appointment.getAmount());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Appointment appointment = repository.findOne(id);
        Appointment newAppointment = new Appointment.Builder(appointment.getPatient()).copy(appointment).id(appointment.getId()).amount(1000).build();
        repository.save(newAppointment);

        Appointment updatedAppointment = repository.findOne(id);

        Assert.assertEquals(1000, updatedAppointment.getAmount());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Appointment appointment = repository.findOne(id);
        repository.delete(appointment);
        Appointment newAppointment = repository.findOne(id);
        Assert.assertNull(newAppointment);
    }

}

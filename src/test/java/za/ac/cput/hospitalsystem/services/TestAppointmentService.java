package za.ac.cput.hospitalsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.hospitalsystem.App;
import za.ac.cput.hospitalsystem.config.factory.AppointmentFactory;
import za.ac.cput.hospitalsystem.domain.Appointment;
import za.ac.cput.hospitalsystem.repository.AppointmentRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/19.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestAppointmentService extends AbstractTestNGSpringContextTests {

    @Autowired
    private AppointmentService service;
    @Autowired
    private AppointmentRepository repository;
    private List<Appointment> appointments;

    @BeforeMethod
    public void setUp() throws Exception {
        appointments = new ArrayList<Appointment>();
    }

    @Test
    public void create() throws Exception {
        Appointment appointment1 = AppointmentFactory.createAppointment(null, 2000, null);
        Appointment appointment2 = AppointmentFactory.createAppointment(null, 1000, null);

        repository.save(appointment1);
        Assert.assertNotNull(appointment1.getId());

        repository.save(appointment2);
        Assert.assertNotNull(appointment2.getId());
    }

    @Test
    public void testGetHospitals() throws Exception {
        appointments = service.getAppointments();
        Assert.assertEquals(2, appointments.size());
        repository.deleteAll();
    }

}

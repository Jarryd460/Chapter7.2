package za.ac.cput.hospitalsystem.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.hospitalsystem.config.factory.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/13.
 */
public class TestHospital {

    @Test
    public void testCreate() {
        Address address = AddressFactory.createAddress("Street1", "Cape Town", "3254");
        Contact contact = ContactFactory.createContact("1234567890", "J@gmail.com", "0987654321");
        Patient patient = PatientFactory.createPatient("Jarryd", "Deane", Sex.Male, 23, "1234567890", "Street2");
        List<Patient> patientList = new ArrayList<Patient>();
        patientList.add(patient);
        Ward ward = WardFactory.createWard(20, patientList);
        List<Ward> wardList = new ArrayList<Ward>();
        wardList.add(ward);
        Bill bill = BillFactory.createBill(10000);
        List<Bill> billList = new ArrayList<Bill>();
        billList.add(bill);
        Appointment appointment = AppointmentFactory.createAppointment(patient, 10000, billList);
        List<Appointment> appointmentList = new ArrayList<Appointment>();
        appointmentList.add(appointment);
        Doctor doctor = DoctorFactory.createDoctor("Doctor", "Little", "Radiologist", appointmentList);
        List<Doctor> doctorList = new ArrayList<Doctor>();
        doctorList.add(doctor);
        Hospital hospital = HospitalFactory.createHospital("hospital1", address, contact, wardList, doctorList);

        Assert.assertEquals("hospital1", hospital.getName());
        Assert.assertEquals("Cape Town", hospital.getAddress().getCity());
        Assert.assertEquals("1234567890", hospital.getContact().getTelephoneNumber());
    }

    @Test
    public void testUpdate() {
        Address address = AddressFactory.createAddress("Street1", "Cape Town", "3254");
        Contact contact = ContactFactory.createContact("1234567890", "J@gmail.com", "0987654321");
        Patient patient = PatientFactory.createPatient("Jarryd", "Deane", Sex.Male, 23, "1234567890", "Street2");
        List<Patient> patientList = new ArrayList<Patient>();
        patientList.add(patient);
        Ward ward = WardFactory.createWard(20, patientList);
        List<Ward> wardList = new ArrayList<Ward>();
        wardList.add(ward);
        Bill bill = BillFactory.createBill(10000);
        List<Bill> billList = new ArrayList<Bill>();
        billList.add(bill);
        Appointment appointment = AppointmentFactory.createAppointment(patient, 10000, billList);
        List<Appointment> appointmentList = new ArrayList<Appointment>();
        appointmentList.add(appointment);
        Doctor doctor = DoctorFactory.createDoctor("Doctor", "Little", "Radiologist", appointmentList);
        List<Doctor> doctorList = new ArrayList<Doctor>();
        doctorList.add(doctor);
        Hospital hospital = HospitalFactory.createHospital("hospital1", address, contact, wardList, doctorList);

        Address address1 = AddressFactory.createAddress("Street2", "Durban", "4452");
        Hospital hospitalCopy = new Hospital.Builder(hospital.getName()).copy(hospital).address(address1).build();

        Assert.assertEquals("hospital1", hospitalCopy.getName());
        Assert.assertEquals("Durban", hospitalCopy.getAddress().getCity());
        Assert.assertEquals("1234567890", hospitalCopy.getContact().getTelephoneNumber());

    }

}

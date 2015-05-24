package za.ac.cput.hospitalsystem.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.hospitalsystem.App;
import org.testng.annotations.Test;
import za.ac.cput.hospitalsystem.config.factory.WardFactory;
import za.ac.cput.hospitalsystem.domain.Ward;

/**
 * Created by student on 2015/05/18.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudWard extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    WardRepository repository;

    @Test
    public void testCreate() throws Exception {
        Ward ward = WardFactory.createWard(20, null);
        repository.save(ward);
        id = ward.getId();
        Assert.assertNotNull(ward.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Ward ward = repository.findOne(id);
        Assert.assertEquals(20, ward.getCapacity());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Ward ward = repository.findOne(id);
        Ward newWard = new Ward.Builder(ward.getCapacity()).copy(ward).id(ward.getId()).capacity(23).build();
        repository.save(newWard);

        Ward updatedWard = repository.findOne(id);

        Assert.assertEquals(23, updatedWard.getCapacity());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Ward ward = repository.findOne(id);
        repository.delete(ward);
        Ward newWard = repository.findOne(id);
        Assert.assertNull(newWard);
    }

}

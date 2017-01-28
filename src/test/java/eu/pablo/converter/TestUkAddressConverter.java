package eu.pablo.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import eu.pablo.entity.UKAddress;
import eu.pablo.model.UkAddressModel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUkAddressConverter {

	@Autowired
	@Qualifier("ukAddressConverter")
	private UkAddressConverter ukAddressConverter;
	
	@Test
	public void testEntity2ModelConversion(){
		UKAddress uka = new UKAddress();
		uka.setPostcode("POSTCODE1");
		uka.setAddressline1("False Street number 123");
		uka.setAddressline2("Springfield");
		uka.setCounty("Someplace");
		
		UkAddressModel ukam = ukAddressConverter.entity2model(uka);
		
		assertNotNull(ukam);
		assertEquals(uka.getPostcode(), ukam.getPostcode());
		assertEquals(uka.getAddressline1(), ukam.getAddressline1());
		assertEquals(uka.getAddressline2(), ukam.getAddressline2());
		assertEquals(uka.getCounty(), ukam.getCounty());

	}
	
	@Test
	public void testModel2EntityConversion(){
		UkAddressModel ukam = new UkAddressModel();
		ukam.setPostcode("POSTCODE1");
		ukam.setAddressline1("False Street number 123");
		ukam.setAddressline2("Springfield");
		ukam.setCounty("Someplace");
		
		UKAddress uka = ukAddressConverter.model2entity(ukam);
		
		assertNotNull(uka);
		assertEquals(uka.getPostcode(), ukam.getPostcode());
		assertEquals(uka.getAddressline1(), ukam.getAddressline1());
		assertEquals(uka.getAddressline2(), ukam.getAddressline2());
		assertEquals(uka.getCounty(), ukam.getCounty());

	}

}

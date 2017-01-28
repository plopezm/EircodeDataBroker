package eu.pablo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import eu.pablo.model.AddressModel;
import eu.pablo.model.UkAddressModel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUkAddressService {

	@Autowired
	@Qualifier("ukAddressServiceImpl")
	private UKAddressService ukAddressService;
	
	@Test
	@Transactional
	public void testInsertAndFindNewPostcode(){
		UkAddressModel ukam = new UkAddressModel();
		ukam.setPostcode("POSTCODE1");
		ukam.setAddressline1("False Street number 123");
		
		ukAddressService.insertUkAddress(ukam);
		assertEquals(ukam.getAddressline1(), ukAddressService.findByPostcode("POSTCODE1").getAddressline1());	
	}
	
	@Test
	@Transactional
	public void testFindByPostcodeNotFound() {
		UkAddressModel ukam = new UkAddressModel();
		ukam.setPostcode("POSTCODE1");
		ukam.setAddressline1("False Street number 123");
		
		ukAddressService.insertUkAddress(ukam);
		assertNull(ukAddressService.findByPostcode("POSTCODE2"));		
	}
	
	@Test
	@Transactional
	public void testRemoveAndFindPostcode(){
		UkAddressModel ukam = new UkAddressModel();
		ukam.setPostcode("POSTCODE1");
		ukam.setAddressline1("False Street number 123");
		
		ukAddressService.insertUkAddress(ukam);
		assertEquals(ukam.getAddressline1(), ukAddressService.findByPostcode("POSTCODE1").getAddressline1());
		
		AddressModel res = ukAddressService.removeUkAddress(ukam);
		
		assertNotNull(res);
		assertNull(ukAddressService.findByPostcode("POSTCODE2"));
		
	}
	
	@Test
	@Transactional
	public void testRemoveAndFindPostcodeNotFound(){
		UkAddressModel ukam = new UkAddressModel();
		ukam.setPostcode("POSTCODE1");
		ukam.setAddressline1("False Street number 123");
		
		AddressModel res = ukAddressService.removeUkAddress(ukam);
		
		assertNull(res);
		assertNull(ukAddressService.findByPostcode("POSTCODE1"));
		
	}

}

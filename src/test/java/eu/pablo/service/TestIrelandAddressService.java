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

import eu.pablo.model.IrelandAddressModel;
import eu.pablo.model.IrelandAddressCoordinateLookupModel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestIrelandAddressService {

	@Autowired
	@Qualifier("irelandAddressServiceImpl")
	private IrelandAddressService irelandAddressService;
	
	@Test
	@Transactional
	public void testInsertAndFindNewPostcode(){
		IrelandAddressModel iam = new IrelandAddressModel();
		iam.setPostcode("POSTCODE1");
		iam.setAddressline1("False Street number 123");
		
		irelandAddressService.insertIrelandAddress(iam);
		assertEquals(iam.getAddressline1(), irelandAddressService.findByPostcode("POSTCODE1").getAddressline1());	
	}
	
	@Test
	@Transactional
	public void testInsertAndFindNewPostcodeWithCoords(){
		IrelandAddressCoordinateLookupModel iam = new IrelandAddressCoordinateLookupModel();
		iam.setPostcode("POSTCODE1");
		iam.setAddressline1("False Street number 123");
		iam.setLatitude("1");
		iam.setLongitude("2");
		
		irelandAddressService.insertIrelandAddress(iam);
		IrelandAddressCoordinateLookupModel iam2 = irelandAddressService.findCoordinateLookupByPostcode("POSTCODE1");
		assertEquals(iam.getAddressline1(), iam2.getAddressline1());	
		assertEquals("1", iam2.getLatitude());
		assertEquals("2", iam2.getLongitude());
	}
	
	@Test
	@Transactional
	public void testRemoveAndFindPostcode(){
		IrelandAddressModel am = new IrelandAddressModel();
		am.setPostcode("POSTCODE2");
		am.setAddressline1("False Street number 123");
		
		irelandAddressService.insertIrelandAddress(am);
		assertEquals(am.getAddressline1(), irelandAddressService.findByPostcode("POSTCODE2").getAddressline1());
		
		IrelandAddressModel res = irelandAddressService.removeIrelandAddress(am);
		
		assertNotNull(res);
		assertNull(irelandAddressService.findByPostcode("POSTCODE2"));
		
	}
	
	@Test
	@Transactional
	public void testRemoveNotFoundPostcode(){
		IrelandAddressModel am = new IrelandAddressModel();
		am.setPostcode("POSTCODE2");
		am.setAddressline1("False Street number 123");
		
		irelandAddressService.insertIrelandAddress(am);
		assertEquals(am.getAddressline1(), irelandAddressService.findByPostcode("POSTCODE2").getAddressline1());
		
		am.setPostcode("POSTCODE1");
		IrelandAddressModel res = irelandAddressService.removeIrelandAddress(am);
		
		assertNull(res);
		
	}
	
	@Test
	@Transactional
	public void testRemoveAndFindPostcodeCoordinateLookupModel(){
		IrelandAddressCoordinateLookupModel iam = new IrelandAddressCoordinateLookupModel();
		iam.setPostcode("POSTCODE2");
		iam.setAddressline1("False Street number 123");
		iam.setLatitude("1");
		iam.setLongitude("2");
		
		irelandAddressService.insertIrelandAddress(iam);
		assertEquals(iam.getAddressline1(), irelandAddressService.findByPostcode("POSTCODE2").getAddressline1());
		
		IrelandAddressModel res = irelandAddressService.removeIrelandAddress(iam);
		
		assertNotNull(res);
		assertNull(irelandAddressService.findByPostcode("POSTCODE2"));
		
	}
	
	@Test
	@Transactional
	public void testFindByPostcodeNotFound() {
		IrelandAddressModel iam = new IrelandAddressModel();
		iam.setPostcode("POSTCODE1");
		iam.setAddressline1("False Street number 123");
		
		irelandAddressService.insertIrelandAddress(iam);
		assertNull(irelandAddressService.findByPostcode("POSTCODE2"));		
	}

}

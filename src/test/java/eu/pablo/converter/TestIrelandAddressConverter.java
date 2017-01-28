package eu.pablo.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import eu.pablo.entity.IrelandAddress;
import eu.pablo.model.AddressModel;
import eu.pablo.model.IrelandAddressCoordinateLookupModel;
import eu.pablo.model.IrelandAddressWhat3WordsModel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestIrelandAddressConverter {

	@Autowired
	@Qualifier("irelandAddressConverter")
	private IrelandAddressConverter irelandAddressConverter;
	
	@Test
	public void testEntity2ModelConversion(){
		IrelandAddress ia = new IrelandAddress();
		ia.setPostcode("POSTCODE1");
		ia.setAddressline1("False Street number 123");
		ia.setAddressline2("Springfield");
		ia.setCounty("Someplace");
		
		AddressModel iam = irelandAddressConverter.entity2model(ia);
		
		assertNotNull(iam);
		assertEquals(ia.getPostcode(), iam.getPostcode());
		assertEquals(ia.getAddressline1(), iam.getAddressline1());
		assertEquals(ia.getAddressline2(), iam.getAddressline2());
		assertEquals(ia.getCounty(), iam.getCounty());

	}
	
	@Test
	public void testEntity2CoordModelConversion(){
		IrelandAddress ia = new IrelandAddress();
		ia.setPostcode("POSTCODE1");
		ia.setAddressline1("False Street number 123");
		ia.setAddressline2("Springfield");
		ia.setCounty("Someplace");
		ia.setLatitude("1");
		ia.setLongitude("2");
		
		IrelandAddressCoordinateLookupModel iam = irelandAddressConverter.entity2CoordModel(ia);
		
		assertNotNull(iam);
		assertEquals(ia.getPostcode(), iam.getPostcode());
		assertEquals(ia.getAddressline1(), iam.getAddressline1());
		assertEquals(ia.getAddressline2(), iam.getAddressline2());
		assertEquals(ia.getCounty(), iam.getCounty());
		assertEquals(ia.getLatitude(), iam.getLatitude());
		assertEquals(ia.getLongitude(), iam.getLongitude());
	}
	
	@Test
	public void testEntity2What3WordsModelConversion(){
		IrelandAddress ia = new IrelandAddress();
		ia.setPostcode("POSTCODE1");
		ia.setAddressline1("False Street number 123");
		ia.setAddressline2("Springfield");
		ia.setCounty("Someplace");
		ia.setWhat3words("Homer");
		
		IrelandAddressWhat3WordsModel iam = irelandAddressConverter.entity2WWmodel(ia);
		
		assertNotNull(iam);
		assertEquals(ia.getPostcode(), iam.getPostcode());
		assertEquals(ia.getAddressline1(), iam.getAddressline1());
		assertEquals(ia.getAddressline2(), iam.getAddressline2());
		assertEquals(ia.getCounty(), iam.getCounty());
		assertEquals(ia.getWhat3words(), iam.getWhat3words());
	}
	
	@Test
	public void testModel2EntityConversion(){
		AddressModel iam = new AddressModel();
		iam.setPostcode("POSTCODE1");
		iam.setAddressline1("False Street number 123");
		iam.setAddressline2("Springfield");
		iam.setCounty("Someplace");
		
		IrelandAddress ia = irelandAddressConverter.model2entity(iam);
		
		assertNotNull(iam);
		assertEquals(ia.getPostcode(), iam.getPostcode());
		assertEquals(ia.getAddressline1(), iam.getAddressline1());
		assertEquals(ia.getAddressline2(), iam.getAddressline2());
		assertEquals(ia.getCounty(), iam.getCounty());

	}
	
	@Test
	public void testCoordinateLookupModel2EntityConversion(){
		IrelandAddressCoordinateLookupModel iam = new IrelandAddressCoordinateLookupModel();
		iam.setPostcode("POSTCODE1");
		iam.setAddressline1("False Street number 123");
		iam.setAddressline2("Springfield");
		iam.setCounty("Someplace");
		iam.setLatitude("1");
		iam.setLongitude("2");
		
		IrelandAddress ia = irelandAddressConverter.model2entity(iam);
		
		assertNotNull(iam);
		assertEquals(ia.getPostcode(), iam.getPostcode());
		assertEquals(ia.getAddressline1(), iam.getAddressline1());
		assertEquals(ia.getAddressline2(), iam.getAddressline2());
		assertEquals(ia.getCounty(), iam.getCounty());
		assertEquals(ia.getLatitude(), iam.getLatitude());
		assertEquals(ia.getLongitude(), iam.getLongitude());
	}
	
	@Test
	public void testWhat3WordsModel2EntityConversion(){
		IrelandAddressWhat3WordsModel iam = new IrelandAddressWhat3WordsModel();
		iam.setPostcode("POSTCODE1");
		iam.setAddressline1("False Street number 123");
		iam.setAddressline2("Springfield");
		iam.setCounty("Someplace");
		iam.setWhat3words("Homer");
		
		IrelandAddress ia = irelandAddressConverter.model2entity(iam);
		
		assertNotNull(iam);
		assertEquals(ia.getPostcode(), iam.getPostcode());
		assertEquals(ia.getAddressline1(), iam.getAddressline1());
		assertEquals(ia.getAddressline2(), iam.getAddressline2());
		assertEquals(ia.getCounty(), iam.getCounty());
		assertEquals(ia.getWhat3words(), iam.getWhat3words());

	}
	
}

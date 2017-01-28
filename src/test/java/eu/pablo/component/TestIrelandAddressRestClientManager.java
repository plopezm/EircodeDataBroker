package eu.pablo.component;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import eu.pablo.model.IrelandAddressCoordinateLookupModel;
import eu.pablo.model.IrelandAddressModel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestIrelandAddressRestClientManager {
	private static final String TEST_POSTCODE = "D02X285";
	private static final String IRELAND_API_KEY = "PCW45-12345-12345-1234X";
	
	@Autowired
	@Qualifier("irelandAddressRestClientManager")
	private IrelandAddressRestClientManager irelandAddressRestClientManager;
	
	@Test
	public void testGetIrlandAddressModel(){
		ResponseEntity<IrelandAddressModel[]> re = irelandAddressRestClientManager.getIrlandAddressModel(IRELAND_API_KEY, TEST_POSTCODE, "json");
		assertNotNull(re);
		IrelandAddressModel[] iams = re.getBody();
		assertNotNull(iams);
		assertEquals(1, iams.length);
		assertEquals(TEST_POSTCODE, iams[0].getPostcode());
	}
	
	@Test
	public void testGetIrlandCoordAddressModel(){
		ResponseEntity<IrelandAddressCoordinateLookupModel[]> re = irelandAddressRestClientManager.getIrlandCoordinateAddressModel(IRELAND_API_KEY, TEST_POSTCODE, "json");
		assertNotNull(re);
		IrelandAddressCoordinateLookupModel[] iams = re.getBody();
		assertNotNull(iams);
		assertEquals(1, iams.length);
		assertEquals(TEST_POSTCODE, iams[0].getPostcode());
		assertNotNull(iams[0].getLatitude());
		assertNotNull(iams[0].getLongitude());

	}
	
	
	

}

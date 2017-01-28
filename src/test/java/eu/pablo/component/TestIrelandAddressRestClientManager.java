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

	@Autowired
	@Qualifier("irelandAddressRestClientManager")
	private IrelandAddressRestClientManager irelandAddressRestClientManager;
	
	@Test
	public void testGetIrlandAddressModel(){
		ResponseEntity<IrelandAddressModel[]> re = irelandAddressRestClientManager.getIrlandAddressModel("D02X285", "json");
		assertNotNull(re);
		IrelandAddressModel[] iams = re.getBody();
		assertNotNull(iams);
		assertEquals(1, iams.length);
		assertEquals("D02X285", iams[0].getPostcode());
	}
	
	@Test
	public void testGetIrlandCoordAddressModel(){
		ResponseEntity<IrelandAddressCoordinateLookupModel[]> re = irelandAddressRestClientManager.getIrlandCoordinateAddressModel("D02X285", "json");
		assertNotNull(re);
		IrelandAddressCoordinateLookupModel[] iams = re.getBody();
		assertNotNull(iams);
		assertEquals(1, iams.length);
		assertEquals("D02X285", iams[0].getPostcode());
		assertNotNull(iams[0].getLatitude());
		assertNotNull(iams[0].getLongitude());

	}
	
	
	

}

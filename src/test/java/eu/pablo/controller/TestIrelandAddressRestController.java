package eu.pablo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import eu.pablo.model.IrelandAddressModel;
import eu.pablo.service.IrelandAddressService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestIrelandAddressRestController {

	private static final String IRELAND_API_KEY = "PCWR4-5BCKC-9SDCS-3YK23";
	private static final String TEST_POSTCODE = "D02X285";
	private static final String TEST_POSTCODE_NOT_FOUND = "IM_SURE_THIS_DOESNOT_EXIST";
	
	@Autowired
    private IrelandAddressRestController irelandAddressRestController;
	
	@Autowired
	@Qualifier("irelandAddressServiceImpl")
	private IrelandAddressService irelandAddressService;
	
	@Autowired
    private TestRestTemplate restTemplate;
	
	@LocalServerPort
    private int port;

    @Test
    public void contexLoads() throws Exception {
        assertThat(irelandAddressRestController).isNotNull();
    }
    
	@Test
	public void testFetchIrelandAddressModelNotFound() {
		ResponseEntity<IrelandAddressModel> re = this.restTemplate.getForEntity("http://localhost:" + port + "/pcw/"+IRELAND_API_KEY+"/address/ie/"+TEST_POSTCODE_NOT_FOUND+"?format=json",
				IrelandAddressModel.class);
		assertEquals(HttpStatus.NOT_FOUND, re.getStatusCode());
	}
	
	@Test
	public void testFetchIrelandAddressModel() {
		IrelandAddressModel iam = new IrelandAddressModel();
		iam.setPostcode(TEST_POSTCODE);
		iam.setAddressline1("False Street number 123");
		
		assertThat(irelandAddressService.insertIrelandAddress(iam)).isNotNull();
		
		ResponseEntity<IrelandAddressModel> re = this.restTemplate.getForEntity("http://localhost:" + port + "/pcw/"+IRELAND_API_KEY+"/address/ie/"+TEST_POSTCODE+"?format=json",
				IrelandAddressModel.class);
		
		assertThat(re).isNotNull();
		assertEquals(HttpStatus.OK, re.getStatusCode());
		assertEquals(iam.getPostcode(), re.getBody().getPostcode());
	}
	

}

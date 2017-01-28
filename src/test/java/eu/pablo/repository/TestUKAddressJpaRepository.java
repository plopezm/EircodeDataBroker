package eu.pablo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import eu.pablo.entity.UKAddress;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestUKAddressJpaRepository {

	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private UKAddressJpaRepository ukaAddressJpaRepository;
	
	@Test
	public void testJpaRepositoryFindAll() {
		UKAddress uka = new UKAddress();
		
		uka.setPostcode("POSTCODE1");
		uka.setAddressline1("False Street number 123");
		
		entityManager.persist(uka);
		
		assertEquals(1, ukaAddressJpaRepository.findAll().size());		
	}
	
	@Test
	public void testJpaRepositoryFindByPostCode() {
		UKAddress uka = new UKAddress();
		
		uka.setPostcode("POSTCODE1");
		uka.setAddressline1("False Street number 123");
		
		entityManager.persist(uka);
		
		assertEquals(uka.getAddressline1(),ukaAddressJpaRepository.findByPostcode("POSTCODE1").getAddressline1());	
	}
	
	@Test
	public void testJpaRepositoryFindByPostCodeNotFound() {
		UKAddress uka = new UKAddress();
		
		uka.setPostcode("POSTCODE1");
		uka.setAddressline1("False Street number 123");
		
		entityManager.persist(uka);
		
		assertNull(null,ukaAddressJpaRepository.findByPostcode("POSTCODE2"));	
	}
	
	@Test
	public void testJpaRepositoryInsertNewIrlandAddress() {

		UKAddress uka = new UKAddress();
		
		uka.setPostcode("POSTCODE1");
		uka.setAddressline1("False Street number 123");
		
		entityManager.persist(uka);
		
		assertEquals(uka.getAddressline1(),ukaAddressJpaRepository.findByPostcode("POSTCODE1").getAddressline1());	
	}
	
	@Test
	public void testJpaRepositoryRemoveNewIrlandAddress() {
		UKAddress uka = new UKAddress();
		
		uka.setPostcode("POSTCODE1");
		uka.setAddressline1("False Street number 123");
		
		ukaAddressJpaRepository.save(uka);
		
		assertEquals(uka.getAddressline1(),ukaAddressJpaRepository.findByPostcode("POSTCODE1").getAddressline1());	
		
		int res = ukaAddressJpaRepository.deleteByPostcode(uka.getPostcode());
		
		assertEquals(1, res);
		assertNull(ukaAddressJpaRepository.findByPostcode("POSTCODE1"));
	}

}

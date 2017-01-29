package eu.pablo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import eu.pablo.entity.IrelandAddress;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestIrelandAddressJpaRepository {

	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private IrelandAddressJpaRepository irelandAddressJpaRepository;
	
	@Test
	public void testJpaRepositoryFindAll() {
		IrelandAddress ia = new IrelandAddress();
		
		ia.setPostcode("POSTCODE1");
		ia.setAddressline1("False Street number 123");
		
		entityManager.persist(ia);
		
		assertEquals(1, irelandAddressJpaRepository.findAll().size());		
	}
	
	@Test
	public void testJpaRepositoryFindByPostCode() {
		IrelandAddress ia = new IrelandAddress();
		
		ia.setPostcode("POSTCODE1");
		ia.setAddressline1("False Street number 123");
		
		entityManager.persist(ia);
		
		assertEquals(ia.getAddressline1(),irelandAddressJpaRepository.findOneByPostcode("POSTCODE1").getAddressline1());	
	}
	
	@Test
	public void testJpaRepositoryFindByPostCodeNotFound() {
		IrelandAddress ia = new IrelandAddress();
		
		ia.setPostcode("POSTCODE1");
		ia.setAddressline1("False Street number 123");
		
		entityManager.persist(ia);
		
		assertNull(null,irelandAddressJpaRepository.findOneByPostcode("POSTCODE2"));	
	}
	
	@Test
	public void testJpaRepositoryInsertNewIrlandAddress() {
		IrelandAddress ia = new IrelandAddress();
		
		ia.setPostcode("POSTCODE1");
		ia.setAddressline1("False Street number 123");
		
		irelandAddressJpaRepository.save(ia);
		
		assertEquals(ia.getAddressline1(),irelandAddressJpaRepository.findOneByPostcode("POSTCODE1").getAddressline1());	
	}

	@Test
	public void testJpaRepositoryRemoveNewIrlandAddressByPostCode() {
		IrelandAddress ia = new IrelandAddress();
		
		ia.setPostcode("POSTCODE1");
		ia.setAddressline1("False Street number 123");
		
		irelandAddressJpaRepository.save(ia);
		
		assertEquals(ia.getAddressline1(),irelandAddressJpaRepository.findOneByPostcode("POSTCODE1").getAddressline1());	
		
		int res = irelandAddressJpaRepository.deleteByPostcode(ia.getPostcode());
		
		assertEquals(1, res);
		assertNull(irelandAddressJpaRepository.findOneByPostcode("POSTCODE1"));
	}
	
	@Test
	public void testFindByPostcodeAndAddressline1AndAddressline2AndStreet(){
		IrelandAddress ia = new IrelandAddress();
		ia.setPostcode("POSTCODE1");
		ia.setAddressline1("False Street number 123");
		
		irelandAddressJpaRepository.save(ia);
		assertEquals(ia.getAddressline1(),irelandAddressJpaRepository.findOneByPostcode(ia.getPostcode()).getAddressline1());
		
		IrelandAddress ia1 = irelandAddressJpaRepository.findOneByPostcode(ia.getPostcode());
		IrelandAddress ia2 = irelandAddressJpaRepository.findByPostcodeAndAddressline1AndAddressline2AndStreet(ia.getPostcode(), ia.getAddressline1(), ia.getAddressline2(), ia.getStreet());
		
		assertEquals(ia1.getId(), ia2.getId());
	}
	
	@Test
	public void testJpaUpdateAddress(){
		IrelandAddress ia = new IrelandAddress();
		ia.setPostcode("POSTCODE1");
		ia.setAddressline1("False Street number 123");
		
		irelandAddressJpaRepository.save(ia);
		
		assertEquals(ia.getAddressline1(),irelandAddressJpaRepository.findOneByPostcode("POSTCODE1").getAddressline1());	

		ia.setAddressline1("False Street number 456");
		irelandAddressJpaRepository.save(ia);

		assertEquals(ia.getAddressline1(),irelandAddressJpaRepository.findOneByPostcode("POSTCODE1").getAddressline1());	
	}
	
	@Test
	public void testFindAllByPostcode(){
		IrelandAddress ia = new IrelandAddress();
		ia.setPostcode("POSTCODE1");
		ia.setAddressline1("False Street number 123");
		
		IrelandAddress ia2 = new IrelandAddress();
		ia2.setPostcode("POSTCODE1");
		ia2.setAddressline1("False Street number 1234");
		ia2.setAddressline2("Another address line");
		
		irelandAddressJpaRepository.save(ia);
		irelandAddressJpaRepository.save(ia2);
		
		List<IrelandAddress> list = irelandAddressJpaRepository.findByPostcode("POSTCODE1");
		assertEquals(2, list.size());
	}
	
}

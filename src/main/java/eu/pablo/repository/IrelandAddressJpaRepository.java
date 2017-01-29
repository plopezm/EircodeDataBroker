package eu.pablo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.pablo.entity.IrelandAddress;

@Repository("irelandAddressJpaRepository")
public interface IrelandAddressJpaRepository extends JpaRepository<IrelandAddress, Serializable>{
	public IrelandAddress findOneByPostcode(String postcode);
	public List<IrelandAddress> findByPostcode(String postcode);
	public IrelandAddress findByPostcodeAndAddressline1AndAddressline2AndStreet(String postcode, String addressline1, String addressline2, String street);
	public int deleteByPostcode(String postcode);
}

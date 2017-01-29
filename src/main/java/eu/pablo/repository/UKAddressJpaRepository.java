package eu.pablo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.pablo.entity.UKAddress;

@Repository("ukAddressJpaRepository")
public interface UKAddressJpaRepository extends JpaRepository<UKAddress, Serializable>{
	public UKAddress findByPostcode(String postcode);
	public UKAddress findByPostcodeAndAddressline1AndAddressline2AndStreet(String postcode, String addressline1, String addressline2, String street);
	public int deleteByPostcode(String postcode);
}

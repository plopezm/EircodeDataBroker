package eu.pablo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.pablo.entity.IrelandAddress;
import eu.pablo.entity.UKAddress;

@Repository("ukAddressJpaRepository")
public interface UKAddressJpaRepository extends JpaRepository<UKAddress, Serializable>{
	public UKAddress findByPostcode(String postcode);
	public int deleteByPostcode(String postcode);
}

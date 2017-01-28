package eu.pablo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.pablo.entity.IrelandAddress;

@Repository("irelandAddressJpaRepository")
public interface IrelandAddressJpaRepository extends JpaRepository<IrelandAddress, Serializable>{
	public IrelandAddress findByPostcode(String postcode);
	public int deleteByPostcode(String postcode);
}

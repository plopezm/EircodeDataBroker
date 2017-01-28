package eu.pablo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.pablo.entity.Address;

@Repository("addressJpaRepository")
public interface AddressJpaRepository extends JpaRepository<Address, Serializable>{
}

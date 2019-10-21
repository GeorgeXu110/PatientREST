package com.ainq.patientApi.repository;

import com.ainq.patientApi.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    Address findOneByAddressId(Integer id);
    boolean existsById(Integer id);

}

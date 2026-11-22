package com.webelement.flaadmin.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webelement.flaadmin.entity.BankUserEntity;

@Repository
public interface BankUserRepo extends JpaRepository<BankUserEntity, Integer> {

	List<BankUserEntity> findByBankIdAndStatusOrderByNameAsc(Integer bankId, Short status);

	Optional<BankUserEntity> findByEmailAndStatus(String email, Short status);

	boolean existsByEmailIgnoreCaseAndStatus(String email, Short status);
}

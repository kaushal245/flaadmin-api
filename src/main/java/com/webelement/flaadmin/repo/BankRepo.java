package com.webelement.flaadmin.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webelement.flaadmin.dto.BankDTO;
import com.webelement.flaadmin.entity.BankEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepo extends JpaRepository<BankEntity, Integer> {

	List<BankEntity> findByStatusOrderByNameAsc(Short status);

	List<BankEntity> findByAssociationIdAndStatusOrderByNameAsc(Integer associationId, Short status);

	List<BankEntity> findByTypeAndStatusOrderByNameAsc(Short type, Short status);

	boolean existsByNameIgnoreCaseAndAssociationIdAndStatus(String name, Integer associationId, Short status);

//	@Query(value = "SELECT new com.webelement.flaadmin.dto.BankDTO("
//			+ "b.bankId, b.type, b.associationId, b.name, b.status, b.userId, b.regDate, b.modDate, a.name) "
//			+ "FROM BankEntity b " + "LEFT JOIN AssociationEntity a ON a.id = b.associationId " + "WHERE ("
//			+ "  :search IS NULL OR :search = '' OR " + "  LOWER(b.name) LIKE LOWER(CONCAT('%', :search, '%')) OR "
//			+ "  LOWER(a.name) LIKE LOWER(CONCAT('%', :search, '%'))) "
//			+ "ORDER BY b.name ASC", countQuery = "SELECT COUNT(b) " + "FROM BankEntity b "
//					+ "LEFT JOIN AssociationEntity a ON a.id = b.associationId " + "WHERE ("
//					+ "  :search IS NULL OR :search = '' OR "
//					+ "  LOWER(b.name) LIKE LOWER(CONCAT('%', :search, '%')) OR "
//					+ "  LOWER(a.name) LIKE LOWER(CONCAT('%', :search, '%')))")
//	Page<BankDTO> findBankDetails(Pageable pageable, @Param("search") String search);

//	@Query("SELECT new com.webelement.flaadmin.dto.BankDTO("
//			+ "b.bankId, b.type, b.associationId, b.name, b.status, b.userId, b.regDate, b.modDate, a.name) "
//			+ "FROM BankEntity b LEFT JOIN AssociationEntity a ON a.id = b.associationId " + "WHERE b.bankId = :bankId")
//	Optional<BankDTO> findBankDetailsById(@Param("bankId") Integer bankId);

	@EntityGraph(attributePaths = { "association" })
	@Query(value = "SELECT b FROM BankEntity b " + "LEFT JOIN b.association a " + "WHERE ("
			+ "  :search IS NULL OR :search = '' OR " + "  LOWER(b.name) LIKE LOWER(CONCAT('%', :search, '%')) OR "
			+ "  LOWER(a.name) LIKE LOWER(CONCAT('%', :search, '%'))) " + "ORDER BY b.name ASC")
	Page<BankEntity> findBankDetails(Pageable pageable, @Param("search") String search);

	@EntityGraph(attributePaths = { "association" })
	Optional<BankEntity> findByBankId(Integer bankId);
}

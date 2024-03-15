package py.com.adetsa.db.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import py.com.adetsa.db.domain.CommerceConfigEntity;
import py.com.adetsa.exception.LotteryInvocationException;

@Repository
public interface CommerceConfigRepository extends JpaRepository<CommerceConfigEntity, Long> {

	@Query(value = "FROM CommerceConfigEntity t WHERE t.commerceCode = :commerceCode", nativeQuery = false)
	Optional<CommerceConfigEntity> findByCommerceCode(@Param("commerceCode") Long commerceCode)
			throws LotteryInvocationException;

	@Query(value = "FROM CommerceConfigEntity t WHERE t.status = :status", nativeQuery = false)
	Optional<List<CommerceConfigEntity>> findByStatus(@Param("status") String status) throws LotteryInvocationException;
}
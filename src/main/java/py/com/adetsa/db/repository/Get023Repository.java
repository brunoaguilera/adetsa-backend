package py.com.adetsa.db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import py.com.adetsa.db.domain.Get023Entity;
import py.com.adetsa.exception.LotteryInvocationException;

@Repository
public interface Get023Repository extends JpaRepository<Get023Entity, Integer> {

	@Query(value = "FROM Get023Entity t WHERE t.ge23clicod = :ge23clicod", nativeQuery = false)
	Optional<Get023Entity> findByCommerceId(@Param("ge23clicod") Long ge23clicod) throws LotteryInvocationException;

	@Query(value = "FROM Get023Entity t WHERE t.ge23cliruc = :ge23cliruc", nativeQuery = false)
	Optional<Get023Entity> findByRUC(@Param("ge23cliruc") String ge23cliruc)
			throws LotteryInvocationException;
}

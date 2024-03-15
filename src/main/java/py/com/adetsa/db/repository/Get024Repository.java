package py.com.adetsa.db.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import py.com.adetsa.db.domain.Get024Entity;
import py.com.adetsa.db.domain.Get024Id;
import py.com.adetsa.exception.LotteryInvocationException;

@Repository
public interface Get024Repository extends JpaRepository<Get024Entity, Get024Id> {

	@Query(value = "FROM Get024Entity t WHERE t.id = :id", nativeQuery = false)
	Optional<Get024Entity> findByEmbeddedId(@Param("id") Get024Id id) throws LotteryInvocationException;

	@Query(value = "FROM Get024Entity t WHERE t.id.ge23clicod = :ge23clicod", nativeQuery = false)
	Optional<List<Get024Entity>> findByCommerceId(@Param("ge23clicod") Long ge23clicod)
			throws LotteryInvocationException;

	@Query(value = "FROM Get024Entity t WHERE t.ge24codswi = :ge24codswi", nativeQuery = false)
	Optional<List<Get024Entity>> findBySWCod(@Param("ge24codswi") Long ge24codswi) throws LotteryInvocationException;

	@Query(value = "FROM Get024Entity t WHERE t.ge24cliruc = :ge24cliruc", nativeQuery = false)
	Optional<List<Get024Entity>> findByBranchRUC(@Param("ge24cliruc") String ge24cliruc)
			throws LotteryInvocationException;

	@Query(value = "FROM Get024Entity t WHERE t.ge24stspro = 'A' and t.ge24stsswi = 'A' order by id.ge23clicod asc", nativeQuery = false)
	Optional<List<Get024Entity>> findAllBranchActive();
}

package py.com.adetsa.db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import py.com.adetsa.db.domain.RoleEntity;
import py.com.adetsa.exception.LotteryInvocationException;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

	@Query(value = "FROM RoleEntity t WHERE t.name = :name", nativeQuery = false)
	Optional<RoleEntity> findByName(@Param("name") String name) throws LotteryInvocationException;
}
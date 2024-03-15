package py.com.adetsa.db.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import py.com.adetsa.db.domain.UserRoleEntity;
import py.com.adetsa.exception.LotteryInvocationException;

@Repository
public interface UsersRolesRepository extends JpaRepository<UserRoleEntity, Long> {

	@Query(value = "FROM UserRoleEntity t WHERE t.id = :id", nativeQuery = false)
	Optional<UserRoleEntity> findById(@Param("id") Long id);
	
	@Query(value = "FROM UserRoleEntity t WHERE t.userId = :userId", nativeQuery = false)
	Optional<List<UserRoleEntity>> findByUserId(@Param("userId") Long userId) throws LotteryInvocationException;
	
	@Query(value = "FROM UserRoleEntity t WHERE t.roleId = :roleId", nativeQuery = false)
	Optional<List<UserRoleEntity>> findByRoleId(@Param("roleId") Long roleId) throws LotteryInvocationException;
	
	@Modifying
	@Query(value = "DELETE UserRoleEntity WHERE userId = :userId", nativeQuery = false)
	int deleteByUserId(@Param("userId") Long userId) throws LotteryInvocationException;
}
package py.com.adetsa.db.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import py.com.adetsa.db.domain.UserEntity;
import py.com.adetsa.exception.LotteryInvocationException;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	@Query(value = "FROM UserEntity t WHERE t.username = :username", nativeQuery = false)
	Optional<UserEntity> findByUserName(@Param("username") String username) throws LotteryInvocationException;

	@Query(value = "FROM UserEntity t WHERE t.email = :email", nativeQuery = false)
	Optional<UserEntity> findByEmail(@Param("email") String email) throws LotteryInvocationException;

	Page<UserEntity> findAll(Pageable pageable);
}
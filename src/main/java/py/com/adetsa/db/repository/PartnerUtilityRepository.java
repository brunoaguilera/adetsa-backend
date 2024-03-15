package py.com.adetsa.db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.com.adetsa.db.domain.PartnerUtilityEntity;
import py.com.adetsa.exception.LotteryInvocationException;

@Repository
public interface PartnerUtilityRepository extends JpaRepository<PartnerUtilityEntity, Long> {

	@Query(value = "SELECT * FROM adetsa.partner_utility t WHERE CAST(t.partner_cod AS INTEGER) = :partnerCod", nativeQuery = true)
	Optional<PartnerUtilityEntity> findByPartnerCod(@Param("partnerCod") Long partnerCod) throws LotteryInvocationException;

	@Transactional
	@Modifying
	@Query(value = "UPDATE PartnerUtilityEntity SET withdrawMoney = :withdrawMoney WHERE partnerCod = :partnerCod", nativeQuery = false)
	int updateWithdrawMoney(@Param("partnerCod") String partnerCod, @Param("withdrawMoney") String withdrawMoney);
}
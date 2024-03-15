package py.com.adetsa.db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.com.adetsa.db.domain.PartnerEntity;
import py.com.adetsa.exception.LotteryInvocationException;

@Repository
public interface PartnerRepository extends JpaRepository<PartnerEntity, Long> {

	@Query(value = "SELECT * FROM adetsa.partners t WHERE CAST(t.partner_cod AS INTEGER) = :partnerCod", nativeQuery = true)
	Optional<PartnerEntity> findByPartnerCod(@Param("partnerCod") Long partnerCod)
			throws LotteryInvocationException;

	@Transactional
	@Modifying
	@Query(value = "UPDATE PartnerEntity SET partnerCodVoto = :partnerCodVoto, voto = 'S' WHERE partnerCod = :partnerCod", nativeQuery = false)
	int updateVoto(@Param("partnerCod") String partnerCod, @Param("partnerCodVoto") String partnerCodVoto);

	@Transactional
	@Modifying
	@Query(value = "UPDATE PartnerEntity SET partnerCodVoto = null, voto = 'X' WHERE partnerCodVoto = :partnerCodVoto", nativeQuery = false)
	int updateNullVotados(@Param("partnerCodVoto") String partnerCodVoto);

	@Query(value = "SELECT sum(1) FROM adetsa.partners t WHERE CAST(t.partner_cod_voto AS INTEGER) = :partnerCodVoto", nativeQuery = true)
	Long sumVotosByPartnerCod(@Param("partnerCodVoto") Long partnerCodVoto);
}
package py.com.adetsa.db.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.com.adetsa.db.domain.PartnerCandidatosEntity;
import py.com.adetsa.exception.LotteryInvocationException;

@Repository
public interface PartnerCandidatosRepository extends JpaRepository<PartnerCandidatosEntity, String> {

	@Query(value = "SELECT * FROM adetsa.partners_candidatos t WHERE CAST(t.partner_cod AS INTEGER) = :partnerCod", nativeQuery = true)
	Optional<PartnerCandidatosEntity> findByPartnerCod(@Param("partnerCod") Long partnerCod)
			throws LotteryInvocationException;

	@Query(value = "SELECT * FROM adetsa.partners_candidatos t order by partner_cod asc", nativeQuery = true)
	List<PartnerCandidatosEntity> findAllCandidatos() throws LotteryInvocationException;

	@Transactional
	@Modifying
	@Query(value = "insert into adetsa.partners_candidatos (partner_cod) values (:partnerCod)", nativeQuery = true)
	int insertaCandidato(@Param("partnerCod") String partnerCod);

	@Transactional
	@Modifying
	@Query(value = "delete from adetsa.partners_candidatos where partner_cod = :partnerCod", nativeQuery = true)
	int deleteCandidato(@Param("partnerCod") String partnerCod);
}
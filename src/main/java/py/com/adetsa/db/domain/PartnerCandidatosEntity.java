package py.com.adetsa.db.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "partners_candidatos", schema = "adetsa")
public class PartnerCandidatosEntity {

	@Id
	@Column(name = "partner_cod")
	public String partnerCod;


	public String getPartnerCod() {
		return partnerCod;
	}

	public void setPartnerCod(String partnerCod) {
		this.partnerCod = partnerCod;
	}

	@Override
	public String toString() {
		return "PartnerCandidatosEntity [partnerCod=" + partnerCod + "]";
	}
}
package py.com.adetsa.db.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "partners", schema = "adetsa")
public class PartnerEntity {

	@Id
	@Column(name = "id")
	public Long id;

	@Column(name = "partner_cod")
	public String partnerCod;

	@Column(name = "full_name")
	public String partnerName;

	@Column(name = "ruc")
	public String ruc;

	@Column(name = "voto")
	public String voto;

	@Column(name = "status")
	public String status;

	@Column(name = "partner_cod_voto")
	public String partnerCodVoto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPartnerCod() {
		return partnerCod;
	}

	public void setPartnerCod(String partnerCod) {
		this.partnerCod = partnerCod;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getVoto() {
		return voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPartnerCodVoto() {
		return partnerCodVoto;
	}

	public void setPartnerCodVoto(String partnerCodVoto) {
		this.partnerCodVoto = partnerCodVoto;
	}

	@Override
	public String toString() {
		return "PartnerEntity [id=" + id + ", partnerCod=" + partnerCod + ", partnerName=" + partnerName + ", ruc="
				+ ruc + ", voto=" + voto + ", status=" + status + ", partnerCodVoto=" + partnerCodVoto + "]";
	}
}
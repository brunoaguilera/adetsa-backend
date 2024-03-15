package py.com.adetsa.db.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "get023", schema = "adetsa")
public class Get023Entity implements Serializable {
	private static final long serialVersionUID = 7261236819626502760L;

	@Id
	@Column(name = "ge23clicod")
	private Long ge23clicod;

	@Column(name = "ge23clinom")
	private String ge23clinom;

	@Column(name = "ge23fhoupd")
	private Date ge23fhoupd;

	@Column(name = "ge23usuupd")
	private String ge23usuupd;

	@Column(name = "ge45ticcli")
	private String ge45ticcli;

	@Column(name = "ge25ecogru")
	private String ge25ecogru;

	@Column(name = "ge23pjid")
	private Integer ge23pjid;

	@Column(name = "ge23cliruc")
	private String ge23cliruc;

	@Column(name = "ge23ultsuc")
	private Integer ge23ultsuc;

	@Column(name = "ge23rubid")
	private Integer ge23rubid;

	@Column(name = "ge23mercod")
	private Integer ge23mercod;

	@Column(name = "ge23agrext")
	private String ge23agrext;

	public Long getGe23clicod() {
		return ge23clicod;
	}

	public void setGe23clicod(Long ge23clicod) {
		this.ge23clicod = ge23clicod;
	}

	public String getGe23clinom() {
		return ge23clinom;
	}

	public void setGe23clinom(String ge23clinom) {
		this.ge23clinom = ge23clinom;
	}

	public Date getGe23fhoupd() {
		return ge23fhoupd;
	}

	public void setGe23fhoupd(Date ge23fhoupd) {
		this.ge23fhoupd = ge23fhoupd;
	}

	public String getGe23usuupd() {
		return ge23usuupd;
	}

	public void setGe23usuupd(String ge23usuupd) {
		this.ge23usuupd = ge23usuupd;
	}

	public String getGe45ticcli() {
		return ge45ticcli;
	}

	public void setGe45ticcli(String ge45ticcli) {
		this.ge45ticcli = ge45ticcli;
	}

	public String getGe25ecogru() {
		return ge25ecogru;
	}

	public void setGe25ecogru(String ge25ecogru) {
		this.ge25ecogru = ge25ecogru;
	}

	public Integer getGe23pjid() {
		return ge23pjid;
	}

	public void setGe23pjid(Integer ge23pjid) {
		this.ge23pjid = ge23pjid;
	}

	public String getGe23cliruc() {
		return ge23cliruc;
	}

	public void setGe23cliruc(String ge23cliruc) {
		this.ge23cliruc = ge23cliruc;
	}

	public Integer getGe23ultsuc() {
		return ge23ultsuc;
	}

	public void setGe23ultsuc(Integer ge23ultsuc) {
		this.ge23ultsuc = ge23ultsuc;
	}

	public Integer getGe23rubid() {
		return ge23rubid;
	}

	public void setGe23rubid(Integer ge23rubid) {
		this.ge23rubid = ge23rubid;
	}

	public Integer getGe23mercod() {
		return ge23mercod;
	}

	public void setGe23mercod(Integer ge23mercod) {
		this.ge23mercod = ge23mercod;
	}

	public String getGe23agrext() {
		return ge23agrext;
	}

	public void setGe23agrext(String ge23agrext) {
		this.ge23agrext = ge23agrext;
	}

	@Override
	public String toString() {
		return "Get024Entity [ge23clicod=" + ge23clicod + ", ge23clinom=" + ge23clinom + ", ge23fhoupd=" + ge23fhoupd
				+ ", ge23usuupd=" + ge23usuupd + ", ge45ticcli=" + ge45ticcli + ", ge25ecogru=" + ge25ecogru
				+ ", ge23pjid=" + ge23pjid + ", ge23cliruc=" + ge23cliruc + ", ge23ultsuc=" + ge23ultsuc
				+ ", ge23rubid=" + ge23rubid + ", ge23mercod=" + ge23mercod + ", ge23agrext=" + ge23agrext + "]";
	}
}
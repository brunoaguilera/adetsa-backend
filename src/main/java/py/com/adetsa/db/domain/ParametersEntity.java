package py.com.adetsa.db.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entidad que representa un parametro.
 */

@Entity
@Table(name = "parameters", schema = "adetsa")
public class ParametersEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "parameters_id_seq")
	@SequenceGenerator(name = "parameters_id_seq", sequenceName = "lottery.parameters_id_seq", schema = "lottery", initialValue = 1, allocationSize = 1)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;

	@Basic
	@Column(name = "description")
	private String description;

	@Basic
	@Column(name = "code")
	private String code;
	
	@Column(name = "value")
	private String value;
	
	@Column(name = "status")
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ParametersEntity [id=" + id + ", description=" + description + ", code=" + code + ", value=" + value
				+ ", status=" + status + "]";
	}	
}
package py.com.adetsa.db.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Get024Id implements Serializable {

	private static final long serialVersionUID = -4403909934954144068L;
	
	@Column(name = "ge23clicod")
	private Long ge23clicod;
	@Column(name = "ge24clisuc")
	private Long ge24clisuc;

	public Get024Id() {
		super();
	}

	public Get024Id(Long ge23clicod, Long ge24clisuc) {
		super();
		this.ge23clicod = ge23clicod;
		this.ge24clisuc = ge24clisuc;
	}

	public Long getGe23clicod() {
		return ge23clicod;
	}

	public void setGe23clicod(Long ge23clicod) {
		this.ge23clicod = ge23clicod;
	}

	public Long getGe24clisuc() {
		return ge24clisuc;
	}

	public void setGe24clisuc(Long ge24clisuc) {
		this.ge24clisuc = ge24clisuc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ge24clisuc == null) ? 0 : ge24clisuc.hashCode());
		result = prime * result + ((ge23clicod == null) ? 0 : ge23clicod.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Get024Id other = (Get024Id) obj;
		if (ge24clisuc == null) {
			if (other.ge24clisuc != null)
				return false;
		} else if (!ge24clisuc.equals(other.ge24clisuc))
			return false;
		if (ge23clicod == null) {
			if (other.ge23clicod != null)
				return false;
		} else if (!ge23clicod.equals(other.ge23clicod))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Get024Id [ge23clicod=" + ge23clicod + ", ge24clisuc=" + ge24clisuc + "]";
	}
}
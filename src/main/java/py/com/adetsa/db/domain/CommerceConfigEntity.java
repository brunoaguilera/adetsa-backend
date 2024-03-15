package py.com.adetsa.db.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "commerce_config", schema = "adetsa")
public class CommerceConfigEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "commerce_config_id_seq")
	@SequenceGenerator(name = "commerce_config_id_seq", sequenceName = "adetsa.commerce_config_id_seq", schema = "adetsa", initialValue = 1, allocationSize = 1)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;

	@Column(name = "commerce_code")
	private Long commerceCode;

	@Column(name = "main_color")
	private String mainColor;

	@Column(name = "secondary_color")
	private String secondaryColor;

	@Column(name = "logo1")
	private byte[] logo1;

	@Column(name = "logo2")
	private byte[] logo2;

	@Column(name = "background_image")
	private byte[] backgroundImage;

	@Column(name = "created_at", updatable = false, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date createdAt;

	@Column(name = "status")
	private String status;

	@Column(name = "date_update")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	@Column(name = "user_update_id")
	private Long userUpdateId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCommerceCode() {
		return commerceCode;
	}

	public void setCommerceCode(Long commerceCode) {
		this.commerceCode = commerceCode;
	}

	public String getMainColor() {
		return mainColor;
	}

	public void setMainColor(String mainColor) {
		this.mainColor = mainColor;
	}

	public String getSecondaryColor() {
		return secondaryColor;
	}

	public void setSecondaryColor(String secondaryColor) {
		this.secondaryColor = secondaryColor;
	}

	public byte[] getLogo1() {
		return logo1;
	}

	public void setLogo1(byte[] logo1) {
		this.logo1 = logo1;
	}

	public byte[] getLogo2() {
		return logo2;
	}

	public void setLogo2(byte[] logo2) {
		this.logo2 = logo2;
	}

	public byte[] getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(byte[] backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public Long getUserUpdateId() {
		return userUpdateId;
	}

	public void setUserUpdateId(Long userUpdateId) {
		this.userUpdateId = userUpdateId;
	}

	@Override
	public String toString() {
		return "CommerceConfigEntity [id=" + id + ", commerceCode=" + commerceCode + ", mainColor=" + mainColor
				+ ", secondaryColor=" + secondaryColor + ", createdAt=" + createdAt + ", status=" + status
				+ ", dateUpdate=" + dateUpdate + ", userUpdateId=" + userUpdateId + "]";
	}
}
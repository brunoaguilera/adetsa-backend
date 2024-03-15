package py.com.adetsa.db.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users_roles", schema = "adetsa")
public class UserRoleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "users_roles_id_seq")
	@SequenceGenerator(name = "users_roles_id_seq", sequenceName = "adetsa.users_roles_id_seq", schema = "adetsa", initialValue = 1, allocationSize = 1)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;

	@Column(name = "user_id", unique = true)
	private Long userId;

	@Column(name = "role_id", unique = true)
	private Long roleId;
	
	public UserRoleEntity(Long userId, Long roleId) {
		super();
		this.userId = userId;
		this.roleId = roleId;
	}
	
	public UserRoleEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "UserRoleEntity [id=" + id + ", userId=" + userId + ", roleId=" + roleId + "]";
	}
}
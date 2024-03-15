package py.com.adetsa.db.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users", schema = "adetsa")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "users_id_seq")
	@SequenceGenerator(name = "users_id_seq", sequenceName = "adetsa.users_id_seq", schema = "adetsa", initialValue = 1, allocationSize = 1)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;

	@NotBlank
	@Size(min = 4, max = 8)
	@Column(name = "username", unique = true)
	private String username;

	@NotBlank
	@Column(name = "password")
	private String password;

	@NotEmpty
	@Email
	@Column(name = "email", unique = true)
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + "]";
	}
}
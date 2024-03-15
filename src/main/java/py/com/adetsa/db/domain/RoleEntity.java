package py.com.adetsa.db.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "roles", schema = "adetsa")
public class RoleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "roles_id_seq")
	@SequenceGenerator(name = "roles_id_seq", sequenceName = "adetsa.roles_id_seq", schema = "adetsa", initialValue = 1, allocationSize = 1)
	@Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(unique = true)
    private String name;
    
    
    public RoleEntity() {
    }
    
    public RoleEntity(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}

    
}

package egzaminas.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Login", uniqueConstraints = @UniqueConstraint(columnNames = {"login"}))

public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String login;
	private String role;
	private String password;
	
		
	public Login() {
	
	}

	public Login(String login, String role, String password) {
		this.login = login;
		this.role = role;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
}

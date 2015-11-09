package ie.cit.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@JsonIgnoreProperties(ignoreUnknown=true)
public class Role {
	
	@Id
	@Column
	private Integer role_id;
	@Column
	private String role_name;
	@Column
	private String role_display_name;
	@Column
	private String role_url;
	
	public Role(){}
	public Role(Integer role_id, String role_name, String role_display_name, String role_url) {
		this.role_id = role_id;
		this.role_name = role_name;
		this.role_display_name = role_display_name;
		this.role_url = role_url;
	}
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_name=" + role_name + ", role_display_name=" + role_display_name
				+ ", role_url=" + role_url + "]";
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_display_name() {
		return role_display_name;
	}
	public void setRole_display_name(String role_display_name) {
		this.role_display_name = role_display_name;
	}
	public String getRole_url() {
		return role_url;
	}
	public void setRole_url(String role_url) {
		this.role_url = role_url;
	}
	

}

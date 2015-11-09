package ie.cit.domain;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@JsonIgnoreProperties(ignoreUnknown=true)
public class Participant {
	
	@Id
	@Column
	private Integer person_id;
	@Column
	private String person_name;
	@Column
	private String person_date;
	@Column
	private String person_url;
	
	public Participant() {}
	public Participant(Integer person_id, String person_name, String person_date, String person_url) {
		
		this.person_id = person_id;
		this.person_name = person_name;
		this.person_date = person_date;
		this.person_url = person_url;
	}
	@Override
	public String toString() {
		return "Participant [person_id=" + person_id + ", person_name=" + person_name + ", person_date=" + person_date
				+ ", person_url=" + person_url + "]";
	}
	
	public Integer getPerson_id() {
		return person_id;
	}
	public void setPerson_id(Integer person_id) {
		this.person_id = person_id;
	}
	public String getPerson_name() {
		return person_name;
	}
	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}
	public String getPerson_date() {
		return person_date;
	}
	public void setPerson_date(String person_date) {
		this.person_date = person_date;
	}
	public String getPerson_url() {
		return person_url;
	}
	public void setPerson_url(String person_url) {
		this.person_url = person_url;
	}

}

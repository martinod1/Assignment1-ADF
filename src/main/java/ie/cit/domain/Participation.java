package ie.cit.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
@JsonIgnoreProperties(ignoreUnknown=true)
@Entity
@Table
public class Participation {
	
	@Transient
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="person_id")
	@JsonUnwrapped
	private Participant participant;
	
	@Transient
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="role_id")
	@JsonUnwrapped
	private Role role;
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer participation_id;

	//mappedBy="person_id") (name="person_id")
	//@OneToOne(mappedBy="person_id")
	//@JoinColumn
	@Column
	private Integer participant_id;
	@Column
	private Integer role_id;
	@Column
	private Integer chobject_id;
	
	@Override
	public String toString() {
		return "Participation [participant=" + participant + ", role=" + role + ", participation_id=" + participation_id
				+ ", participant_id=" + participant_id + ", role_id=" + role_id + "]";
	}
	public Participation(){}
	
	public Participation(Participant participant, Role role, Integer participation_id, Integer participant_id, Integer role_id) {
		super();
		this.participant = participant;
		this.role = role;
		this.participation_id = participation_id;
		this.participant_id = participant_id;
		this.role_id = role_id;
	}
	public Participant getParticipant() {
		return participant;
	}
	public void setParticipant(Participant participant) {
		this.participant = participant;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Integer getParticipation_id() {
		return participation_id;
	}
	public void setParticipation_id(Integer participation_id) {
		this.participation_id = participation_id;
	}
	public Integer getParticipant_id() {
		return participant_id;
	}
	public void setParticipant_id(Integer participant_id) {
		this.participant_id = participant_id;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public Integer getChobject_id() {
		return chobject_id;
	}
	public void setChobject_id(Integer chobject_id) {
		this.chobject_id = chobject_id;
	}

	
	

}

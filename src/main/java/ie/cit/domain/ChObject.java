package ie.cit.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

//
//import javax.persistence.*;
//import javax.persistence.Entity;
//import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
//import org.hibernate.annotations.CascadeType;

//import org.hibernate.annotations.*;
//import org.hibernate.annotations.
//import org.hibernate.Hibernate;
import ie.cit.domain.Image;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
@Entity
@Table(name="chObject")
public class ChObject implements Serializable{
	
	
	private long id;
	
	//annotations from attempting to modify the code so that the objects would be saved in a cascading manner
	//i.e. chobject -> saves images + participations -> saves roles + participants
	//@ElementCollection
	//@OneToMany(mappedBy="chobj", cascade=CascadeType.ALL, orphanRemoval=true)
	//@JoinColumn(name="chobject_id")
	@Transient
	private List<Participation> participants;;
	
	/*@Transient
	private Set<Image> imageSet;*/
	
	@Column
	private Integer object_id;
	@Column
	private String title;
	@Column
	private String date;
	
	@Column
	private String creditline;
	@Column
	private String description;
	@Column
	private String gallery_text;
	
	@Column 
	private String medium;
	
	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		if(medium!=null)
		{
			this.medium = medium;
		}
		else
			this.medium="";
	}

	@Id
	@Column
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	
/*	@Transient
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="object_image",
			joinColumns = {@JoinColumn(name="object_id", unique=true)},
			inverseJoinColumns=@JoinColumn(name="image_id"))
	public Set<Image> getImageSet() {
		return imageSet;
	}
	@Transient
	public void setImageSet(Set<Image> imageSet) {
		this.imageSet = imageSet;
	}*/

	

	@Transient
	private List<Map<String, Image>> images;

	

	public ChObject() {}
	
	//List<Map<String, Image>> images
	
	public ChObject(long id,Integer object_id, String medium,String title, String date, String creditline, String description, String gallery_text, List<Participation> participants, ArrayList<Map<String, Image>> images) {
		this.id=id;
		this.object_id = object_id;
		this.title = title;
		this.date = date;
		this.creditline = creditline;
		this.description = description;
		this.gallery_text = gallery_text;
		this.images=images;
		this.medium=medium;
		this.participants=participants;
		//this.images=images;
	}


//	@Override
//	public String toString() {
//		return "Exhibit [id=" + id + ", title=" + title + ", date=" + date + ", creditline=" + creditline
//				+ ", description=" + description + ", gallery_text=" + gallery_text + ", participants=" + participants
//				+ ",\n images=" + images + "]";
//	}
//	


	
	public Integer getObject_id() {
		return object_id;
	}

	
	
	
	public void setObject_id(Integer object_id) {
		this.object_id = object_id;
	}


	

	public String getTitle() {
		return title;
	}

	//", imageSet=" + imageSet +
	@Override
	public String toString() {
		return "ChObject [id=" + id + ", participants=" + participants +  ", object_id="
				+ object_id + ", title=" + title + ", date=" + date + ", creditline=" + creditline + ", description="
				+ description + ", gallery_text=" + gallery_text + ", medium=" + medium + ", images=" + images + "]";
	}

	public void setTitle(String title) {
		if(title!=null)
		{
			this.title = title;
		}
		else
			this.title="";
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		if(date!=null)
		{
			this.date = date;
		}
		else
			this.date="";
	}
	
	public String getCreditline() {
		return creditline;
	}

	public void setCreditline(String creditline) {
		if(creditline!=null)
		{
			this.creditline = creditline;
		}
		else
			this.creditline="";
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if(description!=null)
		{
			this.description = description;
		}
		else
			this.description="";
	}
	
	public String getGallery_text() {
		return gallery_text;
	}

	public void setGallery_text(String gallery_text) {
		if(gallery_text!=null)
		{
			this.gallery_text = gallery_text;
		}
		else
			this.gallery_text="";
	}

//	public Image getImage() {
//		return image;
//	}
//
//	public void setImage(Image image) {
//		this.image = image;
//	}
	@Transient
	public List<Participation> getParticipants() {
		return participants;
	}
	@Transient
	public void setParticipants(List<Participation> participants) {
		this.participants = participants;
	}
////
	//@OneToMany(cascade=CascadeType.ALL, mappedBy="ChObject")
//	@OneToMany(cascade=CascadeType.ALL, targetEntity=ie.cit.domain.Image.class )
//	@MapKeyColumn(name = "keyVal")
//	@ElementCollection(targetClass=Image.class)
//	@JoinTable(
//			name="object_image",
//			joinColumns = @JoinColumn(name="image_id"))
//	@JoinColumn(name="id")
//	@Access(AccessType.PROPERTY)
	//@JoinTable(name="object_image")
	
	@Transient
	public List<Map<String, Image>> getImages() {
		return images;
	}
	@Transient
	public void setImages(List<Map<String, Image>> images) {
		this.images = images;
	}

}

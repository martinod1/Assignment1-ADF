package ie.cit.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

//
import javax.persistence.*;
//import javax.persistence.Entity;
//import javax.persistence.Table;

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
	
	@Transient
	private List<Participation> participants;
	
	@Transient
	private Set<Image> imageSet;
	
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
	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	@Id
	@Column
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	
	@Transient
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
	}

	

	@Transient
	private List<Map<String, Image>> images;
	

	//@OneToOne
	//private Image image;
	//@JoinTable
	
	//@Column(name=)
	
	//, mappedBy="ChObject"
	//@JoinTable(name="Image")
	

	//@CollectionOfElements(targetElement = Image.class)
	//@ElementCollection
	
	//, targetEntity=Map.class
	

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

	
	// ",\n images="+images+
//
//    public Long getID() {
//        return ID;
//    }
//
//    public void setID(Long ID) {
//        this.ID = ID;
//    }
	
	
	public Integer getObject_id() {
		return object_id;
	}

	/*@Override
	public String toString() {
		return "ChObject [id=" + id  + " object_id=" + object_id + ", title=" + title
				+ ", date=" + date + ", creditline=" + creditline + ", description=" + description + ", gallery_text="
				+ gallery_text + ", images=" + images + "]";
	}
*/
	
	
	public void setObject_id(Integer object_id) {
		this.object_id = object_id;
	}

/*	@Override
	public String toString() {
		return "ChObject [id=" + id + ", imageSet=" + imageSet + ", object_id=" + object_id + ", title=" + title
				+ ", date=" + date + ", creditline=" + creditline + ", description=" + description + ", gallery_text="
				+ gallery_text + ", medium = " + medium +  ", images=" + images + "]";
	}*/
	
	

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "ChObject [id=" + id + ", participants=" + participants + ", imageSet=" + imageSet + ", object_id="
				+ object_id + ", title=" + title + ", date=" + date + ", creditline=" + creditline + ", description="
				+ description + ", gallery_text=" + gallery_text + ", medium=" + medium + ", images=" + images + "]";
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getCreditline() {
		return creditline;
	}

	public void setCreditline(String creditline) {
		this.creditline = creditline;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getGallery_text() {
		return gallery_text;
	}

	public void setGallery_text(String gallery_text) {
		this.gallery_text = gallery_text;
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

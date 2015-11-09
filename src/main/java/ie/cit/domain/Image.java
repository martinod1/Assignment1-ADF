package ie.cit.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.lang.Integer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
@Table
@Entity
public class Image {
	
	//@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Id
	@Column
	private Integer id;
	
	@Column
	private String url;
	@Column
	private Integer width;
	@Column
	private Integer height;
	@Column
	private Integer is_primary;
	
	@Column
	private Integer image_id;
	
	@Transient
//	@JoinColumn(name="object_id")
	private ChObject object;
	
	@Column
	private Integer object_id;
	
	
	@Column
	private String keyVal;
	

	public Integer getObject_id() {
		return object_id;
	}
/*
	public void setObject_id(int object_id) {
		this.object_id = object_id;
	}*/

	public void setObject(ChObject object) {
		this.object = object;
	}

	@ManyToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	public ChObject getObject() {
		return object;
	}


	public Image(){}
	




	public Image(Integer id, String url, Integer width, Integer height, Integer is_primary, Integer image_id,
			Integer object_id, String keyVal) {
		super();
		this.id = id;
		this.url = url;
		this.width = width;
		this.height = height;
		this.is_primary = is_primary;
		this.image_id = image_id;
		this.object_id = object_id;
		this.keyVal = keyVal;
	}

	public String getKeyVal() {
		return keyVal;
	}

	public void setKeyVal(String keyVal) {
		this.keyVal = keyVal;
	}

	public void setObject_id(Integer id) {
		this.object_id = id;
	}

	public Integer getIs_primary() {
		return is_primary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	@Override
	public String toString() {
		return "Image [id=" + id + ", url=" + url + ", width=" + width + ", height=" + height + ", is_primary="
				+ is_primary + ", object_id=" + object_id+ ", keyVal=" + keyVal+ ", image_id=" + image_id  + "]";
	}
//+ ", object=" + object + ", object_id=" + object_id+ ", keyVal=" + keyVal
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer isIs_primary() {
		return is_primary;
	}
	public void setIs_primary(Integer is_primary) {
		this.is_primary = is_primary;
	}
	public Integer getImage_id() {
		return image_id;
	}
	public void setImage_id(Integer image_id) {
		this.image_id = image_id;
	}

//	public int getKeyVal() {
//		return keyVal;
//	}
//
//	public void setKeyVal(int keyVal) {
//		this.keyVal = keyVal;
//	}

}

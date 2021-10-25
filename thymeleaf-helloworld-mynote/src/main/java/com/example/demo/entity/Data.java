package com.example.demo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="NOTES")
public class Data {
	@GeneratedValue
	@Id
	@Column(name="NUMBER")
    private  Integer number;
	
	@Column(name="TITLE")
    private  String title;
   
    @Column(name="NOTE")
    private  String note;
    
    @Column(name="TYPE")
    private  String type;
    
    @Column(name="CATEGORY")
    private  String category;
    
    @Column(name="FIELD")
    private  String field;
    
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getTitle() {
		return title;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	
}
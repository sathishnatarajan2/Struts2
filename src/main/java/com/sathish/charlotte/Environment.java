package com.sathish.charlotte;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="Environment")
public class Environment implements Serializable {
	
	private long id;
	private String os;
	private String version;
	private String notes;

	public Environment()
	{
		super();
	}
	public Environment(long id, String os, String version, String notes)
	{
		super();
		this.id=id;
		this.os=os;
		this.version=version;
		this.notes=notes;
	}

	@Id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	
}

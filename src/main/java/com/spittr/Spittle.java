package com.spittr;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

// We are using the annotation based configuration for Hibernate here.

// The @Entity annotation represents that this POJO is an entity that can be
// persited across the database.

// The @Table annotation specifies the table name to which this entity needs to be saved.

@Entity
@Table(name="spittles")
public class Spittle {
	
	@Id
	@GeneratedValue
	private final Long id;
	
	@Column(name="message")
	private final String message;
	
	@Column(name="time")
	private final Date time;
	
	@Column(name="latitude")
	private Double latitude;
	
	@Column(name="longitude")
	private Double longitude;
	
	// Creating default constructor. Spring (or Hibernate) will be needing it
	public Spittle() {
		this(null, null, null, null);
	}
	
	public Spittle(String message, Date time)	{
		this(message, time, null, null);
	}
	
	public Spittle(String message, Date time, Double latitude, Double longitude)	{
		this.id = null;
		this.message = message;
		this.time = time;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	// Need this one temporarily to support the findOne operation in SpittleRepository 
	// until I connect this application to a database using Hibernate
	public Spittle(Long id)	{
		this.id = id;
		this.message = "Hello";
		this.time = new Date();
		this.longitude = null;
		this.latitude = null;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getMessage() {
		return message;
	}

	public Date getTime() {
		return time;
	}
	
	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "id", "time");
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, "id", "time");
	}
}

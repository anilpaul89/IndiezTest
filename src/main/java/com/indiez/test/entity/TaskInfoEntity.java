package com.indiez.test.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task_info")
public class TaskInfoEntity {

	@Id
	@Column(name = "task_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "task_name")
	private String name;

	@Column(name = "task_description")
	private String description;

	@Column(name = "task_createdby")
	private String createdBy;

	@Column(name = "task_enddate")
	private Date endDate;

	@Column(name = "task_crtTs")
	private Date crtTs;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getCrtTs() {
		return crtTs;
	}

	public void setCrtTs(Date crtTs) {
		this.crtTs = crtTs;
	}

}

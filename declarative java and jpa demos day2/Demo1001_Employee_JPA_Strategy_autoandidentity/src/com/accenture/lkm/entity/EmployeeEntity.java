package com.accenture.lkm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: EmployeeEntity
 *
 */
@Entity
@Table(name = "Employee")
public class EmployeeEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public EmployeeEntity() {
		super();
	}

	
	//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//Relies on database's auto-increment column feature
	//Database generates the primary key when the row is inserted
	//Works best with:
	//MySQL
	//SQL Server
	
	
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//	Lets the persistence provider (like Hibernate) choose the most appropriate strategy
//	Typically defaults to:
//
//	Sequence for databases supporting sequences (PostgreSQL, Oracle)
//	Identity for databases like MySQL

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employeeId;
	@Column(name = "emp_name")
	private String employeeName;
	private String role;
	private Date insertTime;
	private Double Salary;

	//setters and getters goes here

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public Double getSalary() {
		return Salary;
	}

	public void setSalary(Double salary) {
		Salary = salary;
	}

}

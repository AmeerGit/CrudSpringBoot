package com.example.employee.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "EMPLOYEE_TBL")
public class Employee {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int employeeId;
	private String employeeName;
	private int salary;
	
	@OneToMany(targetEntity = Address.class , cascade = CascadeType.ALL)
	@JoinColumn(name = "Emp_ForigenKey", referencedColumnName = "id")
	private List<Address> address;
	
	
	
	
//	public Employee() {
//		
//	}
//	public Employee(int id, int employeeId, String employeeName, int salary) {
//		super();
//		this.id = id;
//		this.employeeId = employeeId;
//		this.employeeName = employeeName;
//		this.salary = salary;
//	}
//	
//	
//	
//	@Override
//	public String toString() {
//		return "Employee [id=" + id + ", employeeId=" + employeeId + ", employeeName=" + employeeName + ", salary="
//				+ salary + ", getId()=" + getId() + ", getEmployeeId()=" + getEmployeeId() + ", getEmployeeName()="
//				+ getEmployeeName() + ", getSalary()=" + getSalary() + ", getClass()=" + getClass() + ", hashCode()="
//				+ hashCode() + ", toString()=" + super.toString() + "]";
//	}
//	
//	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public int getEmployeeId() {
//		return employeeId;
//	}
//	public void setEmployeeId(int employeeId) {
//		this.employeeId = employeeId;
//	}
//	public String getEmployeeName() {
//		return employeeName;
//	}
//	public void setEmployeeName(String employeeName) {
//		this.employeeName = employeeName;
//	}
//	public int getSalary() {
//		return salary;
//	}
//	public void setSalary(int salary) {
//		this.salary = salary;
//	}
//	public List<Address> getAddress() {
//		return address;
//	}
//	public void setAddress(List<Address> address) {
//		this.address = address;
//	}

}

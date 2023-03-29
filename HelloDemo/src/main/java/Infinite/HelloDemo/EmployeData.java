package Infinite.HelloDemo;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean
@SessionScoped
@Entity
@Table(name="employdetails")
public class EmployeData {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int empId;

	@Column(name="firstname")
	private String empFirstName;

	@Column(name="lastname")
	private String empLastName;

	@Column(name="phonenumber")
	private int empPhoneNumber;	

	public int getEmpId() {
		return empId;
	}



	public void setEmpId(int empId) {
		this.empId = empId;
	}



	public String getEmpFirstName() {
		return empFirstName;
	}



	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}



	public String getEmpLastName() {
		return empLastName;
	}



	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}



	public int getEmpPhoneNumber() {
		return empPhoneNumber;
	}



	public void setEmpPhoneNumber(int empPhoneNumber) {
		this.empPhoneNumber = empPhoneNumber;
	}



	@Override
	public String toString() {
		return "EmployeData [empId=" + empId + ", empFirstName=" + empFirstName + ", empLastName=" + empLastName
				+ ", empPhoneNumber=" + empPhoneNumber + "]";
	}



	public EmployeData(int empId, String empFirstName, String empLastName, int empPhoneNumber) {
		super();
		this.empId = empId;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empPhoneNumber = empPhoneNumber;
	}


	public EmployeData() {

	}


}


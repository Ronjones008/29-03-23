package Infinite.HelloDemo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Saaa {
	public static void main(String[] args) {
		EmployeData s=new  EmployeDataDAO().searchEmp(1);
		System.out.println(s);
	}

}

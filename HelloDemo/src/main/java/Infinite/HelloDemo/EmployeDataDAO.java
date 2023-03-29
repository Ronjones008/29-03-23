package Infinite.HelloDemo;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;



@ManagedBean(name="dao")
@SessionScoped
@RequestScoped
public class EmployeDataDAO {
	@ManagedProperty(value = "#{param['empId']}")
	private int empId;
	
	private EmployeData employeData;
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public EmployeData getEmployeData() {
		return employeData;
	}

	public void setEmployeData(EmployeData employeData) {
		this.employeData = employeData;
	}

	SessionFactory sessionFactory;

	List<EmployeData> empList = new ArrayList<>();


	public List<EmployeData> getEmpList() {
		return empList;
	}

	public void setEmpList(List<EmployeData> empList) {
		this.empList = empList;
	}





//	public String addEmploye(EmployeData e) {
//		sessionFactory = SessionHelper.getConnection();
//		Session session = sessionFactory.openSession();
//		Transaction t = session.beginTransaction();
//		session.save(e);
//		t.commit();
//		return "showEmploye";
//	}
	
	public String addEmploye(EmployeData e) {
	    sessionFactory = SessionHelper.getConnection();
	    Session session = sessionFactory.openSession();
	    Transaction t = null;
	    try {
	        t = session.beginTransaction();
	        session.save(e);
	        t.commit();
	    } catch (Exception ex) {
	        if (t != null) {
	            t.rollback();
	        }
	        ex.printStackTrace();
	        return "errorPage";
	    } finally {
	        session.close();
	    }
	    return "showEmploye";
	}


	public List<EmployeData> showEdata(){
	    sessionFactory = SessionHelper.getConnection();
	    Session session = sessionFactory.openSession();
	    Criteria cr = session.createCriteria(EmployeData.class);
	    List<EmployeData> eList = cr.list();
	    try {
	        if (eList.size()==0) {
	            System.err.println("list is empty");
	        }
	    } catch (IndexOutOfBoundsException e) {
	        System.err.println("IndexOutOfBoundsException: " + e.getMessage());
	    } catch (Exception e) {
	        System.err.println("Exception: " + e.getMessage());
	    }
	    return eList;
	}


	public List<EmployeData> searchEmploy(int empId)  {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(EmployeData.class);
		cr.add(Restrictions.eq("empId", empId));

		List<EmployeData> eList = cr.list();
		EmployeData employ =null;


		if (eList.size() >0) {
			employ = eList.get(0);
		}
	    setEmpList(eList);
	    if (employ == null) {
	        FacesMessage message = new FacesMessage("No Record Found For This EmployId");
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }

	    return null;
	}
	
	public void loadEmployeData() {
		employeData = searchEmp(empId);
	}

       public EmployeData searchEmp(int empId) {
    	   sessionFactory = SessionHelper.getConnection();
   		Session session = sessionFactory.openSession();
   		Criteria cr = session.createCriteria(EmployeData.class);
   		cr.add(Restrictions.eq("empId", empId));

   		List<EmployeData> eList = cr.list();
   		if(eList.size()==0) {
   			return null;
   		}
   		
   		return eList.get(0);
       }

		public void updateEmploy(){
			sessionFactory = SessionHelper.getConnection();
			Session session = sessionFactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			System.out.println(employeData);
			session.saveOrUpdate(employeData);
			transaction.commit();
		}





	}




package Infinite.HelloDemo;

public class Test {
	public static void main(String[] args) {
		EmployeDataDAO employeDataDAO = new EmployeDataDAO();
		employeDataDAO.empId = 1;
		employeDataDAO.loadEmployeData();
	}
}

package collections;

import java.util.Comparator;

public class EmployeeSort {

	public static Comparator<Employee> EmployeeIdComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee emp1, Employee emp2) {
			return emp1.getId() - emp2.getId();
		}

	};

	public static Comparator<Employee> EmployeeIdDescComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee emp1, Employee emp2) {
			return emp2.getId() - emp1.getId();
		}

	};

	public static Comparator<Employee> EmployeeSalaryComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee emp1, Employee emp2) {
			return Double.compare(emp1.getSalary(), emp2.getSalary());
		}

	};

	public static Comparator<Employee> EmployeeSalaryDescComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee emp1, Employee emp2) {
			return Double.compare(emp2.getSalary(), emp1.getSalary());
		}

	};

}

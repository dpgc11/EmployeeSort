package collections;

import java.util.Arrays;
import java.util.Scanner;

public class UserInterface {

	private Scanner reader;
	private int sizeOfEmployeeList;
	private Employee[] empList;
	private Employee[] newEmpList;
	private int answerSorting;
	private int empListSize;

	public UserInterface(Scanner reader) {
		this.reader = reader;
	}

	public void start() {
		askForEmployeeSize();
		createEmpList();
		askForEmployeeDetails();
		System.out.println("Original array: ");
		System.out.println();
		printArrayContents(empList);
		System.out.println();
		askForSort(empList);
	}

	public void askForEmployeeSize() {
		System.out.println();
		System.out.println("Enter the total number of employees: ");
		this.sizeOfEmployeeList = Integer.parseInt(reader.nextLine());
		empListSize = sizeOfEmployeeList;
	}

	public void createEmpList() {
		this.empList = new Employee[sizeOfEmployeeList];
	}

	public void askForEmployeeDetails() {
		int j = 1;
		for (int i = 0; i < empList.length; i++) {
			System.out.println("Enter the id of employee" + j + ":");
			int id = Integer.parseInt(reader.nextLine());

			System.out.println("Enter the name of employee" + j + ":");
			String name = reader.nextLine();

			System.out.println("Enter the  salary of employee" + j + ":");
			double salary = Double.parseDouble(reader.nextLine());
			empList[i] = new Employee(id, name, salary);
			j++;
		}
	}

	public void askForSort(Employee[] empList) {
		while (true) {
			System.out.println("Choose the type of sort: ");
			System.out.println();
			System.out.println("\t1. Sort using ID in ascending order");
			System.out.println("\t2. Sort using ID in descending order");
			System.out.println("\t3. Sort using salary in ascending order");
			System.out.println("\t4. Sort using salary in descending order");
			System.out.println("\t5. Insert a new employee");
			System.out.println("\t6. Exit");
			answerSorting = Integer.parseInt(reader.nextLine());

			if (answerSorting == 1) {
				sortUsingID(empList);
			} else if (answerSorting == 2) {
				sortUsingIDDesc(empList);
			} else if (answerSorting == 3) {
				sortUsingSalary(empList);
			} else if (answerSorting == 4) {
				sortUsingSalaryDesc(empList);
			} else if (answerSorting == 6) {
				System.exit(0);
			} else if (answerSorting == 5) {
				insertNewEmployee(empList);
			}
		}
	}

	public static void sortUsingSalaryDesc(Employee[] empList) {
		Arrays.sort(empList, EmployeeSort.EmployeeSalaryDescComparator);
		System.out.println("Employee List after sorting with salary in Desc order");
		System.out.println();
		printArrayContents(empList);
		System.out.println();
	}

	public static void sortUsingSalary(Employee[] empList) {
		Arrays.sort(empList, EmployeeSort.EmployeeSalaryComparator);
		System.out.println("Employee List after sorting with salary in Asc order");
		System.out.println();
		printArrayContents(empList);
		System.out.println();
	}

	public static void sortUsingID(Employee[] empList) {
		Arrays.sort(empList, EmployeeSort.EmployeeIdComparator);
		System.out.println("Employee List after sorting with Id");
		System.out.println();
		printArrayContents(empList);
		System.out.println();
	}

	public static void sortUsingIDDesc(Employee[] empList) {
		Arrays.sort(empList, EmployeeSort.EmployeeIdDescComparator);
		System.out.println("Employee List after sorting with ID in Desc order");
		System.out.println();
		printArrayContents(empList);
		System.out.println();
	}

	public void insertNewEmployee(Employee[] empList) {
		System.out.println();
		empListSize += 1;
		newEmpList = new Employee[empListSize];
		System.out.println("Enter the id of new employee" + ":");
		int id = Integer.parseInt(reader.nextLine());

		System.out.println("Enter the name of new employee" + ":");
		String name = reader.nextLine();

		System.out.println("Enter the  salary of new employee" + ":");
		double salary = Double.parseDouble(reader.nextLine());

		System.out.println("Enter the position in which to insert the employee: ");
		int pos = Integer.parseInt(reader.nextLine());
		for (int i = 0; i < pos-1; i++) {
			newEmpList[i] = empList[i];
		}
		newEmpList[pos-1] = new Employee(id, name, salary);
		for (int i = pos ; i < newEmpList.length; i++) {
			newEmpList[i] = empList[i-1];
		}
		System.out.println("Employee list after inserting: ");
		printArrayContents(newEmpList);
		
		askForSort(newEmpList);
	}

	public static void printArrayContents(Employee[] empList) {
		for (Employee emp : empList) {
			System.out.println(emp);
		}
	}

	public static void initDupArray(Employee[] array, Employee[] dupArray) {
		for (int i = 0; i < array.length; i++) {
			dupArray[i] = array[i];
		}
	}

}

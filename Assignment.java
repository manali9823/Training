package com.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Assignment {
    public static void main(String[] args) {
    	List<Employee> empList = new ArrayList<>();
    	List<Employee> dlst = empList.stream().distinct().collect(Collectors.toList());
    	System.out.println("Welcome to College Management");
		char choice;
		String result;
		int count = 0;
		do {
			if (count > 0) {
				System.out.println("C : Check Student Result");
			}
			System.out.println("A : Add Student Result");
			System.out.println("X : Exit");
			Scanner sc = new Scanner(System.in);
			String c = sc.next();

			switch (c.toUpperCase()) {
			case "A":
				System.out.println("Enter student id");
				int id = sc.nextInt();
				System.out.println("Enter student Name");
				String name = sc.next();
				System.out.println("Enter marks in hindi");
				int hindi = sc.nextInt();
				System.out.println("Enter marks in english");
				int eng = sc.nextInt();
				System.out.println("Enter marks in maths");
				int maths = sc.nextInt();
				System.out.println("Enter marks in science");
				int science = sc.nextInt();
				System.out.println("Enter marks in social");
				int social = sc.nextInt();
				int total = hindi+eng+maths+science+social;
				float per = (float) total / 5;
				per = per * 100;

				if (per > 50) {
					result="Pass";

				} else {
					result="Fail";

				}
				dlst.add(new Employee(id, name,hindi,eng,maths,science,social,result,total,per));
				System.out.println("Student added successfully");
				count++;
				break;
			case "C":
				System.out.println("Enter Student Id to Check result: ");
				int in=sc.nextInt();
				for(Employee e:dlst)
				{
					if(e.getEmpId()==(in))
					{
						dlst.stream().filter(emp->emp.getEmpId()==in).forEach(System.out::println);
						System.exit(0);
					}
				}
				System.out.println("No such data found");
				break;
			case "X":
				System.out.println("Bye");
				System.exit(1);
			default:
				System.out.println("Invalid choice");
				break;

			}
			System.out.println("Do you want to continue (Y/N)");
			choice = sc.next().charAt(0);
		} while (choice == 'Y' || choice == 'y');
		System.out.println("Bye");
		System.exit(1);
    
    }

	@Override
	public String toString() {
		return "MyClass []";
	}

	
}
class Employee {

	private int empId;
	private String empNm;
	private int m1, m2, m3, m4, m5;
	private String r;
	private float per;
	private int t;
	Scanner sc = new Scanner(System.in);

	public Employee() {
	}

	public Employee(int empId, String empNm, int m1, int m2, int m3, int m4, int m5, String r,int t, float per ) {
		super();
		this.empId = empId;
		this.empNm = empNm;
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
		this.m4 = m4;
		this.m5 = m5;
		this.per=per;
		this.r=r;
		this.t=t;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpNm() {
		return empNm;
	}

	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}

	public int getm1() {
		return m1;
	}

	public void setm1(int m1) {
		this.m1 = m1;
	}

	public int getm2() {
		return m2;
	}

	public void setm2(int m2) {
		this.m2 = m2;
	}

	public int getm3() {
		return m3;
	}

	public void setm3(int m3) {
		this.m3 = m3;
	}

	public int getm4() {
		return m4;
	}

	public void setm4(int m4) {
		this.m4 = m4;
	}

	public int getm5() {
		return m5;
	}

	public void setm5(int m5) {
		this.m5 = m5;
	}

	public String getR() {
		return r;
	}

	public void setR(String r) {
		this.r = r;
	}

	public float getPer() {
		return per;
	}

	public void setPer(float per) {
		this.per = per;
	}

	public int getT() {
		return t;
	}

	public void setT(int t) {
		this.t = t;
	}

	@Override
	public String toString() {
		return "Student Result {Id=" + empId + ", name=" + empNm + ",marks=Subject Marks{ Hindi=" + m1 + ", English=" + m2 + ", maths=" + m3 + ", Science="
				+ m4 + ", Social=" + m5 + "}, result=" + r +", total=" + t + ", percentage=" + per + "}";
	}

	
}
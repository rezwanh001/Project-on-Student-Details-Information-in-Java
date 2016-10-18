
import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author ( Md. Rezwanul Haque )
 * @email ( r.haque.249.rh@gmail.com )
 * Roll : 1407028
 * Department : CSE
 * University : KUET
 * Batch : 2K14
 * @version (18. 10. 2016)
 */
public class Student {


	static Scanner sc = new Scanner(System.in);
	static int Term_Num;
	static int Subject_Num;

	public static Student[] St = new Student[10];

	int Id;
	String Name;
	String Department;
	String University;

	double[] GPAs = new double[50];
	String[][] Subjects = new String[50][50];
	double[][] Credits = new double[50][50];
	double[][] Grades = new double[50][50];

	public Student(int m_id, String m_Nm, String m_Dpt, String m_var) {
		Id = m_id;
		Name = m_Nm;
		Department = m_Dpt;
		University = m_var;
	}

	public void computeGPAById(int d) {
		double total_Credits = 0.0;
		double total_Crd_Grd = 0.0;
		double gpa = 0.0;
		int cnt = 0;

		double cr, gd;
		// Enter Credits for Each Subject
		// pr("Enter nuber of Terms And Subjects : ");

		Term_Num = sc.nextInt();
		Subject_Num = sc.nextInt();

		for (int i = 0; i < Term_Num; i++) {
			// String sub = sc.nextLine();

			for (int j = 0; j < Subject_Num; j++) {
				// pr("Enter Sub, Credits and Gardes : ");
				// pr("Enter Sub : ");
				String sub = sc.next();
				cr = sc.nextDouble();
				gd = sc.nextDouble();

				Subjects[i][j] = sub;
				Credits[i][j] = cr;
				Grades[i][j] = gd;
			}
		}

		for (int trm = 0; trm < Term_Num; trm++) {
			for (int i = 0; i < Subject_Num; i++) {
				total_Crd_Grd += Credits[trm][i] * Grades[trm][i];
				total_Credits += Credits[trm][i];
			}

			gpa = total_Crd_Grd / total_Credits;
			GPAs[trm] = gpa;
		}
	}

	public double computeCGPAByID(int d) {
		double cg = 0.0;
		double CGPA = 0.0;
		for (int i = 0; i < Term_Num; i++) {
			cg += GPAs[i];
		}
		CGPA = cg / Term_Num;
		return CGPA;
	}

	public void updateStudentById(int d) {
		// prln("Do you want to update Informations ? (1/0) : ");

		// String s = sc.next();
		int s = sc.nextInt();

		if (s == 1) {
			// prln("Enter update Student's Id , Name , Department, Varsity : ");
			int u_id = sc.nextInt();
			String u_nm = sc.next();
			String u_dpt = sc.next();
			String u_var = sc.next();

			St[d] = new Student(u_id, u_nm, u_dpt, u_var);
			St[d].computeGPAById(d);
			St[d].computeCGPAByID(d);
		} else {
			//prln("     You type 0. ");
			prln("---------------Thank You----------------");
		}
	}

	public void Display(int d) {
		prln("Id         : " + Id);
		prln("Name       : " + Name);
		prln("University : " + University);
		prln("Department : " + Department);
		prln("GPAs       : ");

		int year = 1;
		for (int i = 0, trm = 1; i < Term_Num; i++, trm++) {

			if (trm % 2 == 1) {
				prln("GPA in " + (year) + " year  1 th Semister : " + GPAs[i]);
				
			} else {
				prln("GPA in " + (year) + " year  2 th Semister : " + GPAs[i]);
				year ++;
			}

		}
		prln("");
		
		prln("CGPA : " + computeCGPAByID(1));
		
		prln("");

		prln("Subjects are : ");
		int cnt = 1;
		for (int i = 0; i < Term_Num; i++) {
			for (int j = 0; j < Subject_Num; j++) {
				pr((cnt) + " th Subject " + Subjects[i][j] + ". \n");
				cnt++;
			}
			pr("");
		}

		
		prln("-----------------------------------------------------");
	}

	/**
	 * 
	 * @throws IOException 
	 * @Main Function
	 */

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("input.txt")));
		System.setOut(new PrintStream(new File("output.txt")));
		
		// prln("Enter Number of Student : ");
		int n = sc.nextInt();

		// Student [] St = new Student[10];

		// Student St = new Student(1407028, "Rezwan", "CSE", "KUET");
		for (int i = 0; i < n; i++) {
			// prln("Enter Id, Name , Department, Varsity of : " + (i+1)
			// " + th Student. ");

			int id = sc.nextInt();
			String nm = sc.next();
			String dpt = sc.next();
			String var = sc.next();

			St[i] = new Student(id, nm, dpt, var);
			St[i].computeGPAById(i);
			// St[i].Display(i);
			St[i].updateStudentById(i);
			// St[i].Display(i);
		}

		prln("********** Final Information ***********");

		for (int i = 0; i < n; i++) {
			St[i].Display(i);
		}

	}

	static void prln(Object anyObject) {
		System.out.println(anyObject);
	}

	static void pr(Object anyObject) {
		System.out.print(anyObject);
	}
}

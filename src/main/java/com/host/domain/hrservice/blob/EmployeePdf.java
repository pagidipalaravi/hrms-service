package com.host.domain.hrservice.blob;

import java.io.*;
import java.sql.*;

public class EmployeePdf {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

			PreparedStatement ps = con.prepareStatement("insert into employees values(?,?)");

			File f = new File("E:\\u01\\employeeresume.pdf");
			FileReader fr = new FileReader(f);

			ps.setInt(1, 101);
			ps.setCharacterStream(2, fr, (int) f.length());
			int i = ps.executeUpdate();
			System.out.println(i + " records affected");

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryService {
	public static void insertEmployee(Employee employee){
		String queryString = QueryFactory.addEmployee;
		try (
				Connection conn = ConnectionFactory.getconnection();
						PreparedStatement statement = conn
								.prepareStatement(queryString);) {
					try {
						conn.setAutoCommit(true);
						statement.setString(1, employee.getFname());
						statement.setString(2, employee.getLname());
						statement.setString(3, employee.getEmail());
						statement.setInt(4, employee.getAge());
						statement.addBatch();
						statement.executeBatch();
						conn.commit();

					} catch (SQLException ex) {
						ex.printStackTrace();
						conn.rollback();
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		public static List<Employee> showEmployee() throws SQLException{
			String queryString = QueryFactory.showEmployees;
			try (
					Connection conn = ConnectionFactory.getconnection();
							PreparedStatement statement = conn
									.prepareStatement(queryString);) {
				ResultSet resultSet = statement.executeQuery();
				List<Employee> employeeDetails = new ArrayList<Employee>();
				while(resultSet.next()){
					String fname = resultSet.getString("first_name");
					String lname = resultSet.getString("last_name");
					String email = resultSet.getString("email_id");
					int age = resultSet.getInt("age");
					Employee employee = new Employee();
					employee.setFname(fname);
					employee.setLname(lname);
					employee.setEmail(email);
					employee.setAge(age);
					employeeDetails.add(employee);
				}
				return employeeDetails;
			}
			catch (SQLException ex) {
				return null;
			}
		}
		public static void main (String[] args) throws SQLException{
			List<Employee> employeeDetails = new ArrayList<Employee>();
			employeeDetails = QueryService.showEmployee();
			for(Employee emp: employeeDetails){
				System.out.println(emp.getFname());
			}
		}
	}


package com.metacube.training.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.metacube.training.model.SkillsMaster;
import com.metacube.training.util.ConnectionFactory;
public class SkillsDao {

	private final static String SQL_INSERT_SKILLS = " INSERT INTO skill_master(skill_name) "
			+ "VALUES " + "(?)";
	
	public static boolean insertSkills(SkillsMaster skill){
		String queryString = SQL_INSERT_SKILLS;
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				statement.setString(1, skill.getSkillName());
				int rowsAffected = statement.executeUpdate();
				
				if(rowsAffected == 1){
					return true;
					}
					else{
						return false;
					}
				} catch (SQLException ex) {
					return false;
				}
			} catch (SQLException e) {
				return false;
			}
			}
	
	
}

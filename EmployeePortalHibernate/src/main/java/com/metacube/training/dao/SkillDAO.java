package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.SkillsMaster;

@Repository
public class SkillDAO implements DAOInterface<SkillsMaster> {

	private JdbcTemplate jdbcTemplate;
	private final String SQL_INSERT_SKILLS = " INSERT INTO skill_master(skill_name) " + "VALUES " + "(?)";

	@Autowired
	public SkillDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public SkillsMaster getInfoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SkillsMaster> getAllInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteInfo(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateInfo(SkillsMaster object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean create(SkillsMaster skillsMaster) {
		return jdbcTemplate.update(SQL_INSERT_SKILLS, skillsMaster.getSkillName() ) > 0;
	}

}
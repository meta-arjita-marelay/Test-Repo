package com.metacube.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Skills POJO
 * 
 * @author Arjita
 *
 */
@Entity
@Table(name = "skill_master")
public class SkillsMaster {
	@Id
	@Column(name = "skill_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int skillId;
	
	@Column(name = "skill_name")
	private String skillName;

	// Getters and setters
	public int getSkillId() {
		return skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

}

/**
 * 
 */
package com.rau.hibernate.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author Raushan kumar
 *
 */

@Entity(name = "ANIMAL")
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)// by deault SINGLE_TABLE
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)// for each class separate table 
@Inheritance(strategy=InheritanceType.JOINED)// for each class separate table and with mapped id of parent
@DiscriminatorColumn(name="ANIMAL_TYPE",discriminatorType=DiscriminatorType.STRING)// not mandatory, just for specific Discriminator column name, by deault String type column i.e. varchar 
public class Animal {
	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

}

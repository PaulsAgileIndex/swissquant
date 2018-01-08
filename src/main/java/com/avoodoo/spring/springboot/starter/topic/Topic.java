package com.avoodoo.spring.springboot.starter.topic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Topic {
	
	@Id 
	private String id;
	private String name;
	private String description;

}

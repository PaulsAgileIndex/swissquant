package com.avoodoo.spring.springboot.starter.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.avoodoo.spring.springboot.starter.topic.Topic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Course {
	
	@Id 
	private String id;
	private String name;
	private String description;
	@ManyToOne
	private Topic topic;

}

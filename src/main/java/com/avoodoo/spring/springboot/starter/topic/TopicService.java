package com.avoodoo.spring.springboot.starter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Data
public class TopicService {
	
	@Inject
	private TopicRepository topicRepository;

//	List<Topic> topics =  new ArrayList<>(Arrays.asList(
//			new Topic("spring", "Spring Framework", "Spring Framework Description"),
//			new Topic("java", "Core Java", "Core Java Description"),
//			new Topic("javascript", "JavaScript", "Core Java Description")
//			));
	
	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();		
//		topicRepository.findAll().forEach(t -> topics.add(t)); // same
		topicRepository.findAll().forEach(topics::add);        // same
		return topics;
	}
	
	public Topic getTopicById(String id) {
		return topicRepository.findOne(id);
//		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();		
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
//		topics.add(topic);
	}

	public void updateTopic(Topic topic) {
		topicRepository.save(topic);
//		for (int i = 0; i < topics.size(); i++) {
//			Topic t = topics.get(i);
//			if (t.getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//		}
	}

	public void deleteTopicById(String id) {
		topicRepository.delete(id);
//		topics.removeIf(t -> t.getId().equals(id));
	}
	
}

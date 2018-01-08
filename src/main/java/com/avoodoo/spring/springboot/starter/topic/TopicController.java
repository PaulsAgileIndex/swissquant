package com.avoodoo.spring.springboot.starter.topic;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Inject
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTropics() {	
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopicById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(topic);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopicById(id);
	}

}

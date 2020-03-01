package com.baru.learn.spring.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baru.learn.spring.service.TopicService;
import com.baru.learn.spring.service.model.Topic;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;

	@RequestMapping(method = RequestMethod.GET, value = "/topics") // Gets all Topics from Topic List.
	public List<Topic> getAllTopics() {
		return topicService.getTopics();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/topics/{topicId}") // Gets a topic based on Id.
	public Topic getTopic(@PathVariable("topicId") String topicId) {
		return topicService.getTopic(topicId);              
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addTopic") // Add a new topic to the topic list.
	public String createTopic(@RequestBody Topic topic) {
		String message = topicService.createTopic(topic);
		return message;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}") // Updates a topic based on Id.
	public void updateTopic(@RequestBody Topic topic, @PathVariable("topicId") String topicId) {
		topicService.updateTopic(topic, topicId);           
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}") //Deletes an existing topic based on Id. While running faced ConcurrentModificationException *******
	public void removeTopic(@PathVariable("topicId") String topicId) {
		topicService.deleteTopic(topicId);           
	}
}

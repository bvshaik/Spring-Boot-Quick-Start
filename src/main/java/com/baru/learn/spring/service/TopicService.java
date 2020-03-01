package com.baru.learn.spring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.baru.learn.spring.service.model.Topic;

@Service
public class TopicService {
	
	List<Topic> topics = new ArrayList<Topic>(Arrays.asList(new Topic("TOPIC001", "JAVA", "JAVA Desc"),
		     new Topic("TOPIC002", "PYTHON", "Python Desc"),
		     new Topic("TOPIC003", "MACHINE LEARNING", "ML Desc"),
		     new Topic("TOPIC004", "FASCINATING COLORS", "Page of Arts & Artists")));

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public Topic getTopic(String topicId) {
		for(Topic topic : topics) {
			if(topicId.equals(topic.getId())) {
				return topic;
			}
		}
		return null;
	}

	public String createTopic(Topic topic) {
		topics.add(topic);
		return topic.getId()+" Added Successfully!";
	}

	public void updateTopic(Topic topic, String topicId) {
		for(int i=0; i<topics.size();i++) {
			if(topics.get(i).getId().equals(topicId)) {
				topics.set(i, topic);
			}
		}
	}

	public void deleteTopic(String topicId) {
		for(int i=0; i<topics.size();i++) {
			if(topics.get(i).getId().equals(topicId)) {
				topics.remove(i);
			}
		}
	}

}

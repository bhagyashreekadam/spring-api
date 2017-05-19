package com.springbootapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootapi.domain.Topic;
import com.springbootapi.repository.TopicRepository;

@RestController
@RequestMapping("/topic")
public class TopicController{
	
	@Autowired
 private TopicRepository tr;
	
	@RequestMapping(method=RequestMethod.GET, value="/alltopics")
	@ResponseBody
	public List<Topic> findall(){
		return tr.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/topics/{id}")
	@ResponseBody
	public Topic getone(@PathVariable String id){
		return tr.findOne(id);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	@ResponseBody
	public void addTopic(@RequestBody Topic topic){
		tr.save(topic);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	@ResponseBody
	public void updateTopic(@RequestBody Topic topic,@PathVariable String id){
		Topic topicToUpdate = tr.findOne(id);
        if(topicToUpdate != null){
        	topicToUpdate.setId(topic.getId());
        	topicToUpdate.setName(topic.getName());
        	topicToUpdate.setDescription(topic.getDescription());
           tr.save(topic);
        }
		
	}
	
	
	private Topic get(String id) {
		  return tr.findOne(id);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	@ResponseBody
	public void deleteTopic(@PathVariable String id){
		tr.delete(id);
	}
	

}

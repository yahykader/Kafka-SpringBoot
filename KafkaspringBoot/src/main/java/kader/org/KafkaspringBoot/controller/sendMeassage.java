package kader.org.KafkaspringBoot.controller;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kader.org.KafkaspringBoot.model.PageEvent;
/**
 * @author abdel
 * ProducerKafka
 *
 */
@RestController
public class sendMeassage {

	/*@Autowired
	  private KafkaTemplate<String, String>kafkaTemplate;
	
	@GetMapping(value="/send/{data}/{topic}")
	public String send(@PathVariable(name="data") String data,@PathVariable(name="topic") String topic) {
		kafkaTemplate.send(topic, data);
		return "message sent...";
	}
	*/
	@Autowired
	private KafkaTemplate<String,PageEvent>kafkaTemplate;
	
	@GetMapping(value="/send/{page}/{topic}")
	public String send(@PathVariable String page,@PathVariable String topic) {
		PageEvent pageEvent=new PageEvent(page,new Date(),new Random().nextInt(1000));
		kafkaTemplate.send(topic, "key"+pageEvent.getPageName(),pageEvent);
		return "message sent...";
	}
	
	
}

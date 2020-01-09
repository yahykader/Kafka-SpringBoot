package kader.org.KafkaspringBoot.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.json.JsonMapper;

import kader.org.KafkaspringBoot.model.PageEvent;


/**
 * @author abdel
 * ConsumerKafka
 *
 */
@Service
public class MessageService {

	/*@KafkaListener(topics="test",groupId = "sample-group-test")
	public void onMessage(ConsumerRecord<String, String> cr) {
		System.out.println("*****************************");
		System.out.println(cr.key()+"************"+cr.value());
		System.out.println("*****************************");
	}*/
	
	
	@KafkaListener(topics="test5",groupId = "sample-group-test")
	public void onMessage(ConsumerRecord<String, String> cr) throws Exception {
		System.out.println("*****************************");
		PageEvent pageEvent=pageEvent(cr.value());
		System.out.println("***"+cr.key());
		System.out.println(pageEvent.getPageName()+","+pageEvent.getDate()+","+pageEvent.getDuration());
		System.out.println("*****************************");
	}	
	private PageEvent pageEvent(String jsonPageEvent) throws Exception {
		JsonMapper jsonMapper=new JsonMapper();
		PageEvent pageEvent=jsonMapper.readValue(jsonPageEvent, PageEvent.class);
		return pageEvent;
	}
}

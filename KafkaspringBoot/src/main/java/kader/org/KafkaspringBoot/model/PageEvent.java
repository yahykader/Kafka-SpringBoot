package kader.org.KafkaspringBoot.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class PageEvent {
	private String pageName;
	private Date date;
	private int duration;

}

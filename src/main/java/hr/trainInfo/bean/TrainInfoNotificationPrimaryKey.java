package hr.trainInfo.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class TrainInfoNotificationPrimaryKey implements Serializable {
	@Id
	@Column
	private String line;

	@Id
	@Column
	private String name;
}

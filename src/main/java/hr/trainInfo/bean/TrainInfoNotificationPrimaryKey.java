package hr.trainInfo.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
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

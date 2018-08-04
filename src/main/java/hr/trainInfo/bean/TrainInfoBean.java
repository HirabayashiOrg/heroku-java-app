package hr.trainInfo.bean;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class TrainInfoBean {
	private String line;
	private String info;
	private String detail;
}

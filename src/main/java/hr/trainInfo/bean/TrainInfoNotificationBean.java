package hr.trainInfo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@Entity
@Table(name="TBL_TRAIN_INFO_NOTIFICATION")
// 複合主キーを設定する場合に必要
@IdClass(TrainInfoNotificationPrimaryKey.class)
public class TrainInfoNotificationBean {
	@Id
	@Column
	private String line;

	@Id
	@Column
	private String name;

	@Column
	private int status;
}

package hr.github.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="V_GITHUB_PUSH")
public class GithubPushViewBean {
	@Id
	@Column
	private String pushed;

	@Column(nullable=false)
	private int add;

	@Column(nullable=false)
	private int count;

}

package hr.github.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="TBL_GITHUB_PUSH")
public class GithubPushBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@Column(nullable=false)
	private int total;

	@Column(nullable=false)
	private int additions;

	@Column(nullable=false)
	private int deletions;

	@Column(nullable=false)
	private Date pushed;
}

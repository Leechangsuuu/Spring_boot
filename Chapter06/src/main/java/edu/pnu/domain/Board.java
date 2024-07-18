package edu.pnu.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Board {
	@Id @GeneratedValue
	private Long seq;
	
	private String title;
	@Column(updatable=false)
	private String writer;
	
	private String content;
	@Column(insertable=false, updatable=false, columnDefinition="date default current_date()")
	private Date createDate;
	
	@Column(insertable=false, columnDefinition= "number default 0")
	private Long cnt;
}

package edu.pnu.domain;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class MemberVO {
	private Integer id;
	private String pass;
	private String name;
	private Date regidate;
	
}

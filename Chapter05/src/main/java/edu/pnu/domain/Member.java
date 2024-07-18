package edu.pnu.domain;

import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	@Id
	@Column(name="MEMBER_ID")//없어도 됨
	private String id;
	private String password;
	private String name;
	private String role;
	
	@JsonIgnore
	@ToString.Exclude
	@Builder.Default
	@OneToMany(mappedBy="member", fetch=FetchType.EAGER , cascade=CascadeType.ALL)
	private List<Board> boardList = new ArrayList<Board>();
}

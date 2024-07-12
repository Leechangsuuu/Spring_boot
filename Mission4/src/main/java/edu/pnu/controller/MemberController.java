package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import edu.pnu.domain.MemberDto;
import edu.pnu.service.MemberService;

public class MemberController {
	private MemberService memberService;
	
	public MemberController() {
		memberService  = new MemberService();
	}
	@GetMapping("/members")
	public List<MemberDto> getAllMembers(){
		return memberService.getAllMembers();
	}
	@GetMapping("/member")
	public MemberDto getMemberById(int id) {
		return memberService.getMemberById(id);
	}
	@PostMapping("/member")
	public MemberDto addMember(MemberDto dto) {
		return memberService.addMember(dto);
	}
	@PutMapping("/member")
	public int updateMember(MemberDto dto) {
		return memberService.updateMember(dto);
	}
	@DeleteMapping("/member")
	public int removeMember(MemberDto dto) {
		return memberService.removeMember(dto);
	}
	@PostMapping("/memberJSON")
	public MemberDto addMemberJSON(@RequestBody MemberDto dto) {
		return memberService.addMember(dto);
	}
}



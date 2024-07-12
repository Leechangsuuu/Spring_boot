package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import edu.pnu.domain.MemberDTO;
import edu.pnu.service.MemberService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberController {
	private final MemberService memberService;
	@GetMapping("/members")
	public List<MemberDTO> getAllMembers(){
		return memberService.getAllMembers();
	}
	@GetMapping("/member")
	public MemberDTO getMemberById(int id) {
		return memberService.getMemberById(id);
	}
	@PostMapping("/member")
	public MemberDTO addMember(MemberDTO dto) {
		return memberService.addMember(dto);
	}
	@PutMapping("/member")
	public int updateMember(MemberDTO dto) {
		return memberService.updateMember(dto);
	}
	@DeleteMapping("/member")
	public int removeMember(MemberDTO dto) {
		return memberService.removeMember(dto);
	}
	@PostMapping("/memberJSON")
	public MemberDTO addMemberJSON(@RequestBody MemberDTO dto) {
		return memberService.addMember(dto);
	}
}

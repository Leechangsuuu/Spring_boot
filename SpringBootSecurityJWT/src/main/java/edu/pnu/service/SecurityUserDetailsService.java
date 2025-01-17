package edu.pnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;
@Service
public class SecurityUserDetailsService implements UserDetailsService{
	@Autowired
	private MemberRepository memRepo;
	
	@Override // loadUserByUsername -> AuthenticationManager의 authenticate 메소드가 호출되면 실행
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{
		Member member = memRepo.findById(username).orElseThrow(()->new UsernameNotFoundException("NotFound!"));
		return new User(member.getUsername(), member.getPassword(),
				AuthorityUtils.createAuthorityList(member.getRole().toString()));
	}
}
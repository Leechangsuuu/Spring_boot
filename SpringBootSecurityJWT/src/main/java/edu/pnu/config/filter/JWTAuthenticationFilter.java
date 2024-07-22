package edu.pnu.config.filter;

import java.io.IOException;
import java.util.Date;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.pnu.domain.Member;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	// 인증 객체
	private final AuthenticationManager authenticationManager;
	// POST/login 요청이 왔을 때 인증을 시도하는 메소드
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException{
		//request에서 json 타입의 [username/password]을 읽어서 Member 객체를 생성한다
		ObjectMapper mapper = new ObjectMapper();
		try {
			Member member = mapper.readValue(request.getInputStream(), Member.class);
			//Security에게 자격증명 요청에 필요한 객체 생성
			Authentication authToken = new UsernamePasswordAuthenticationToken(member.getUsername(),member.getPassword());
			//인증 진행->UserDetailsService의 loadUserByUsername에서 DB로 부터 사용자 정보를 읽어온 뒤 
			//사용자 입력정보와 비교한뒤 자격증명에 성공하면 Authentication 객체를 만들어서 리턴한다
			return authenticationManager.authenticate(authToken);
		}catch(Exception e) {
			System.out.println(e.getMessage());//"자격증명에 성공" 로그 출력
		}
		response.setStatus(HttpStatus.UNAUTHORIZED.value());//자격증명에 실패하면 응답코드 리턴
		return null;
	}
	//인증이 성공했을떄 실행되는 후처리 메소드
	@Override
	protected void successfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain, Authentication authResult)throws IOException,
	ServletException{
		//자격증명이 성공하면 loadUserByUsername에서 만든 객체가 authResult 에 담겨져 있다
		User user = (User)authResult.getPrincipal();
		//username으로 JWT를 생성해서 response header-authorization에 담아서 돌려준다
		//하나의 예시로써 필요에 따라 추가 정보를 담을 수 있다
		String token = JWT.create()
						.withExpiresAt(new Date(System.currentTimeMillis()+1000*60*100))
						.withClaim("username", user.getUsername())
						.sign(Algorithm.HMAC256("edu.pnu.jwt"));
		response.addHeader(HttpHeaders.AUTHORIZATION, "Bearer "+ token);
		response.setStatus(HttpStatus.OK.value());
	}
}

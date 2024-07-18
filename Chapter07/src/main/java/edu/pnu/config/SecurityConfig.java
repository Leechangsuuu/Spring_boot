package edu.pnu.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration//설정 클래스라고 정의
@EnableWebSecurity//필요한 객체 자동 생성
public class SecurityConfig {
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean//이 메소드가 리턴하는 객체를 loc 컨테이너에 등록하라는 지시 
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(security->security
				.requestMatchers("/member/**").authenticated()
				.requestMatchers("/manager/**").hasAnyRole("MANAGER","ADMIN")
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().permitAll());
		
		http.csrf(cf->cf.disable());
		http.formLogin(form->
				form.loginPage("/login")
					.defaultSuccessUrl("/loginSuccess",true));
		
		http.exceptionHandling(ex->ex.accessDeniedPage("/accessDenied"));
		
		http.logout(logout->logout
					.invalidateHttpSession(true)
					.deleteCookies("JSESSIONID")
					.logoutSuccessUrl("/login"));
		
		http.headers(hr->hr.frameOptions(fo->fo.disable()));
		
		return http.build();
	}
	
//	@Autowired
//	public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//			.withUser("manager")
//			.password("{noop}abcd")//{noop} : No Operation -> 비밀번호가 암호화되어 있지 않다는 의미
//			.roles("MANAGER");
//		auth.inMemoryAuthentication()
//			.withUser("admin")
//			.password("{noop}abcd")
//			.roles("ADMIN");
//	}
	
}

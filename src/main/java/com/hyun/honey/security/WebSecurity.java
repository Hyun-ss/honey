package com.hyun.honey.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CharacterEncodingFilter;
@EnableWebSecurity
public class WebSecurity {
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);

        http
                //url 보안설정
                .authorizeRequests(authorize -> authorize
                        //윗줄에서 적용한 주소나 패턴이 우선적용됩니다.
                        .antMatchers("/css/**","/js/**","/images/**").permitAll()
                        .antMatchers("/admin/**").hasRole("ADMIN")
                        .antMatchers("/","/layout/**","/member/**").permitAll()//인증없이 접속할수 있는 주소나 패턴
                        //인증권한 ADMIN이 필요하다. 권한 =(ROLE_ADMIN)
                        .anyRequest().authenticated()//모든 요청주소에서 인증이 필요합니다 --> 로그인페이지로 갑니다.

                )
                .formLogin(formLogin->formLogin
                        .loginPage("/member/login")
                        .loginProcessingUrl("/login") //form 태그 액션
                        .usernameParameter("email")//기본적인 username 값을 -> email로 바꿔주는
                        .passwordParameter("pass")//위와 같다 변경을 원할때 쓰면된다.
                        .permitAll()




                )
                .csrf(csrf->csrf.disable()) //토큰으로 대체가능 위조떄문에


        ;
        return http.build();
    }
}

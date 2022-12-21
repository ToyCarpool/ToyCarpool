package kt.carpool.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .authorizeRequests((authz) ->{
                    try {
                        authz
                                .antMatchers("/api/member/user/**").authenticated()
                                .anyRequest().permitAll()
                                .and()
                                .formLogin()
                                .loginPage("/api/member/loginForm")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .csrf((authz) -> authz.disable())
                .headers((authz) -> authz.frameOptions().disable())
                .httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder encodePwd() { return new BCryptPasswordEncoder();}
}

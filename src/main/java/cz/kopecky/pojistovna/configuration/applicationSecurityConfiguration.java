package cz.kopecky.pojistovna.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

@Configuration
public class applicationSecurityConfiguration {
    @Bean
    public DefaultSecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception
    {
        return http
                .authorizeHttpRequests()
                    .requestMatchers("/users/create","/users/edit/**","/users/delete/**")
                        .authenticated()
                    .requestMatchers(
                        "/styles/**","/images/**","/scripts/**","/fonts/**","/users/**",
                        "/","/account/register","/users"
                    )
                        .permitAll()
                    .anyRequest()
                        .authenticated()
                    .and()
                .formLogin()
                    .loginPage("/account/login")
                    .loginProcessingUrl("/account/login")
                    .defaultSuccessUrl("/users",true)
                    .usernameParameter("email")
                    .permitAll()
                    .and()
                .logout()
                    .logoutUrl("/account/logout")
                    .and()
                .build();
    }
}

package top.bwang.config;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import top.bwang.filter.LoginFilter;

/**
 * @author bwang
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /** json工具类 */
    private final ObjectMapper mapper = new ObjectMapper();

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(loginFilter(), UsernamePasswordAuthenticationFilter.class);
        http.csrf().disable();
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/rest")
                .permitAll();
        http.logout()
                .logoutUrl("/logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout","POST"))
                .logoutSuccessUrl("/index")
                .deleteCookies()
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .permitAll()
                .and();
    }

    @Bean
    LoginFilter loginFilter() throws Exception {
        LoginFilter loginFilter = new LoginFilter();
        loginFilter.setAuthenticationManager(super.authenticationManagerBean());
        loginFilter.setAuthenticationSuccessHandler(((request, response, authentication) -> {
            response.setContentType("application/json;charset=utf-8");
            PrintWriter writer = response.getWriter();
            Map<String, Object> map = new HashMap<>();
            map.put("status", HttpServletResponse.SC_OK);
            map.put("msg", authentication.getPrincipal());
            writer.write(mapper.writeValueAsString(map));
            writer.flush();
            writer.close();
        }));
        loginFilter.setAuthenticationFailureHandler(((request, response, authenticationException) -> {
            response.setContentType("application/json;charset=utf-8");
            PrintWriter writer = response.getWriter();
            Map<String, Object> map = new HashMap<>();
            map.put("status", HttpServletResponse.SC_UNAUTHORIZED);
            map.put("msg", authenticationException.getMessage());
            writer.write(mapper.writeValueAsString(map));
            writer.flush();
            writer.close();
        }));
        return loginFilter;
    }
}

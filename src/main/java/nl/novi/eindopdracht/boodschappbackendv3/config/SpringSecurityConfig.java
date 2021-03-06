package nl.novi.eindopdracht.boodschappbackendv3.config;

import nl.novi.eindopdracht.boodschappbackendv3.filter.JwtRequestFilter;
import nl.novi.eindopdracht.boodschappbackendv3.services.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    public CustomUserDetailService customUserDetailService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .httpBasic().disable()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/users/{username}").permitAll()
                .antMatchers(HttpMethod.PUT, "/users/{username}").permitAll()
                .antMatchers(HttpMethod.PUT, "/users/{username}/{id}").permitAll()
                .antMatchers(HttpMethod.GET, "/users").permitAll()
                .antMatchers(HttpMethod.POST, "/users/**").permitAll()

                .antMatchers(HttpMethod.GET, "/persons").permitAll()
                .antMatchers(HttpMethod.POST, "/persons/**").permitAll()
                .antMatchers(HttpMethod.POST, "/persons").permitAll()
                .antMatchers(HttpMethod.PUT, "/persons").permitAll()

                .antMatchers(HttpMethod.DELETE, "/persons/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/products/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/products/").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/users/**").hasRole("ADMIN")

                .antMatchers("/authenticate").permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }

}
package com.jrp.pma.security.config;

import com.jrp.pma.services.authentication.PmaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.ldapAuthentication()
                .userDnPatterns("uid={0},ou=people")  // uid is checked that's why {0}
                .groupSearchBase("ou=groups")
                .contextSource()
                .url("ldap://localhost:8389/dc=springframework,dc=org")
                .and()
                .passwordCompare()
                .passwordEncoder(new BCryptPasswordEncoder())
                .passwordAttribute("userPassword");

        //// OR

//        auth.userDetailsService(pmaUserDetailsService);

        //// OR

//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("SELECT username, password, enabled "
//                + "FROM user_account WHERE username = ?")
//                .authoritiesByUsernameQuery("SELECT username, role "
//                        + "FROM user_account WHERE username = ?")
//                .passwordEncoder(bCryptEncoder);

        //// OR

//                .withDefaultSchema()
//                .withUser("myuser")
//                    .password("pass")
//                    .roles("USER")
//                .and()
//                .withUser("user")
//                    .password("pass")
//                    .roles("USER")
//                .and()
//                .withUser("admin")
//                    .password("pass3")
//                    .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .anyRequest().fullyAuthenticated()
//                .antMatchers("/projects/new").hasRole("ADMIN")
//                .antMatchers("/employees/new").hasRole("ADMIN")
//                .antMatchers("/projects/save").hasRole("ADMIN")
//                .antMatchers("/employees/save").hasRole("ADMIN")
//                .antMatchers("/employees/delete/**").hasRole("ADMIN")
//                .antMatchers("/projects/delete/**").hasRole("ADMIN")
//                //.antMatchers("/h2-console/**").permitAll()
//                //.antMatchers("/").authenticated() // access of the home page only for authenticated
//                .antMatchers("/", "/**").permitAll() // access of the home page for all
                .and().formLogin(); //.loginPage("/login-page");

        // cross-side request forgery protection - by default by Spring
        //http.csrf().disable();
        //http.headers().frameOptions().disable();
    }
}

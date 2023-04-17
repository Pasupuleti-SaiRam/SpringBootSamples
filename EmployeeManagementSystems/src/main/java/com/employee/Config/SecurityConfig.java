
package com.employee.Config;

import javax.sql.DataSource;

import org.aspectj.weaver.ast.And;
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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.employee.Filter.SecurityFilter;
import com.employee.Service.UserServiceImpl;

@Configuration

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private BCryptPasswordEncoder pwdEncoder;

	@Autowired
	private InvalidUserAuthEntryPoint invalidUserEntryPoint;
	@Autowired
	private SecurityFilter filter;

	
	  @Override
	 protected void configure(HttpSecurity http) throws Exception {
		  http
		  .csrf()
		  .disable() 
		  .authorizeHttpRequests()
		  .antMatchers("/saveUser", "/login")
		  .permitAll()
		  .anyRequest()
		  .authenticated() 
		  .and() 
		  .exceptionHandling()
		  .authenticationEntryPoint(invalidUserEntryPoint)
		  .and()
		  .sessionManagement() 
		  .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		  .and()
		  .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	  
	 
	  }
	 
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {


		return super.authenticationManager();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService).passwordEncoder(pwdEncoder);

	}

	// this method for JDBC Authentication
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.jdbcAuthentication().dataSource(dataSource)
	 * .usersByUsernameQuery("select username,password,enable from usersdetails where username=?"
	 * )
	 * .authoritiesByUsernameQuery("select username,role from usersdetails where username=?"
	 * ) .passwordEncoder(encoder);
	 * 
	 * }
	 * 
	 * // This method For In-Memory Aunthentication
	 * 
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * 
	 * auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser(
	 * "sai")
	 * .password(passwordEncoder().encode("sai@123")).roles("USER").and().withUser(
	 * "ram") .password(passwordEncoder().encode("ram@123")).roles("ADMIN");
	 * 
	 * }
	 * 
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.authorizeHttpRequests().antMatchers("/getAll").hasAnyAuthority("Admin",
	 * "Employee") .antMatchers(HttpMethod.POST,
	 * "/employee/save").hasAuthority("Admin").antMatchers("/getEmployee/{id}")
	 * .hasAnyAuthority("Admin", "Employee").antMatchers(HttpMethod.DELETE,
	 * "/employee/delete/{id}")
	 * .hasAuthority("Admin").anyRequest().authenticated().and().httpBasic().and().
	 * csrf().disable();
	 * 
	 * }
	 */

}

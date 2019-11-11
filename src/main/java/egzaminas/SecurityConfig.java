package egzaminas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import egzaminas.domain.Login;
import egzaminas.repository.LoginRepository;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	LoginRepository loginRepository;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		List<Login> allLoginList = loginRepository.findAll();

		allLoginList.forEach(value -> {
			if (value.getRole().equals("admin")) {
				try {
					auth.inMemoryAuthentication().withUser(value.getLogin()).password(value.getPassword())
							.roles("ADMIN");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (value.getRole().equals("user")) {
				try {
					auth.inMemoryAuthentication().withUser(value.getLogin()).password(value.getPassword())
							.roles("USER");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.formLogin().defaultSuccessUrl("/blog").failureUrl("/login?error");
//		http.logout().logoutSuccessUrl("/login?logout");
		http.logout().logoutSuccessUrl("/blog");
		http.exceptionHandling().accessDeniedPage("/login?accessDenied");
		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/**/admin").hasRole("ADMIN")
				.antMatchers("/**/user/**").hasAnyRole("USER").and().formLogin();

	}
}

package lindor.casestudy.config;

import lindor.casestudy.database.dao.UserDAO;
import lindor.casestudy.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDAO userDAO;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login/**", "/error/**", "/resources/**", "/about", "/ajax").permitAll()
                .antMatchers("/", "/index", "/upload").authenticated()
                .and()
                .formLogin()
                .loginPage("/login/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/", true)
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll();
    }

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            User user = userDAO.findByEmail(username);
            if (user == null) {
                throw new UsernameNotFoundException("User not found: " + username);
            }
            return org.springframework.security.core.userdetails.User
                    .withUsername(user.getEmail())
                    .password(user.getPassword())
                    .roles("USER")
                    .build();
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

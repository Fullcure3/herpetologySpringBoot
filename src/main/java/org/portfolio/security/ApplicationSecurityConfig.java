package org.portfolio.security;

import org.portfolio.services.ApplicationUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    private UserDetailsService applicationUserDetailService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder, @Qualifier("App") UserDetailsService userDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserDetailService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/herps", true)
                .permitAll()
                .and()
                .rememberMe()
                .tokenValiditySeconds((((int) TimeUnit.DAYS.toSeconds(30))))
                .and()
                .logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID", "remember-me")
                .logoutSuccessUrl("/login");
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(applicationUserDetailService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }
//
//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//        var userDetailsChris = User.builder()
//                .username("Chris")
//                .password(passwordEncoder.encode("admin"))
////                .roles(ADMIN.name())
//                .authorities(ADMIN.getGrantedAuthorities())
//                .build();
//
//
//        var userDetailsGuest = User.builder()
//                .username("guest")
//                .password(passwordEncoder.encode("temp"))
//                .authorities(GUEST.getGrantedAuthorities())
////                .roles(GUEST.name())
//                .build();
//        return new InMemoryUserDetailsManager(userDetailsChris, userDetailsGuest);
//    }
}

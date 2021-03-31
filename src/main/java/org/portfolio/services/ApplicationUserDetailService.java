package org.portfolio.services;

import org.portfolio.authentication.ApplicationUserDetails;
import org.portfolio.dao.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "App")
public class ApplicationUserDetailService implements UserDetailsService {

    private UserDetailRepository userDetailRepository;

    @Autowired
    public ApplicationUserDetailService(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userDetailRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("user %s not found", username)));
        return new ApplicationUserDetails(user);
    }
}

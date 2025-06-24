package practice.asanxidmet.authentication.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import practice.asanxidmet.authentication.model.CustomUserDetails;
import practice.asanxidmet.entity.User;
import practice.asanxidmet.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository repository;

    public CustomUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("user not found"));
        return new CustomUserDetails(user);
    }
}

package de.ait.training.service;

import de.ait.training.model.SportUser;
import de.ait.training.repository.SportUserRepository;
import de.ait.training.security.SportUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SportUserDetailService implements UserDetailsService {

    private SportUserRepository sportUserRepository;

    public SportUserDetailService(SportUserRepository sportUserRepository) {
        this.sportUserRepository = sportUserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SportUser sportUser = sportUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        return new SportUserDetails(sportUser);
    }
}

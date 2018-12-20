package ru.astral.authentication;

import java.util.ArrayList;
import java.util.List;

import ru.astral.dao.LoginDAO;
import ru.astral.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyDBAuthenticationService implements UserDetailsService {

    @Autowired
    private LoginDAO loginDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login login = loginDAO.findLogin(username);
        System.out.println("Login= " + login);

        if (login == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }

        // [USER,ADMIN,..]
        List<String> roles= loginDAO.getUserRoles(username);

        List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
        if(roles!= null)  {
            for(String role: roles)  {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new User(login.getUsername(), //
                login.getPassword(),grantList);

        return userDetails;
    }

}

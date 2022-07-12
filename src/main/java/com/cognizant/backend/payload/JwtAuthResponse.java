package com.cognizant.backend.payload;

import com.cognizant.backend.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

@NoArgsConstructor
@Getter
@Setter
public class JwtAuthResponse {

    private String token;

    private UserDetails user;
}

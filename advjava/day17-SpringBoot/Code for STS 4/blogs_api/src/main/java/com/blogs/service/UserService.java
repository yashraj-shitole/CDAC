package com.blogs.service;

import com.blogs.dto.AuthRequest;
import com.blogs.dto.UserRespDTO;

public interface UserService {
 UserRespDTO signIn(AuthRequest dto);
}

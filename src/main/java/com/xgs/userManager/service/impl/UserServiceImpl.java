package com.xgs.userManager.service.impl;

import org.springframework.stereotype.Service;

import com.xgs.core.service.BaseServiceImpl;
import com.xgs.userManager.domain.User;
import com.xgs.userManager.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, String> implements UserService {

}

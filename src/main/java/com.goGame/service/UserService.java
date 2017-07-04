package com.goGame.service;

import com.goGame.commands.Email;

/**
 * Created by ravi on 4/7/17.
 */
public interface UserService {
    public void sendSimpleEmail(Email email);
}

package com.funtl.oauth2.server.service;

import com.funtl.oauth2.server.domain.TbUser;

public interface TbUserService{

   TbUser getByUsername(String username);

}

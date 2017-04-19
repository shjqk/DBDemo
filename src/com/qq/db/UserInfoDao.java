package com.qq.db;

import java.util.List;

public interface UserInfoDao
{
    public Integer  insert(UserInfo userInfo);
    public Integer update(UserInfo userInfo);
    public long delete(String userName);
    public List<UserInfo>selectAll();    
    public long countAll();
    public UserInfo findByName(String userName);
}

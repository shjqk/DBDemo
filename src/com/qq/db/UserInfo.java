package com.qq.db;

import java.util.Date;

public class UserInfo
{
    private long uID;
    private String userName;
    private String pwd;
    private Date datachange_lasttime;
    public long getuID()
    {
        return uID;
    }
    public void setuID(long uID)
    {
        this.uID = uID;
    }
    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public String getPwd()
    {
        return pwd;
    }
    public void setPwd(String pwd)
    {
        this.pwd = pwd;
    }
    public Date getDatachange_lasttime()
    {
        return datachange_lasttime;
    }
    public void setDatachange_lasttime(Date datachange_lasttime)
    {
        this.datachange_lasttime = datachange_lasttime;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "UserInfo [uID=" + uID + ", userName=" + userName + ", pwd=" + pwd + ", datachange_lasttime="
                + datachange_lasttime + "]";
    }
    
    
}

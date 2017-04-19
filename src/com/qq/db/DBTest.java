package com.qq.db;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBTest
{
    public static void main(String[] args)
    {
        System.out.println("test github");
        String resource = "./mybatis-config.xml";
        InputStream inputStream =null;
        try
        {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        UserInfoDao userInfoDao = session.getMapper(UserInfoDao.class);
        System.out.println("¼ÇÂ¼Êý: "+userInfoDao.countAll());
        
//        Iterator<UserInfo> iter = lsUserInfo.iterator();
//        while(iter.hasNext())
//        {
//            UserInfo userInfo = iter.next();
//            System.out.println(userInfo);
//        }
        Date date=new Date();

        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("tedd");
        String pwd = "123";
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(pwd.getBytes());
            pwd =  new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e)
        {
            // TODO: handle exception
        }
        userInfo.setPwd(pwd);
        userInfo.setDatachange_lasttime(date);
        userInfoDao.insert(userInfo);
        //////////////////////////////////////////////////////
        userInfo.setPwd("222");
        userInfo.setuID(10);
        Date date2=new Date();
        userInfo.setDatachange_lasttime(date2);
        userInfoDao.update(userInfo);
        ////////////////////////////////////////////////////
        List<UserInfo> lsUserInfo = userInfoDao.selectAll();
        for (int i = 0; i < lsUserInfo.size(); i++)
        {
            System.out.println(lsUserInfo.get(i) );
        }
        session.close();
        System.out.println( java.util.UUID.randomUUID());
        //BlogMapper mapper = session.getMapper(BlogMapper.)
        //HashMap<String,String> result = session.selectOne("countAll", 110);
        //System.out.println("Result: "+result);
        
    }
    

}

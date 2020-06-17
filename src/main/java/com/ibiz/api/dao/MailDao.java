package com.ibiz.api.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "mailDao")
public class MailDao {

    @Autowired
    private SqlSessionTemplate mybatis;

}

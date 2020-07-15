package com.ibiz.api.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "deptDAO")
public class DeptDAO {

    @Autowired
    private SqlSessionTemplate mybatis;

    /*
     * SELECT
     */

    public List<String> selectAuthDeptIdList(String userGrpVO) {
        return mybatis.selectList("DeptMapper.selectAuthDeptIdList", userGrpVO);
    }

    public List<String> selectAllAuthDeptIdList(String userGrpVO) {
        return mybatis.selectList("DeptMapper.selectAllAuthDeptIdList", userGrpVO);
    }

}

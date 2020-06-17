package com.ibiz.api.dao;

import com.ibiz.api.model.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "projectSalesDao")
public class ProjectSalesDao {

    @Autowired
    private SqlSessionTemplate mybatis;

    public List<SalesActivityVO> selectSalesActivityList(BizOpportunityVO bizOpportunityVO) {
        return mybatis.selectList("SalesMapper.Select_salesActivityList", bizOpportunityVO);
    }
    public SalesActivityVO selectMaxSlsActId() {
        return mybatis.selectOne("SalesMapper.Select_maxSlsActId");
    }

    public void insertSalesActivity(SalesActivityVO salesActivityVO) {
        mybatis.insert("SalesMapper.Insert_salesActivity", salesActivityVO);
    }
    public void updateSalesActivity(SalesActivityVO salesActivityVO) {
        mybatis.update("SalesMapper.Update_salesActivity", salesActivityVO);
    }

    public void deleteSalesActivity(SalesActivityVO salesActivityVO) {
        mybatis.delete("SalesMapper.Delete_salesActivity", salesActivityVO);
    }
}

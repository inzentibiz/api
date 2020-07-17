package com.ibiz.api.service;

import com.ibiz.api.dao.DeptDAO;
import com.ibiz.api.model.SysUserGroupVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;

@Service
@Slf4j
public class AbstractWebService {

    @Resource(name = "deptDAO")
    private DeptDAO deptDAO;

    @Transactional
    protected boolean isBelongToAuthDept(SysUserGroupVO sysUserGroupVO) {
        //List<String> resultList = webDAO.selectIsBelongToAuthDept(userGrpVO);
        HashSet<String> allSourceDeptIdSet = new HashSet<>();
        HashSet<String> allTargetDeptIdSet = new HashSet<>();

        int preSize;
        int postSize;

        List<String> sourceDeptIdList = deptDAO.selectAuthDeptIdList(sysUserGroupVO.getSourceUserId());
        for (String sourceDeptId : sourceDeptIdList) {
            allSourceDeptIdSet.addAll(deptDAO.selectAllAuthDeptIdList(sourceDeptId));
        }

        List<String> targetDeptIdList = deptDAO.selectAuthDeptIdList(sysUserGroupVO.getTargetUserId());
        for (String targetDeptId : targetDeptIdList) {
            allTargetDeptIdSet.addAll(deptDAO.selectAllAuthDeptIdList(targetDeptId));
        }

        preSize = allSourceDeptIdSet.size() + allTargetDeptIdSet.size();
        allTargetDeptIdSet.addAll(allTargetDeptIdSet);
        postSize = allTargetDeptIdSet.size();


        return preSize != postSize;
    }

}

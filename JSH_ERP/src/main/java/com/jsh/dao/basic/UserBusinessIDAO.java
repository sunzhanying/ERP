package com.jsh.dao.basic;

import java.util.List;

import com.jsh.base.BaseIDAO;
import com.jsh.model.po.UserBusiness;
import com.jsh.util.JshException;
import com.jsh.util.PageUtil;

public interface UserBusinessIDAO extends BaseIDAO<UserBusiness> {
    /*
     * 测试hql语句
     */
    void find(PageUtil<UserBusiness> pageUtil, String ceshi) throws JshException;
    
    List<UserBusiness> findUserBusinessListByUserId(Long userId,String type);
}

package com.jsh.service.basic;

import java.util.List;

import com.jsh.base.BaseIService;
import com.jsh.model.po.UserBusiness;
import com.jsh.util.JshException;
import com.jsh.util.PageUtil;

public interface UserBusinessIService extends BaseIService<UserBusiness> {
    /*
     * 测试一下自定义hql语句
     */
    void find(PageUtil<UserBusiness> userBusiness, String ceshi) throws JshException;
    
    List<UserBusiness> findUserBusinessListByUserId(Long userId,String type);

}

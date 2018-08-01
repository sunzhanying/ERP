package com.jsh.dao.basic;

import com.jsh.base.BaseDAO;
import com.jsh.model.po.UserBusiness;
import com.jsh.util.JshException;
import com.jsh.util.PageUtil;
import com.jsh.util.SearchConditionUtil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

public class UserBusinessDAO extends BaseDAO<UserBusiness> implements UserBusinessIDAO {
    /**
     * 设置dao映射基类
     *
     * @return
     */
    @Override
    public Class<UserBusiness> getEntityClass() {
        return UserBusiness.class;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void find(PageUtil<UserBusiness> pageUtil, String ceshi) throws JshException {
        Query query = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("select count(id),sum(id) from UserBusiness userBusiness where 1=1 " + SearchConditionUtil.getCondition(pageUtil.getAdvSearch()));
        pageUtil.setTotalCount(query.list().size());
        pageUtil.setPageList(query.list());
    }

	@Override
	public List<UserBusiness> findUserBusinessListByUserId(Long userId,String type) {
		StringBuffer sb = new StringBuffer();
		sb.append("select Id,Type,KeyId,Value,BtnStr from UserBusiness userBusiness where 1 = 1");
		if(userId != null && userId > 0) {
			sb.append(" and KeyId=" + userId);
		}
		if(type != null && !"".equals(type)) {
			sb.append(" and Type='" + type).append("'");
		}
		System.out.println(sb.toString());
		Query query = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
        System.out.println(query.list().size());
        List<UserBusiness> listTemp = new ArrayList<>();
        List<Object[]> listObj = query.list();
        for(int i = 0 ;i< listObj.size();i++){
        	UserBusiness ub = new UserBusiness();
        	Object[] objArray = listObj.get(i);
        	ub.setId((Long)objArray[0]);
        	ub.setType((String)objArray[1]);
        	ub.setKeyId((String)objArray[2]);
        	ub.setValue((String)objArray[3]);
        	ub.setBtnStr((String)objArray[4]);
        	listTemp.add(ub);
        }
		return listTemp;
	}
}

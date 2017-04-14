package com.zssi.framework.app.mass.dao;

import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.model.Attachment;

/**
 * 附件管理Dao
 * @author zhangyi
 *
 */
@Repository
public class AttachMentDao extends HibernateBaseDaoImpl<Attachment, Long> {
		
}

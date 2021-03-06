package com.yanda.core.service.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.yanda.core.entity.PageResult;
import com.yanda.core.exception.DOPException;
import com.yanda.core.service.BaseService;
import com.yanda.core.util.MyMapper;


/**
 * 服务类增删改查默认实现抽象类
 * BaseServiceImpl.java
 * @author chenli
 * @time 2018年3月7日 下午10:33:39
 */
public abstract class BaseServiceImpl<D extends MyMapper<T>, T extends Serializable, ID> implements BaseService<T, ID> {
	/**
	 * 日志记录，继承BaseServiceImpl的服务类可直接调用
	 */
	protected Logger LOG = Logger.getLogger(this.getClass());
	
	/**
	 * 泛型mapper类
	 */
	@Autowired
    protected D mapper;
	
    public D getMapper() {
        return mapper;
    } 
    
    /**
     * 一般都需要用到获取列表的方法，但是不同业务涉及到不同查询条件，这里返回null是为了留给子类在需要用到的时候去实现
     */
    public PageResult<T> getList(int pageNum, int pageSize, String searchVal) {
    	return null;
    }
	
	/**
	 * 新增实体
	 * @param t
	 * @return
	 */
    @Override
	public int save(T t) throws DOPException {
		return this.mapper.insertSelective(t);
	}
  
    /** 
     * 通过id删除实体 
     * @param id id 
     * @return 提示信息 
     */  
    @Override
    public int deleteById(ID id) throws DOPException {  
        return this.mapper.deleteByPrimaryKey(id);  
    }
    
    /**
     * 修改实体
     * @param record
     * @return
     */
    @Override
    public int update(T t) throws DOPException {
		return this.mapper.updateByPrimaryKeySelective(t);
	}
    
    /** 
     * 通过id查询 实体 
     * @param id id 
     * @return 实体 
     */  
    @Override
    public T selectById(ID id) throws DOPException {  
        return this.mapper.selectByPrimaryKey(id);  
    }
    
    @Override
    public int upsertSelective(T t) throws DOPException {
    	return this.mapper.upsertSelective(t);
    }

}

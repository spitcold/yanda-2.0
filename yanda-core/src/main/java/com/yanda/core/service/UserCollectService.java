package com.yanda.core.service;

import com.yanda.core.entity.PageResult;
import com.yanda.core.entity.UserCollectDetailInfo;
import com.yanda.core.entity.generated.UserCollectInfo;
import com.yanda.core.exception.DOPException;


public interface UserCollectService extends BaseService<UserCollectInfo, Long> {

	/**
	 * 根据用户id 查询我的收藏
	 * @param userId
	 * @return
	 */
	PageResult<UserCollectDetailInfo> findUserCollectsByUserId(Long userId, int pageNum, int pageSize);
	
	/**
	 * 根据id 删除收藏
	 * @param userId
	 * @param episodeId
	 */
	void deleteByCollectId(Long collectId) throws DOPException;
	
	/**
	 * 根据用户id 和 视频 id 增加收藏
	 * @param userId
	 * @param episodeId
	 */
	boolean addByUIdAndEpisodeId(Long userId, Long episodeId) throws DOPException;
}

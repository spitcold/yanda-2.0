package com.yanda.core.entity;

import com.yanda.core.entity.generated.AttachmentInfo;
import com.yanda.core.entity.generated.MovieInfo;

public class MovieDetailInfo extends MovieInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2891014268571652990L;

	public MovieDetailInfo() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * 图片附件
	 */
	private AttachmentInfo imgAttach;

	public AttachmentInfo getImgAttach() {
		return imgAttach;
	}

	public void setImgAttach(AttachmentInfo imgAttach) {
		this.imgAttach = imgAttach;
	}

}

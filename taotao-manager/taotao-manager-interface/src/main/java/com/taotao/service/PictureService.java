package com.taotao.service;

import com.taotao.common.pojo.PictureResult;

public interface PictureService {
	/**
	 * 
	 * @param bytes 图片的byte数组
	 * @param name 图片名称
	 * @return 返回 一个json数据 里面包好error 0表示成功 1表示失败 url表示图片地址 message表示失败的提示
	 */
	PictureResult uploadFile(byte[] bytes, String name);
}

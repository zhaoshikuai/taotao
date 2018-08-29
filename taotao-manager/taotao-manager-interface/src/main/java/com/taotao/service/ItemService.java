package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
	/**
	 * 根据商品id查询指定商品信息
	 * @param itemId 商品id
	 * @return 商品信息
	 */
	TbItem getItemById(long itemId);
	/**
	 * 根据页面传递过来的参数分页显示商品信息
	 * @param page 当前页
	 * @param rows 每一页的显示的记录条数
	 * @return 总记录条数+每一个商品信息
	 */
	EasyUIDataGridResult getItems(int page, int rows);
	/**
	 * 添加商品基本信息和描述信息
	 * @param item 基本信息
	 * @param itemDesc 描述信息
	 * @return
	 */
	TaotaoResult addItem(TbItem item, String itemDesc);
}

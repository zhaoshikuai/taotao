package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	private TbItemMapper tbItemMapper;


	@Override
	public TbItem getItemById(long itemId) {
		TbItem item = tbItemMapper.getItemById(itemId);

		return item;
	}


	@Override
	public EasyUIDataGridResult getItems(int page, int rows) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		//得到所有 商品信息
		List<TbItem> list = tbItemMapper.getTbItem();
		//取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);

		//创建返回结果对象
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		return result;
	}


	@Override
	public TaotaoResult addItem(TbItem item, String itemDesc) {
		long itemId=IDUtils.genItemId();
		//补全商品信息
		item.setId(itemId);
		//补全状态
		item.setStatus((byte) 1);
		//补全创建时间
		Date date=new Date();
		item.setCreated(date);
		//补全更新时间
		item.setUpdated(date);
		tbItemMapper.addTbItem(item);
		
		TbItemDesc desc=new TbItemDesc();
		desc.setItemId(itemId);
		desc.setCreated(date);
		desc.setUpdated(date);
		tbItemMapper.addTbItemDesc(desc);
		return TaotaoResult.ok();
	}




}

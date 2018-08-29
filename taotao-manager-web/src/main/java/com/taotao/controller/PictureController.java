package com.taotao.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.pojo.PictureResult;
import com.taotao.service.PictureService;


@Controller
@RequestMapping("/pic")
public class PictureController {
	@Autowired
	private PictureService pictureService;
	@RequestMapping("/upload")
	@ResponseBody
	public PictureResult uploda(MultipartFile uploadFile){
		
		try {
			byte[] bytes = uploadFile.getBytes();
			String name = uploadFile.getOriginalFilename();
			PictureResult result = pictureService.uploadFile(bytes, name);
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}

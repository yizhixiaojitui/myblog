package cn.broccoli.blog.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import plm.common.aop.ControllerAOP;

public class FileUtils {
	private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);
	public Map<String, String> uploadFile(MultipartFile file,HttpSession session,HttpServletRequest request) throws IllegalStateException, IOException  {
		Map<String, String> result=new HashMap<String, String>();
		//初始化新文件名字
		String realName="";
		//先判断图片是否为空
		if (file != null) {
		//获取上传文件原始完整名
		String fileName = file.getOriginalFilename();
		//获取上传原始文件后缀名
		String fileNameExtension = fileName.substring(fileName.indexOf("."), fileName.length() );
		// 生成实际存储的真实文件名
		realName = UUID.randomUUID().toString() + fileNameExtension;
		//自己定义的上传目录
		String realPath = request.getSession().getServletContext().getRealPath("/upload");
	
		logger.info("上传地址:"+realPath);
		logger.info("文件名称:"+realName);
		logger.info("文件目录:"+request.getContextPath() + "/upload/" + realName);
		//以后先创建文件夹 然后在设置目录
		File uploadFile = new File(realPath, realName);
		//允许用户利用multipart传到服务器
		file.transferTo(uploadFile);
		}
		//返回图片路径
		result.put("src", request.getContextPath() + "/upload/" + realName);
		return result;
	} 
}

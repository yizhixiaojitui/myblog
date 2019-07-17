package cn.broccoli.blog.controller;

import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import plm.common.beans.ResultBean;
import cn.broccoli.blog.utils.FileUtils;
import cn.broccoli.blog.utils.ImageResult;
import cn.broccoli.blog.utils.QiniuUtil;

@Controller
public class ApiController {

	FileUtils fileUtils = new FileUtils();

	//图片上传
	// 这个临时用户指定的自己的名称 以后从token中获取
	/**图片上传 接口
	 * @param file
	 * @param session
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value = "/api/file/article/image/upload", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<ImageResult> imageUpload(MultipartFile file, HttpSession session,
			HttpServletRequest request) throws IllegalStateException, IOException {
		return new ResultBean<ImageResult>(QiniuUtil.uploadFile(file));
	}

}

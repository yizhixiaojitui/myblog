package cn.broccoli.blog.utils;

import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.fastjson.JSONObject;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

public class QiniuUtil {
	private static final Logger logger = LoggerFactory.getLogger(QiniuUtil.class);
	
	private static final String ak = "CKdsRM-y4bg8HtNswF5a448nzKfRwGxYMvij9zmt";
	private static final String sk = "mF0tqpM7Oie4Zk_cu_BPuoELK8yemD7BU5q2iTjY";
	private static final String bucket = "kedaya"; //正式环境
    static Auth auth = Auth.create(ak, sk);
	
    private static String QINIU_IMAGE_DOMAIN= "http://image.yiduoxilanhua.cn/";
    /* 上传至 华东 */
    static Zone z = Zone.zone1();
    static Configuration c = new Configuration(z);
    // 创建上传对象
    static UploadManager uploadManager = new UploadManager(c);
    
    public static String getUpToken() {
        return auth.uploadToken(bucket);
    }
    public static ImageResult uploadFile(MultipartFile file) throws IOException {
    	ImageResult imageResult=new ImageResult();
    	String pic_type=file.getContentType();
    	if (pic_type.equals("image/jpeg") || pic_type.equals("image/png") || pic_type.equals("image/bmp")){
    		try {
    			String fileEnd = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                String fileName = UUID.randomUUID().toString().replaceAll("-", "") + fileEnd;
                logger.info("fileEnd:"+fileEnd);
                logger.info("fileName:"+fileName);
                //调用put方法上传
                Response res = uploadManager.put(file.getBytes(), fileName, getUpToken());
                if(res.isOK()&&res.isJson()) {
                	imageResult.setSrc(QINIU_IMAGE_DOMAIN + JSONObject.parseObject(res.bodyString()).get("key"));
                	
                	return imageResult;
                }
    		}catch(QiniuException e) {
    			// 请求失败时打印的异常的信息
                Response r = e.response;
                System.out.println(r.toString());
                logger.error("七牛异常2:" + e.getMessage());
                imageResult.setMsg("七牛异常："+e.getMessage());
                return imageResult;
    		}
    	}else {
    		imageResult.setMsg("非图片！");
    		return imageResult;
    	}
		return imageResult;
    	
    }
    
    
}

package com.dengzhy.common.utils;



import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * action生成验证码
 * @author dengzhy
 *
 */

public class ImageCodeAction {

	/**
	 * 
	 * @return 图片的输出流
	 */
	public static void createImageCode(HttpServletRequest request, HttpServletResponse response) {
		Map<String,BufferedImage> map = ImageUtil.createImage();
		
		String code = null;
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			code = it.next();
		}

		request.getSession().setAttribute("imageCode",code);
		
		BufferedImage image = map.get(code);
		try {

		//将图片输出给浏览器
        response.setContentType("image/png");    
        OutputStream os = response.getOutputStream();
        ImageIO.write(image, "png", os);
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}

}

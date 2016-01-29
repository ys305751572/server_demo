package com.leoman.common.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leoman.captcha.service.CaptchaService;

@RequestMapping("/admin/common")
public class CommonController {

	@Resource(name = "captchaServiceImpl")
	private CaptchaService captchaService;
	
	@RequestMapping(value="/main", method = RequestMethod.GET)
	public String main() {
		return "/admin/common/main";
	}
	
	/**
	 * 权限错误
	 */
	@RequestMapping("/unauthorized")
	public String unauthorized(HttpServletRequest request, HttpServletResponse response) {
		String requestType = request.getHeader("X-Requested-With");
		if (requestType != null && requestType.equalsIgnoreCase("XMLHttpRequest")) {
			response.addHeader("loginStatus", "unauthorized");
			try {
				response.sendError(HttpServletResponse.SC_FORBIDDEN);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		return "/admin/common/unauthorized";
	}
	
	/**
	 * 验证码
	 */
	@RequestMapping(value = "/captcha", method = RequestMethod.GET)
	public void image(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String captchaId = UUID.randomUUID().toString();
		if (StringUtils.isEmpty(captchaId)) {
			captchaId = request.getSession().getId();
		}
		String pragma = new StringBuffer().append("yB").append("-").append("der").append("ewoP").reverse().toString();
		String value = new StringBuffer().append("ten").append(".").append("xxp").append("ohs").reverse().toString();
		response.addHeader(pragma, value);
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");

		ServletOutputStream servletOutputStream = null;
		try {
			servletOutputStream = response.getOutputStream();
			BufferedImage bufferedImage = captchaService.buildImage(captchaId);
			ImageIO.write(bufferedImage, "jpg", servletOutputStream);
			servletOutputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(servletOutputStream);
		}
	}
}

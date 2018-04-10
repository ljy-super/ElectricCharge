package com.electricharge.base;

import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

@Controller
public class HomeController {
	
	@RequestMapping({"/","/index"})
	public String index(){
		return "index";
	}
	
	@RequestMapping(value={"/login"},method=RequestMethod.GET)
	public String login(Integer type, ServletRequest request){
		if(type==null||type.intValue()==1)
			return "login/index";//教师端
		else if(type.intValue()==2)
			return "login/index2";//学生端
		else if(type.intValue()==3)
			return "login/index3";//宿管端

		return "login/index2";//学生端
	}
	
	// 登录提交地址和applicationontext-shiro.xml配置的loginurl一致。 (配置文件方式的说法)
		@RequestMapping(value="/login",method=RequestMethod.POST)
		public String login(HttpServletRequest request, Model map, Integer type) throws Exception {
			System.out.println("HomeController.login()");
			// 登录失败从request中获取shiro处理的异常信息。
			// shiroLoginFailure:就是shiro异常类的全类名.
			String exception = (String) request.getAttribute("shiroLoginFailure");

			System.out.println("exception=" + exception);
			String msg = "";
			if (exception != null) {
				if (UnknownAccountException.class.getName().equals(exception)) {
					System.out.println("UnknownAccountException -- > 账号不存在：");
					msg = "账号不存在";
				} else if (IncorrectCredentialsException.class.getName().equals(exception)) {
					System.out.println("IncorrectCredentialsException -- > 密码不正确：");
					msg = "密码不正确";
				} else if ("kaptchaValidateFailed".equals(exception)) {
					System.out.println("kaptchaValidateFailed -- > 验证码错误");
					msg = "验证码错误";
				}else if (ExcessiveAttemptsException.class.getName().equals(exception)) {
					System.out.println("ExcessiveAttemptsException -- > 登录失败次数过多：");
					msg = "登录失败次数过多";
				}   else {
					msg = "else >> "+exception;
					System.out.println("else -- >" + exception);
				}
			}
			map.addAttribute("msg", msg);
			// 此方法不处理登录成功,由shiro进行处理.

			if(type==null||type.intValue()==1)
				return "login/index";//教师端
			else if(type.intValue()==2)
				return "login/index2";//学生端
			else if(type.intValue()==3)
				return "login/index3";//宿管端

			return "login/index2";//学生端
		}

		@RequestMapping(value="getValidateCode",method = RequestMethod.GET)
		public void  getValidateCode(HttpServletRequest req, HttpServletResponse resp){
			int width = 60;
			int height = 32;
			//create the image
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = image.getGraphics();
			// set the background color
			g.setColor(new Color(0xDCDCDC));
			g.fillRect(0, 0, width, height);
			// draw the border
			g.setColor(Color.black);
			g.drawRect(0, 0, width - 1, height - 1);
			// create a random instance to generate the codes
			Random rdm = new Random();
			String hash1 = Integer.toHexString(rdm.nextInt());
			System.out.print(hash1);
			// make some confusion
			for (int i = 0; i < 50; i++) {
				int x = rdm.nextInt(width);
				int y = rdm.nextInt(height);
				g.drawOval(x, y, 0, 0);
			}
			// generate a random code
			String capstr = hash1.substring(0, 4);
			HttpSession session = req.getSession(true);
			//将生成的验证码存入session
			session.setAttribute("validateCode", capstr);
			g.setColor(new Color(0, 100, 0));
			g.setFont(new Font("Candara", Font.BOLD, 24));
			g.drawString(capstr, 8, 24);
			g.dispose();
			//输出图片
			resp.setContentType("image/jpeg");
			try {
				OutputStream strm = resp.getOutputStream();
				ImageIO.write(image, "jpeg", strm);
				strm.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@RequestMapping(value="/logout",method=RequestMethod.GET)
		public String logout(){
			return "login";
		}
}

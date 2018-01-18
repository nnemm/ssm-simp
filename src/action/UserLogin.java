package action;

import javax.servlet.http.HttpSession;  


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.User;
import service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserLogin {
	
	@Autowired
	UserService ser;
	
	//转到登陆页面
	@RequestMapping("/tologin.do")
	public String toLogin(){
		
		return "login";
	}

	@RequestMapping(value="/login.do")
	public String doLogin(User user,HttpSession session){
		
		if(user !=null){
			User findUser = ser.findSelectByName(user);
			if(findUser==null){
				//重定向到登录页面
				return "redirect:tologin.do";
			}else{
				//比较密码
				if(user.getPassword().equals(findUser.getPassword())){
					//允许登录
					session.setAttribute("sessionUser", findUser);
					return "index";
				}else{
					//重定向到登录页面
					return "redirect:tologin.do";
				}
			}
		}else{
			return "redirect:tologin.do";
		}
	}
	
	
}

package nju.software.jxjs.service;

import nju.software.jxjs.dao.UserDao;
import nju.software.jxjs.model.TUser;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	
	@Autowired
	private UserDao ud;
	
	public boolean tr_signIn(TUser user){
		
		
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token =  new UsernamePasswordToken(user.getUsername(),user.getPassword());
		try{
			subject.login(token);
		}catch(Exception e){
			//验证失败
			return false;
		}
		//验证成功
		//把user放到session中
		SecurityUtils.getSubject().getSession().setAttribute("currentUser", ud.findUser(user.getUsername()));
		return true;
	}

}

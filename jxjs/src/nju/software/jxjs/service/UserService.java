package nju.software.jxjs.service;

import nju.software.jxjs.dao.UserDao;
import nju.software.jxjs.model.TUser;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService extends BaseService{
	
	@Autowired
	private UserDao ud;
	
	public boolean tr_signIn(TUser user){
		
		
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token =  new UsernamePasswordToken(user.getUsername(),user.getPassword());
		try{
			subject.login(token);
		}catch(Exception e){
			//��֤ʧ��
			return false;
		}
		//��֤�ɹ�
		//��user�ŵ�session��
		SecurityUtils.getSubject().getSession().setAttribute("currentUser", ud.findUser(user.getUsername()));
		return true;
	}

}

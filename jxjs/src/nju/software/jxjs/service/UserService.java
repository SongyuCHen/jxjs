package nju.software.jxjs.service;

import nju.software.jxjs.dao.UserDao;
import nju.software.jxjs.shiro.token.JxjsToken;
import nju.software.jxjs.view.User;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService extends BaseService{
	
	@Autowired
	private UserDao ud;
	
	public boolean tr_signIn(User user){
		
		
		Subject subject = SecurityUtils.getSubject();
		JxjsToken token =  new JxjsToken(user.getUsername(),user.getPassword());
		token.setRole(user.getRole());
		try{
			subject.login(token);
		}catch(Exception e){
			//��֤ʧ��
			return false;
		}
		//��֤�ɹ�
		//��user�ŵ�session��
		SecurityUtils.getSubject().getSession().setAttribute("currentUser", user);
		return true;
	}

}

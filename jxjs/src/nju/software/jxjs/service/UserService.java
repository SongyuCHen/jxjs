package nju.software.jxjs.service;

import java.net.InetAddress;
import java.util.List;

import nju.software.jxjs.dao.TUserDao;
import nju.software.jxjs.dao.XtglYhbDao;
import nju.software.jxjs.model.PubXtglYhb;
import nju.software.jxjs.model.TUser;
import nju.software.jxjs.shiro.token.JxjsToken;
import nju.software.jxjs.view.User;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService extends BaseService{
	
	@Autowired
	private TUserDao ud;

	@Autowired
	private XtglYhbDao yhbDao;
	
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	@SuppressWarnings("static-access")
	public boolean tr_signIn(User user){
		
		
		Subject subject = SecurityUtils.getSubject();
		JxjsToken token =  new JxjsToken(user.getUsername(),user.getPassword());
		token.setRole(user.getRole());
		String localip = "";
		InetAddress ia=null;
		try{
			ia = ia.getLocalHost();
			localip = ia.getHostAddress();
			subject.login(token);
		}catch(Exception e){

			return false;
		}

		SecurityUtils.getSubject().getSession().setAttribute("currentUser", adapt(user));
		SecurityUtils.getSubject().getSession().setAttribute("currentIP", localip);
		return true;
	}
	
	
	/**
	 * 由于有两张不一样的用户表，需转换为同一形式放进session中
	 * @param user
	 * @return
	 */
	private User adapt(User user){
		if("fayuan".equals(user.getRole())){
			PubXtglYhb yhb = yhbDao.getPubXtglYhbByYhdm(user.getUsername());
			user.setRealname(yhb.getYhmc());
		}else if("jianyu".equals(user.getRole())){
			TUser tuser = ud.findUser(user.getUsername());
			user.setRealname(tuser.getName());
		}
		return user;
		
	}
	public TUser getUserById(int yhbh){
		return ud.getUserById(yhbh);
	}
	public PubXtglYhb getYhbById(int yhbh){
		return yhbDao.findById(yhbh);
	}
	public PubXtglYhb getYhbByXM(String xm){
		List<PubXtglYhb> yhbs = yhbDao.findByYhmc(xm);
		if(yhbs != null && yhbs.size()>0)
			return yhbs.get(0);
		else
			return null;
	}


}

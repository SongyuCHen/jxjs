package nju.software.jxjs.shiro.realm;

import nju.software.jxjs.dao.UserDao;
import nju.software.jxjs.model.TUser;
import nju.software.jxjs.shiro.token.JxjsToken;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class JxjsRealm extends AuthorizingRealm{
	
	@Autowired
	private UserDao ud;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*��ȡ�˺���Ϣ*/
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username = (String) token.getPrincipal();
		String role = ((JxjsToken)token).getRole();
		SimpleAuthenticationInfo authenticationInfo = null;
		if("fayuan".equals(role)){
			TUser user = ud.findUser(username);
			if (user == null) {
				throw new UnknownAccountException();// û�ҵ��ʺ�
			}
			authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), "fayuan");
		}else if("jianyu".equals(role)){
			//待实现
		}
		return authenticationInfo;
	}

}

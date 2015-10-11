package nju.software.jxjs.shiro.token;

import org.apache.shiro.authc.UsernamePasswordToken;

public class JxjsToken extends UsernamePasswordToken{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5307221278406860455L;
	
	
	public JxjsToken(String username,String password){
		super(username,password);
	}
	
	
	private String role;


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}

}

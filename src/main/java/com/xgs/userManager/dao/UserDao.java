package com.xgs.userManager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xgs.userManager.domain.User;

/**
 * ClassName: UserDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2014年2月19日 下午3:36:21 <br/>
 * 
 * @author n-194
 * @version
 * @since JDK 1.6
 */
@Repository("userDao")
public interface UserDao extends JpaRepository<User, String> {

}

/*package com.niit.socialbackend.dao;


import java.util.List;

import com.niit.socialbackend.model.Users;


	public interface UsersDAO {

		 public boolean addUser(Users user);
		 public boolean updateOnlineStatus(Users user);
			public Users getUser(int userid);
			public boolean checkLogin(Users user);
			public List<Users> getAllUsers();
			
	}*/

package com.niit.socialbackend.dao;


	import java.util.ArrayList;

	import com.niit.socialbackend.model.Users;


	public interface UsersDAO {
		 ArrayList<Users> getAllUser();
		 public boolean saveUser(Users user);
		 public boolean updateOnlineStatus(Users user);
			public Users getUser(int userid);
			public boolean checkLogin(Users user);
			public Users getUserbyId(int uderid);
			public Users getUserbyemail(String email);
	}

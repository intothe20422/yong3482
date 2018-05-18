package org.web.todo1;


public class UserService {

	public boolean isValidUser(User user) {

		if (user.getPassword().equals("servlet")) {
			user.setName("이명박");
			return true;
		}

		return false;
	}

}

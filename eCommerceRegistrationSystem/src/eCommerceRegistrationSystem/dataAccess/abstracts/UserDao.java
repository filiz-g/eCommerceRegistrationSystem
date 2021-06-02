package eCommerceRegistrationSystem.dataAccess.abstracts;

import eCommerceRegistrationSystem.entities.concretes.User;

public interface UserDao {
	
	void register(User user);
	void login(User user);
	void confirm(User user);
	
	

}

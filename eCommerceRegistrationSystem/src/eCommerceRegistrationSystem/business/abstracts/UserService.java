package eCommerceRegistrationSystem.business.abstracts;

import eCommerceRegistrationSystem.entities.concretes.User;

public interface UserService {
	
	void register(User user);
	void login(User user);
	

}

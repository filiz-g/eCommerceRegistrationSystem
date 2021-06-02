package eCommerceRegistrationSystem;

import eCommerceRegistrationSystem.business.abstracts.UserService;
import eCommerceRegistrationSystem.business.concretes.UserManager;
import eCommerceRegistrationSystem.core.GoogleRegisterAdapter;
import eCommerceRegistrationSystem.dataAccess.concretes.HibernateUserDao;
import eCommerceRegistrationSystem.entities.concretes.User;

public class Main {

	public static void main(String[] args) {

		User user1=new User(1,"Filiz","G�l","filizz@gmail.com","0123456");
		User user2=new User(2,"F","G","filiz.com","123456");
		
		UserService userService=new UserManager(new HibernateUserDao(),new GoogleRegisterAdapter());
		userService.register(user1);
		userService.register(user2);
		
	}

}

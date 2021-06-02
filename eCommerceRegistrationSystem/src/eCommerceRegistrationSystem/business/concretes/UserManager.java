package eCommerceRegistrationSystem.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceRegistrationSystem.business.abstracts.UserService;
import eCommerceRegistrationSystem.core.GoogleService;
import eCommerceRegistrationSystem.dataAccess.abstracts.UserDao;
import eCommerceRegistrationSystem.entities.concretes.User;

public class UserManager implements UserService {
	
	private UserDao userDao;
	private GoogleService googleService;

	
	public UserManager(UserDao userDao,GoogleService googleService) {
		super();
		this.userDao = userDao;
		this.googleService=googleService;
	}

	@Override
	public void register(User user) {
		
		if(user.getFirstName().length()>=2 && user.getLastName().length() >= 2 && user.getPassword().length()>= 6 ) {
			  System.out.println("Kullanýcý baþarýlý bir þekilde kayýt oldu.");
			  
		  }else {
			 System.out.println(user.getFirstName()+" "+ user.getLastName() + " isimli kullanýcýnýn kaydý baþarýsýz.");
		  }
		
		
		  final String EMAIL_PATTERN="^[A-Za-z0-9+_.-]+@(.+)$";
		  final Pattern pattern=Pattern.compile(EMAIL_PATTERN);
		  Matcher matcher=pattern.matcher(user.getEmail());
		  
		  if(!matcher.matches()) {
			  System.out.println(user.getEmail() + " girmiþ olduðunuz eMail, eMail formatýna uygun deðildir.");
			 }
		 
		  
		
		this.userDao.register(user);
		this.googleService.registerToSystem("Kullanýcý kayýt oldu:"+ user.getFirstName() + user.getLastName());
		
	}

	@Override
	public void login(User user) {
		
	}

	
	

}

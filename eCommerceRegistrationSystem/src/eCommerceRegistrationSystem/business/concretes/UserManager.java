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
			  System.out.println("Kullan�c� ba�ar�l� bir �ekilde kay�t oldu.");
			  
		  }else {
			 System.out.println(user.getFirstName()+" "+ user.getLastName() + " isimli kullan�c�n�n kayd� ba�ar�s�z.");
		  }
		
		
		  final String EMAIL_PATTERN="^[A-Za-z0-9+_.-]+@(.+)$";
		  final Pattern pattern=Pattern.compile(EMAIL_PATTERN);
		  Matcher matcher=pattern.matcher(user.getEmail());
		  
		  if(!matcher.matches()) {
			  System.out.println(user.getEmail() + " girmi� oldu�unuz eMail, eMail format�na uygun de�ildir.");
			 }
		 
		  
		
		this.userDao.register(user);
		this.googleService.registerToSystem("Kullan�c� kay�t oldu:"+ user.getFirstName() + user.getLastName());
		
	}

	@Override
	public void login(User user) {
		
	}

	
	

}

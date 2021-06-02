package eCommerceRegistrationSystem.core;

import eCommerceRegistrationSystem.google.GoogleManager;

public class GoogleRegisterAdapter implements GoogleService {

	@Override
	public void registerToSystem(String message) {
		GoogleManager googleManager=new GoogleManager();
		googleManager.register(message);
	}

}

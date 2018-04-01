package com.workitem.workitem;

import java.util.List;

public class EmailService {
	
	
	public  void sendEmailNotification(List messages ){
		
		SendEmail sendEmail = new SendEmail();
		sendEmail.sendEmail(messages);
		
		System.out.println("email sent" + messages.get(0));
		
	}
	
	public  void sendEmail(){
		
		System.out.println("test email");
	}

	

}

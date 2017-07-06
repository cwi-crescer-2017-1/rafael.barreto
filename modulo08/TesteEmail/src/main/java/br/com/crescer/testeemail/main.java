/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.testeemail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author rafael.barreto
 */
public class main {
   
    ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");

    	MailMail mm = (MailMail) context.getBean("mailMail");
        mm.sendMail("from@no-spam.com",
    		   "to@no-spam.com",
    		   "Testing123",
    		   "Testing only \n\n Hello Spring Email Sender");

    
}

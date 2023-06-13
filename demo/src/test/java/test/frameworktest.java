package test;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import annotations.author;
import constants.LOGTYPE;
import listeners.Listener;
import reportUtilies.Logger;

//@Listeners(Listener.class)
public class frameworktest {

@author(name = "Nandhalala")
@Test
public void test1() {
	Logger.LOG(LOGTYPE.INFO, "test 1");
}

@author(name = "Nandhalala")
@Test
public void test2() {
	assertTrue(true);
	Logger.LOG(LOGTYPE.INFO, "test 2");
	assertTrue(false);
	Logger.LOG(LOGTYPE.FAIL, "intentionally failed test 2");
	
}
@author(name = "Nandhalala")
@Test
public void test3() {
	
	Logger.LOG(LOGTYPE.INFO, "test3");
	throw new SkipException("dryrun");
	
}
}

/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2016, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package edu.mum.emailservice;

import java.util.Locale;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import edu.mum.domain.Customer;

@Service("emailService")
public class EmailService {

	private static final String image = "templates/images/codeAmbassador.jpg";

	private static final String JPG_MIME = "image/jpg";
	

	@Autowired
	private JavaMailSender mailSender;

	/*
	 * Send HTML mail (simple)
	 */
	public void sendMailToCustomer(final String recipientName, final String recipientEmail,
			 final Locale locale) throws MessagingException {

	
		// Prepare message using a Spring helper
		final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
		final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		
		message.setSubject("Bank Account Successfully Created !!");
		FileSystemResource file = new FileSystemResource("D:\\Projects\\LabSolutions\\Lesson9\\AMQPconsumer\\AMQP\\src\\main\\resources\\templates\\images\\ourBank.png");
	

		message.setText("Dear, "+ recipientName
				+"\n"+ "This is to inform you that your bank account has been successfully created!!"
				+"\n"
				+"\n"
				+ "Best Regards"
				+"\n"
				+"Bank of Fairfield");
		message.addAttachment(file.getFilename(), file);
		message.setTo(recipientEmail);

	//to send mail
			this.mailSender.send(mimeMessage);

	}

}

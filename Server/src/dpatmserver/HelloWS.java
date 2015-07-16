package dpatmserver;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dnt.model.User;
import com.dnt.otp.OTPSendStrategy;
import com.dnt.otp.sender.OTPByEmail;
import com.dnt.sms.SMSFactory;
import com.dnt.sms.SMSGateway;
import com.dtn.email.EmailGateway;
import com.dtn.email.impl.DreamhostEmail;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWS {
	
	@GET
	@Path("/sms")
	public String Hello(){
		SMSGateway sms = SMSFactory.getFactory().createGateway("Twilio");
		System.out.println("call by thread " + Thread.currentThread().getId());
		sms.send("4153593067", "Hello your OTP is: fck you");
		return "{\"msg\":\"Hello World\"}";
	}
	
	@GET
	@Path("/email")
	public String HelloEmail(){
		EmailGateway email = DreamhostEmail.getInstance();
		email.sendEmail("spyjamesbond0072003@gmail.com", "hello MUM bank", "OMG email");
		email.sendHTMLEmail("spyjamesbond0072003@gmail.com", "hello html", "<b>Welcome</b> Nhu trinh", "");
		return "{\"msg\":\"Hello World\"}";
	}
	
	
	@GET
	@Path("/otp")
	public String HelloOTP(){
		OTPSendStrategy otp = new OTPByEmail();
		User tai = new User();
		tai.setEmail("hohuutai.uns@gmail.com");
		tai.setPhoneNumber("551231231");
		//otp.sendOTP(tai, "!231%#@#%");
		return "{\"msg\":\"Hello World\"}";
	}

}

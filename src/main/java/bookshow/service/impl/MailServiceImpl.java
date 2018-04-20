package bookshow.service.impl;

import bookshow.domain.movie.Ticket;
import bookshow.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

/**
 * Created by Ivan V. on 20-Apr-18
 */
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendActivationMail(String usernameToSend, String emailAdress){
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
            String htmlMsg = "<h3>Aktiviranje naloga!</h3><br>"
                    + "<div>Dobrodosli "+usernameToSend+" na nas sajt <b>ISA projekta </b></div>"
                    + "<div>Kliknite <a href ="
                    + " \"http://localhost:4200/api/accountActivation/"+usernameToSend+"\">"
                    + "<u>ovde</u></a> kako biste aktivirali vas nalog.</div>";
            mimeMessage.setContent(htmlMsg, "text/html");
            helper.setTo(emailAdress);
            helper.setSubject("Automatski generisana poruka za aktiviranje naloga");
            mailSender.send(mimeMessage);
        } catch (Exception e) {
        }
    }
    public void sendNotification(String username, String email, String message){
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
            String htmlMsg = "<h3>Obavestenje za " + username +  "!</h3><br>"
                    + "<p>" + message +" </p>";
            mimeMessage.setContent(htmlMsg, "text/html");
            helper.setTo(email);
            helper.setSubject("(book-show) Obavestenje");
            mailSender.send(mimeMessage);
        } catch (Exception e) {
        }
    }
	@Override
	public void sendSeatConfirmingMail(String username, String email, Ticket ticket) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
            String htmlMsg = "<h3>Rezervisali ste sediste!</h3><br>"
                    + "<p>" + "Pozdrav <b>"+username+"<b><br>" +" </p>"+
            		"<p>Rezervisali ste sediste za : "+ ticket.getProjection().getPlayfilm().getName()+
            		"u sali "+ ticket.getProjection().getAuditorium().getNumber()+" "
            		+ " sediste broj : "+ ticket.getSeat().getNumber()+ "</p>" + "<p> UZIVAJTE!! </p>";
            mimeMessage.setContent(htmlMsg, "text/html");
            helper.setTo(email);
            helper.setSubject("Rezerviana karta");
            mailSender.send(mimeMessage);
        } catch (Exception e) {
        }
		
	}
	@Override
	public void sendInvite(String logged, String username, String email, Ticket ticket) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
            String htmlMsg = "<h3>Dobili ste poziv!</h3><br>"
                    + "<p>" + "Pozdrav <b>"+username+"<b><br>" +" </p>"
            		+"<p> Vas prijatelj <b>" + logged + "</b> vas poziva na projekciju"+
            		"filma " + ticket.getProjection().getPlayfilm().getName()+
            		"u sali "+ ticket.getProjection().getAuditorium().getNumber()+" "
            		+ " sediste broj : "+ ticket.getSeat().getNumber()+ "</p>" +
            		"<p> Uzivajte u filmu </p>"+
            		"<p> Ukoliko zelite da ipak otkazete kartu kliknite"
            		+ "<a a href ="
                    + " \"http://localhost:4200/api/ticket/cancelReservation/"+ticket.getId()+"\"> ovde </a> </p>";
            		
            mimeMessage.setContent(htmlMsg, "text/html");
            helper.setTo(email);
            helper.setSubject("Rezerviana karta");
            mailSender.send(mimeMessage);
        } catch (Exception e) {
        }
		
	}
}

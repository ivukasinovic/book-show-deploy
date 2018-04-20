package bookshow.service;

import bookshow.domain.movie.Ticket;

/**
 * Created by Ivan V. on 20-Apr-18
 */
public interface MailService {

    void sendActivationMail(String usernameToSend, String emailAdress);

    void sendNotification(String username, String email, String message);
    
    void sendSeatConfirmingMail(String username, String email, Ticket ticket);
    
    void sendInvite(String logged, String username, String email, Ticket ticket);
}

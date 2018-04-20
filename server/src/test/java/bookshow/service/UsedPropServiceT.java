package bookshow.service;

import bookshow.domain.Bid;
import bookshow.domain.props.UsedProp;
import bookshow.domain.props.UsedPropStatus;
import bookshow.domain.users.User;
import org.hibernate.TransactionException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import java.util.Date;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertEquals;
/**
 * Created by Ivan V. on 16-Apr-18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsedPropServiceT {

    @Autowired
    UsedPropService usedPropService;
    @Autowired
    UserService userService;
    @Autowired
    BidService bidService;

    @Test
    public void testCreateUsedProp() {
        String username = "milan";
        UsedProp usedProp = new UsedProp();
        usedProp.setTitle("test titleUP");
        usedProp.setDescription("test descriptionUP");
        usedProp.setImage("image.image.image");
        Date date = new Date(2019, 6, 20, 4, 0);
        usedProp.setActiveUntil(date);
        usedPropService.createUsedProp(username, usedProp);

        UsedProp newUsedProp = usedPropService.findOne(5L);
        assertEquals(newUsedProp.getTitle(), usedProp.getTitle());
        assertEquals(newUsedProp.getDescription(), usedProp.getDescription());
        assertEquals(newUsedProp.getImage(), usedProp.getImage());

    }


    @Test(expected = ObjectOptimisticLockingFailureException.class)
    public void testApproveDecline() {
        Long usedPropId = 1L;
        String type = "approve";
        User adminFan1 = userService.findOne(1L);
        User adminFan2 = userService.findOne(2L);

        UsedProp usedProp1 = usedPropService.findOne(1L);
        UsedProp usedProp2 = usedPropService.findOne(1L);

        assertEquals(0, usedProp1.getVersion().intValue());
        assertEquals(0, usedProp2.getVersion().intValue());

        usedPropService.approveDecline(usedProp1, type, adminFan1);
        usedPropService.approveDecline(usedProp2, type,adminFan2);

    }
    @Test(expected = ObjectOptimisticLockingFailureException.class)
    public void testCreateBid(){
        Bid bid1 = bidService.findOne(1L);
        Bid bid2 = bidService.findOne(2L);
        bid2.setPrice(440);
        User author = userService.findByUsername("dejan");
        User user = userService.findOne(6L);
        UsedProp usedProp1 = usedPropService.findOne(2L);
        UsedProp usedProp2 = usedPropService.findOne(2L);

        assertEquals(0, usedProp1.getVersion().intValue());
        assertEquals(0, usedProp2.getVersion().intValue());

        usedPropService.acceptBid(author.getUsername(),usedProp1,bid1.getId());
        bidService.createEditBid(usedProp1,bid2,user);

    }

//    @Test
//    public void testAcceptBid() {
//        Long usedPropId = 2L;
//        Long acceptedBidId = 2L;
//        UsedProp usedProp = usedPropService.findOne(usedPropId);
//        usedPropService.acceptBid("dejan",usedProp, acceptedBidId);
//        UsedProp acceptedUsedProp = usedPropService.findOne(2L);
//
//        assertEquals(acceptedUsedProp.getAcceptedBid(), acceptedBidId);
//    }
}

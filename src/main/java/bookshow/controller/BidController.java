package bookshow.controller;

import bookshow.domain.Bid;
import bookshow.domain.props.UsedProp;
import bookshow.domain.users.User;
import bookshow.service.BidService;
import bookshow.service.UsedPropService;
import bookshow.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
@RestController
@RequestMapping(value = "/bids")
public class BidController {
    @Autowired
    private BidService bidService;
    @Autowired
    private UserService userService;
    @Autowired
    private UsedPropService usedPropService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Bid>> getBids() {
        List<Bid> bids = bidService.findAll();
        return new ResponseEntity<>(bids, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bid> getBid(@PathVariable("id") Long id) {
        Bid bid = bidService.findOne(id);
        return new ResponseEntity<>(bid, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/used-prop/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get bids of usedprop.", notes = "Fetch all bids of used prop with passed id ", httpMethod = "GET", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Bid.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 500, message = "Failure")})
    public ResponseEntity<List<Bid>> getBidByUsedProp(@PathVariable("id") Long id) {
        UsedProp usedProp = usedPropService.findOne(id);
        List<Bid> bids = bidService.findByUsedPropOrderByPriceDesc(usedProp);
        return new ResponseEntity<>(bids, HttpStatus.OK);
    }

    //id -> id of used prop
    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bid> createBid(Principal principal, @RequestBody Bid bid, @PathVariable("id") Long id) {
        User registeredUser = userService.findByUsername(principal.getName());
        UsedProp usedProp = usedPropService.findOne(id);
        Bid savedBid = bidService.createEditBid(usedProp,bid,registeredUser);
        if(savedBid == null){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(savedBid, HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bid> updateBid(@RequestBody Bid bid) {
        Bid updatedBid = bidService.save(bid);
        return new ResponseEntity<>(updatedBid, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bid> deleteBid(@PathVariable("id") Long id) {
        bidService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

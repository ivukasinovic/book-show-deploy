package bookshow.domain.props;

import bookshow.domain.Bid;
import bookshow.domain.users.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Ivan V. on 27-Jan-18
 */
@Entity
public class UsedProp extends Prop implements Serializable {

    @NotNull
    @Column(name = "active_until", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date activeUntil;

    @Enumerated(EnumType.STRING)
    private UsedPropStatus status;

    @Column(name="accepted_bid_fk")
    private Long acceptedBid;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "fan_admin_fk")
    @ManyToOne(optional = true)
    private User fanAdmin;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "username")
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "user_fk")
    @ManyToOne(optional = false)
    private User user;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usedProp", cascade = CascadeType.REMOVE)
    private List<Bid> bids;

    private int accesstime;


    public UsedProp() {
    }

    public Date getActiveUntil() {
        return activeUntil;
    }

    public void setActiveUntil(Date activeUntil) {
        this.activeUntil = activeUntil;
    }

    public UsedPropStatus getStatus() {
        return status;
    }

    public void setStatus(UsedPropStatus status) {
        this.status = status;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    public Long getAcceptedBid() {
        return acceptedBid;
    }

    public void setAcceptedBid(Long acceptedBid) {
        this.acceptedBid = acceptedBid;
    }

    public User getFanAdmin() {
        return fanAdmin;
    }

    public void setFanAdmin(User fanAdmin) {
        this.fanAdmin = fanAdmin;
    }

    public int getAccesstime() {
        return accesstime;
    }

    public void setAccesstime(int accesstime) {
        this.accesstime = accesstime;
    }
}

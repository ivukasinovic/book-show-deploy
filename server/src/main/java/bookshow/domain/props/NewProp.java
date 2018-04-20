package bookshow.domain.props;

import bookshow.domain.Show;
import bookshow.domain.users.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.io.Serializable;

/**
 * Created by Ivan V. on 28-Jan-18
 */
@Entity
public class NewProp extends Prop implements Serializable {

    @DecimalMax(value="1000000", inclusive=false)
    @DecimalMin(value ="1")
    @Column(nullable = false)
    private double price;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "username")
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "fan_admin_fk")
    @ManyToOne(optional = false)
    private User fanAdmin;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "username")
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "user_fk")
    @ManyToOne(optional = true)
    private User user;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "name")
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "show_fk")
    @ManyToOne(optional = false)
    private Show show;

    public NewProp() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getFanAdmin() {
        return fanAdmin;
    }

    public void setFanAdmin(User fanAdmin) {
        this.fanAdmin = fanAdmin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

}


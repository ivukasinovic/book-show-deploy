package bookshow.domain.props;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

/**
 * Created by Ivan V. on 27-Jan-18
 */
@Entity
@Inheritance(strategy = TABLE_PER_CLASS)
public abstract class Prop {

    @Id
    //@GeneratedValue(strategy = GenerationType.TABLE)
    //resava problem prilikom unosa jer mysql ne generise sam nove id
    @GenericGenerator(name = "announcement", strategy = "increment")
    @GeneratedValue(generator = "announcement")
    @Column(nullable = false)
    private Long id;

    @NotEmpty
    @Size(min=3, max=30)
    @Column(nullable = false)
    private String title;

    @Size(min=3, max=120)
    @NotEmpty
    @Column
    private String description;

    @Column
    private String image;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Version
    private Long version;


    public Prop() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String url) {
        this.image = url;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}

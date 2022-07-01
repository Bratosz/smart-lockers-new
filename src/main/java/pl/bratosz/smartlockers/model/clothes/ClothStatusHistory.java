package pl.bratosz.smartlockers.model.clothes;

import com.fasterxml.jackson.annotation.JsonView;
import pl.bratosz.smartlockers.model.Views;
import pl.bratosz.smartlockers.model.users.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ClothStatusHistory {
    //mainorder function is to say, where the cloth is, is it returned/released or whatever
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JsonView({Views.InternalForEmployees.class, Views.InternalForBoxes.class})
    private ClothStatus status;
    @JsonView({Views.InternalForEmployees.class, Views.InternalForBoxes.class})
    private ClothDestination clothDestination;
    @ManyToOne
    private User user;
    private LocalDateTime dateOfUpdate;
    @ManyToOne
    private Cloth cloth;
    private AdditionalStatusInfo additionalStatusInfo;

    public ClothStatusHistory() {
    }

    public ClothStatusHistory(ClothStatus status,
                              ClothDestination clothDestination,
                              Cloth cloth,
                              User user,
                              LocalDateTime dateOfUpdate) {
        this.status = status;
        this.clothDestination = clothDestination;
        this.cloth = cloth;
        this.user = user;
        this.dateOfUpdate = dateOfUpdate;
    }

    public ClothStatusHistory(ClothStatus status,
                              ClothDestination clothDestination,
                              User user,
                              LocalDateTime dateOfUpdate) {
        this.status = status;
        this.clothDestination = clothDestination;
        this.user = user;
        this.dateOfUpdate = dateOfUpdate;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ClothDestination getClothDestination() {
        return clothDestination;
    }

    public void setClothDestination(ClothDestination clothDestination) {
        this.clothDestination = clothDestination;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDateOfUpdate() {
        return dateOfUpdate;
    }

    public void setDateOfUpdate(LocalDateTime dateOfUpdate) {
        this.dateOfUpdate = dateOfUpdate;
    }

    public AdditionalStatusInfo getAdditionalStatusInfo() {
        return additionalStatusInfo;
    }

    public void setAdditionalStatusInfo(AdditionalStatusInfo additionalStatusInfo) {
        this.additionalStatusInfo = additionalStatusInfo;
    }

    public Cloth getCloth() {
        return cloth;
    }

    public void setCloth(Cloth cloth) {
        this.cloth = cloth;
    }

    public void setStatus(ClothStatus status) {
        this.status = status;
    }

    public ClothStatus getStatus() {
        if(status == null) {
            return ClothStatus.UNKNOWN;
        } else {
            return status;
        }
    }


}

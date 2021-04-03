package com.practicalddd.cargotracker.bookingms.domain.model.valueobjects;

import com.practicalddd.cargotracker.bookingms.domain.model.entities.Location;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Leg {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Voyage voyage;
    @Embedded
    @AttributeOverride(name = "unLocCode", column = @Column(name = "load_location_id"))
    private Location loadLocation;
    @Embedded
    @AttributeOverride(name = "unLocCode", column = @Column(name = "unload_location_id"))
    private Location unloadLocation;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "load_time")
    @NotNull
    private Date loadTime;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "unload_time")
    @NotNull
    private Date unloadTime;

    public Leg(){}

    public Leg(Voyage voyage,Location loadLocation,
               Location unloadLocation,Date loadTime, Date unloadTime){
        this.voyage = voyage;
        this.loadLocation = loadLocation;
        this.unloadLocation = unloadLocation;
        this.loadTime = loadTime;
        this.unloadTime = unloadTime;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Voyage getVoyage() {
        return voyage;
    }

    public void setVoyage(Voyage voyage) {
        this.voyage = voyage;
    }

    public Location getLoadLocation() {
        return loadLocation;
    }

    public void setLoadLocation(Location loadLocation) {
        this.loadLocation = loadLocation;
    }

    public Location getUnloadLocation() {
        return unloadLocation;
    }

    public void setUnloadLocation(Location unloadLocation) {
        this.unloadLocation = unloadLocation;
    }

    public Date getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(Date loadTime) {
        this.loadTime = loadTime;
    }

    public Date getUnloadTime() {
        return unloadTime;
    }

    public void setUnloadTime(Date unloadTime) {
        this.unloadTime = unloadTime;
    }
}

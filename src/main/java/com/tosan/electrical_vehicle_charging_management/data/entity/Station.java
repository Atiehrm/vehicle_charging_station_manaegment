package com.tosan.electrical_vehicle_charging_management.data.entity;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author arm
 */
@Entity
@Data
@Builder
@RequiredArgsConstructor
public class Station {
    @Id
    private long id;
    @Column(nullable = false, unique = true)
    private String name;
    private double latitude;
    private double longitude;
    @JoinColumn
    @ManyToOne
    private ParentCompany company;

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", company=" + company +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Station)) return false;
        Station station = (Station) o;
        return id == station.id && name.equals(station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

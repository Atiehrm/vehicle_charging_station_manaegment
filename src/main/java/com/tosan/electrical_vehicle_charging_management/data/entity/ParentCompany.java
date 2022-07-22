package com.tosan.electrical_vehicle_charging_management.data.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author arm
 */
@Entity
@Builder
@RequiredArgsConstructor
@Table(name = "company")
@Setter
@Getter
public class ParentCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @OneToMany
    private Set<ParentCompany> branch = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private Set<Station> stationSet = new HashSet<>();

    @Override
    public String toString() {
        return "ParentCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", branch=" + branch +
                ", stationSet=" + stationSet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParentCompany)) return false;
        ParentCompany that = (ParentCompany) o;
        return id.equals(that.id) && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

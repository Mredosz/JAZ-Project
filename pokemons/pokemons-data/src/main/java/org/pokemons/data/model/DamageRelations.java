package org.pokemons.data.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class DamageRelations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany
    private List<Type> doubleDamageFrom = new ArrayList<>();
    @ManyToMany
    private List<Type> doubleDamageTo = new ArrayList<>();
    @ManyToMany
    private List<Type> halfDamageFrom = new ArrayList<>();
    @ManyToMany
    private List<Type> halfDamageTo = new ArrayList<>();
    @ManyToMany
    private List<Type> noDamageFrom = new ArrayList<>();
    @ManyToMany
    private List<Type> noDamageTo = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Type> getDoubleDamageFrom() {
        return doubleDamageFrom;
    }

    public void setDoubleDamageFrom(List<Type> doubleDamageFrom) {
        this.doubleDamageFrom = doubleDamageFrom;
    }

    public List<Type> getDoubleDamageTo() {
        return doubleDamageTo;
    }

    public void setDoubleDamageTo(List<Type> doubleDamageTo) {
        this.doubleDamageTo = doubleDamageTo;
    }

    public List<Type> getHalfDamageFrom() {
        return halfDamageFrom;
    }

    public void setHalfDamageFrom(List<Type> halfDamageFrom) {
        this.halfDamageFrom = halfDamageFrom;
    }

    public List<Type> getHalfDamageTo() {
        return halfDamageTo;
    }

    public void setHalfDamageTo(List<Type> halfDamageTo) {
        this.halfDamageTo = halfDamageTo;
    }

    public List<Type> getNoDamageFrom() {
        return noDamageFrom;
    }

    public void setNoDamageFrom(List<Type> noDamageFrom) {
        this.noDamageFrom = noDamageFrom;
    }

    public List<Type> getNoDamageTo() {
        return noDamageTo;
    }

    public void setNoDamageTo(List<Type> noDamageTo) {
        this.noDamageTo = noDamageTo;
    }
}

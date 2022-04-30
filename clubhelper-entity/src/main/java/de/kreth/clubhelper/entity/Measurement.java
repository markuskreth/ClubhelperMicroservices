package de.kreth.clubhelper.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.kreth.clubhelper.data.MeasurementType;

@Entity
@Table(name = "measurement")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Measurement extends BaseEntity implements Serializable, PersonRelated {

    private static final long serialVersionUID = -6753603877379153647L;

    @JsonIgnore
    @ManyToOne
    private Person person;

    private LocalDateTime onTime;
    private MeasurementType measurementType;
    private String classification;
    private double measured;

    public LocalDateTime getOnTime() {
	return onTime;
    }

    public void setOnTime(LocalDateTime onTime) {
	this.onTime = onTime;
    }

    public MeasurementType getMeasurementType() {
	return measurementType;
    }

    public void setMeasurementType(MeasurementType measurementType) {
	this.measurementType = measurementType;
    }

    public String getClassification() {
	return classification;
    }

    public void setClassification(String classification) {
	this.classification = classification;
    }

    public double getMeasured() {
	return measured;
    }

    public void setMeasured(double measured) {
	this.measured = measured;
    }

    @Override
    public Person getPerson() {
	return person;
    }

    @Override
    public void setPerson(Person person) {
	this.person = person;
    }

}

package de.kreth.clubhelper.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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
    @Column(name = "measurement_type")
    @Enumerated(EnumType.STRING)
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

    @Override
    public String toString() {
	return "Measurement [measurementType=" + measurementType + ", classification=" + classification + ", measured="
		+ measured + ", person=" + person + "]";
    }

}

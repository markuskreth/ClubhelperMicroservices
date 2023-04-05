package de.kreth.clubhelper.data;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Measurement extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1180061264146581246L;

	private LocalDateTime onTime;
	private MeasurementType measurementType = MeasurementType.JumpHeightSeconds;
	private String classification = "";
	private double measured;

	public LocalDateTime getOnTime() {
		return onTime;
	}

	public void setOnTime(LocalDateTime onTime) {
		this.onTime = onTime;
	}

	/**
	 * Never null
	 *
	 * @return
	 */
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
	public String toString() {
		return "Measurement [classification=" + classification + ", onTime=" + onTime + ", measured=" + measured + "]";
	}

}

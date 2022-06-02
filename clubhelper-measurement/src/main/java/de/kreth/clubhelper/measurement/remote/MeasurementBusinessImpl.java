package de.kreth.clubhelper.measurement.remote;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import de.kreth.clubhelper.data.Measurement;
import de.kreth.clubhelper.vaadincomponents.remote.BusinessImpl;

@Service
public class MeasurementBusinessImpl extends BusinessImpl implements MeasurementBusiness {

    private final RestTemplate webClient;

    public MeasurementBusinessImpl(@Autowired RestTemplate webClient) {
	super(webClient);
	this.webClient = webClient;
    }

    @Override
    public List<Measurement> getMeasurementsFor(Long personId) {

	String url = getApiUrl() + "/measurement/for/" + personId;
	Measurement[] list = webClient.getForObject(url, Measurement[].class);
	return Arrays.asList(list);
    }

    @Override
    public Measurement getMeasurement(Long measurementId) {
	String url = getApiUrl() + "/measurement/" + measurementId;
	Measurement measurement = webClient.getForObject(url, Measurement.class);
	return measurement;
    }

    @Override
    public Measurement store(Long personId, Measurement measurement) {
	// TODO Auto-generated method stub
	return null;
    }

}

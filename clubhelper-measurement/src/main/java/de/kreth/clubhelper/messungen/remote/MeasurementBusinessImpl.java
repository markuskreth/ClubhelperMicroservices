package de.kreth.clubhelper.messungen.remote;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import de.kreth.clubhelper.data.Measurement;
import de.kreth.clubhelper.data.MeasurementType;
import de.kreth.clubhelper.data.OrderBy;
import de.kreth.clubhelper.data.Person;

@Service
public class MeasurementBusinessImpl extends de.kreth.clubhelper.vaadincomponents.remote.BusinessImpl
	implements MeasurementBusiness {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    private RestTemplate webClient;

    @Value("${resourceserver.api.url}")
    private String apiUrl;

    public MeasurementBusinessImpl(@Autowired RestTemplate webClient) {
	super(webClient);
	this.webClient = webClient;
    }

    @Override
    public List<Person> getPersons(OrderBy order) {

	String url = apiUrl + "/person";
	if (order != null) {
	    url += "/ordered/" + order.name();
	}
	Person[] list = webClient.getForObject(url, Person[].class);
	return Arrays.asList(list);
    }

    @Override
    public List<Measurement> getMeasurements(Long forPersonId) {
	String url = apiUrl + "/measurement/for/" + forPersonId;
	Measurement[] list = webClient.getForObject(url, Measurement[].class);
	return Arrays.asList(list);
    }

    @Override
    public Authentication getCurrent() {
	return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public Measurement store(Long personId, Measurement measurement) {
	String url = apiUrl + "/measurement/for/" + personId;
	Measurement result;
	if (measurement.getId() == null || measurement.getId() < 0) {
	    result = webClient.postForObject(url, measurement, Measurement.class);
	} else {
	    webClient.put(url, measurement);
	    result = webClient.getForObject(apiUrl + "/measurement/" + measurement.getId(), Measurement.class);
	}
	return result;
    }

    @Override
    public Map<MeasurementType, Set<String>> getAllTypes() {
	String url = apiUrl + "/measurement/types";

	@SuppressWarnings("unchecked")
	Map<MeasurementType, Set<String>> types = webClient.getForObject(url, Map.class);
	return types;
    }

}

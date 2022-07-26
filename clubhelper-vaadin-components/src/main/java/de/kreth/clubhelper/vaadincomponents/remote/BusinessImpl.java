package de.kreth.clubhelper.vaadincomponents.remote;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import de.kreth.clubhelper.data.GroupDef;
import de.kreth.clubhelper.data.Person;

@Service
public class BusinessImpl implements Business {

    private final RestTemplate webClient;

    @Value("${resourceserver.api.url}")
    private String apiUrl;

    public BusinessImpl(@Autowired RestTemplate webClient) {
	this.webClient = webClient;
    }

    public void setApiUrl(String apiUrl) {
	this.apiUrl = apiUrl;
    }

    public String getApiUrl() {
	return apiUrl;
    }

    @Override
    public List<Person> getPersons() {
	String url = apiUrl + "/person";
	Person[] list = webClient.getForObject(url, Person[].class);
	return Arrays.asList(list);
    }

    @Cacheable("groups")
    @Override
    public List<GroupDef> getAllGroups() {
	String url = apiUrl + "/group";
	GroupDef[] forObject = webClient.getForObject(url, GroupDef[].class);
	return Arrays.asList(forObject);
    }

    @Override
    public Person getPerson(Long personId) {
	String url = apiUrl + "/person/" + personId;
	Person person = webClient.getForObject(url, Person.class);
	return person;
    }

}

package com.domainapi.springboot.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;


@Component
public class DomainApiService {

	private static Map<String,Integer>  domainURL = new HashMap<String,Integer>();
	static {
		
		//Initialize default data
		domainURL.put("google.com", 3);
		
	}
	
	public List<String> retrievHighestDomain() {
		System.out.println("inside retrievHighestDomain.. domainURL count " +domainURL.size());
		
		Map<String, Integer> result = domainURL.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		List<String> domains = result.keySet().stream().limit(3).collect(Collectors.toList());
		
		return domains;
	}

	public Map addDomainUrlWithCount(String url, int count) {
		System.out.println("inside addDomainUrlWithCount.. domainURL count " +domainURL.size());
		if(!domainURL.isEmpty())
		{
			System.out.println(domainURL.containsKey(url));
			if(domainURL.containsKey(url))
			{
				Integer urlCount = domainURL.get(url);
				domainURL.put(url, urlCount+count);
		
			}else
			{
				domainURL.put(url, count);
			}
		}		
		
	 return domainURL;
	}

}
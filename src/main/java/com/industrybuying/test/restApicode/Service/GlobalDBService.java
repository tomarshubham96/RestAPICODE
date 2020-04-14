package com.industrybuying.test.restApicode.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.industrybuying.test.restApicode.Entity.GlobalDB;
import com.industrybuying.test.restApicode.Repos.GlobalDBRepository;

@Service
public class GlobalDBService {

	@Autowired
	private GlobalDBRepository globaldbRepository;
	 
	
	public List<GlobalDB> getAllGlobalDBEntriesService(){		
		List globaldbentries = new ArrayList<>();
		
		globaldbRepository.findAll().forEach(globaldbentries::add);
		
		return globaldbentries;
	}
	
	public GlobalDB getGlobalDBEntryService(String gdbphoneNumber) {
		
	    return globaldbRepository.findById(gdbphoneNumber).get();
	}

	public void addGlobalDBEntryService(GlobalDB globaldbentry) {
		globaldbRepository.save(globaldbentry);
	}

	public void updateGlobalDBEntryService(String gdbphoneNumber,GlobalDB globaldbentry) {
		globaldbRepository.save(globaldbentry);
	}

	public void markSpam(String gdbphoneNumber) {
		
		GlobalDB globaldbentry = globaldbRepository.getOne(gdbphoneNumber);
		globaldbentry.setSpam(true);
		globaldbRepository.save(globaldbentry);
	}

	public List<GlobalDB> searchByName(String gdbName) {
		
		List<GlobalDB> globalDBEntires1 = new ArrayList<>();
		List<GlobalDB> globalDBEntires2 = new ArrayList<>();
		
		globalDBEntires1.addAll((globaldbRepository.findByGdbNameStartingWithIgnoreCase(gdbName)));
		
        globalDBEntires2.addAll((globaldbRepository.findByGdbNameContainingIgnoreCase(gdbName)));
        
        for(GlobalDB globaldbentry: globalDBEntires2 ) {
        	if(!globalDBEntires1.contains(globaldbentry))
        		globalDBEntires1.add(globaldbentry);
        	}
        
		return globalDBEntires1;
	}

	public GlobalDB searchByNumber(String gdbNumber) {
        
		return globaldbRepository.findById(gdbNumber).get();
	}
}

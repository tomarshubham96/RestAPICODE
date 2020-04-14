package com.industrybuying.test.restApicode.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.industrybuying.test.restApicode.Entity.GlobalDB;
import com.industrybuying.test.restApicode.Entity.User;
import com.industrybuying.test.restApicode.Service.GlobalDBService;
import com.industrybuying.test.restApicode.Service.UserService;

@RestController
public class GlobalDBController {

	@Autowired
	private GlobalDBService globaldbService;
	
	@Autowired
	private UserService userService;

	@RequestMapping("/gdbEntries")
	public List<GlobalDB> getAllGlobalDBEntries() {
		return globaldbService.getAllGlobalDBEntriesService();
	}
	
	@RequestMapping("/gdbEntries/{gdbphoneNumber}")
	public GlobalDB getGlobalDB(@PathVariable String gdbphoneNumber) {
		return globaldbService.getGlobalDBEntryService(gdbphoneNumber);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/gdbEntries/{gdbphoneNumber}")
	public void addGlobalDB(@RequestBody GlobalDB globaldbEntry) {
		
		globaldbService.addGlobalDBEntryService(globaldbEntry);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/gdbEntries/{gdbphoneNumber}")
	public void updateGlobalDBEntry(@PathVariable String gdbphoneNumber, @RequestBody GlobalDB globaldbEntry) {
		
		globaldbService.updateGlobalDBEntryService(gdbphoneNumber,globaldbEntry);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/users/spam/{gdbphoneNumber}")
	public void setSpam(@PathVariable String gdbphoneNumber) {
		
		globaldbService.markSpam(gdbphoneNumber);
	}
	
	@RequestMapping("/users/searchByName/{gdbName}")
	public List<GlobalDB> searchByName(@PathVariable String gdbName) {
		
		return globaldbService.searchByName(gdbName);
	}
	
	@RequestMapping("/users/searchByNumber/{gdbNumber}")
	public GlobalDB searchByNumber(@PathVariable String gdbNumber) {
		
		return globaldbService.searchByNumber(gdbNumber);
	}
}

package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bean.StuData;
import com.repo.StuRepo;

@Service
public class StuService {

	
	
	@Autowired
	StuRepo repo;
	
	public StuData getBYId(int id) {
		
		Optional<StuData> data = repo.findById(id);
		
		if(data.isEmpty()) {
			return null;
		}else {
		return data.get();
		}
	}

	public ResponseEntity<String> saveData(StuData data) {
		
		StuData res = repo.save(data);
		
		
		if(res!=null) {
			
			return ResponseEntity.ok("student"
					+ " data inserted sucessfully /n student ID "+res.getId());
		}else {
			
			return ResponseEntity.ok("not saved");
		}
	}
	
	public List<StuData> getByNameArea(String name,String area) {
		return repo.getByNameArea(name, area);
	}
	
	public int updateName(String name,int id){
		return repo.updateName(id,name);
	}
	
	public int updateArea(String area,int id){
	    return repo.updateArea(id, area);
	}
	
	
}

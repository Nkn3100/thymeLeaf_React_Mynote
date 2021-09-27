package com.example.demo.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import com.example.demo.dto.DataDTO;
import com.example.demo.entity.Data;
import com.example.demo.repository.DataRepository;
@Transactional
@Service(value = "dataService")
public class DataService {
	@Autowired
	private DataRepository dataRepository;
	
	
//	 public List<Data> extractData(){
//		 Iterable<Data> datalist= dataRepository.findAll();
//		
//		 List<Data> list=new ArrayList<>();
//		
//		 for (Data d : datalist) {
//			 DataDTO dataDTO= new DataDTO();
//			 dataDTO.setName(d.getName());
//			 dataDTO.setEmail(d.getEmail());
//				list.add(dataDTO);
//			}
//		 return list;
//	 }
	 public List<Data> getNotes(){
		 return (List<Data>) dataRepository.findAll();
	 }
	 public Data getNoteById(String title){
		 Optional<Data> ext=dataRepository.findById(title);
		 Data newData = new Data();
		 newData.setTitle(ext.get().getTitle());
		 newData.setNote(ext.get().getNote());
		 return newData;
	 }
	 public String addNote(Data data) {
		 Data newData = new Data();
		 newData.setTitle(data.getTitle());
		 newData.setNote(data.getNote());
		 dataRepository.save(newData);
		 
		 return newData.getTitle();
		 
	 }
	 public String editNote(Data data) {
		 
		 Optional<Data> ext=dataRepository.findById(data.getTitle());
		 ext.get().setNote(data.getNote());
	//	 ext.setName(data.getName());
	//	 dataRepository.save(ext.get());
		 return ext.get().getTitle();
	//	 if(data.getEmail()=)
	//	 Data newData = new Data();
		 
		 
	 }
	 public String deleteData(String title) {
		dataRepository.deleteById(title);
		return title;
		 
	 }
	 public String deleteData1(String title) {
		dataRepository.deleteById(title);
		return title;
		 
	 }
	
	
}
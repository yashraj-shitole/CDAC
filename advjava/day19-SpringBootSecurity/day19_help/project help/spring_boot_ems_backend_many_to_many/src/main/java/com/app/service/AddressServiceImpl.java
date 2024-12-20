package com.app.service;

import java.lang.reflect.Field;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.AddressDTO;
import com.app.dto.ApiResponse;
import com.app.entities.Address;
import com.app.entities.Employee;
import com.app.repository.AddressRepository;
import com.app.repository.EmployeeRepository;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private AddressRepository adrRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public AddressDTO getAddressDetails(long addressId) {
		// TODO Auto-generated method stub
		return mapper.map(adrRepo.findById(addressId).orElseThrow(
				() -> new ResourceNotFoundException("Either Emp doesn't exist OR address not yet assigned !!!!")),
				AddressDTO.class);
	}

	@Override
	public ApiResponse assignEmpAddress(@NotNull Long empId, @Valid AddressDTO address) {
//		Employee employee = empRepo.findById(empId)
//				.orElseThrow(() -> new ResourceNotFoundException("Emp details do not exist : Invalid Emp ID!!!"));
		// Spring Data JPA : lazy loading method : getReferenceById
		Employee employee = empRepo.getReferenceById(empId);// NOTE : this method DOES NOT hit DB with select query(i.e
															// works in LAZY manner) : rets a proxy of the entity
		// It's sufficient for establishing uni asso. adr --> emp
		// map dto --> entity
		Address addressEntity = mapper.map(address, Address.class);
		// establish uni dir link , adr ---> emp
		addressEntity.setOwner(employee);
		// save adr details
		adrRepo.save(addressEntity);
		return new ApiResponse("Assigned new address to Emp");// , " + employee.getFirstName());
	}

	@Override
	public ApiResponse updateEmpAddress(@NotNull Long empId,
			@Valid AddressDTO address) {
		Employee employee = empRepo.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Emp ID!!!"));
		// map dtp --> entity
		Address addressEntity = mapper.map(address, Address.class);
		// establish un dir link , adr ---> emp
		addressEntity.setOwner(employee);
		addressEntity.setId(empId);
		// save adr details
		adrRepo.save(addressEntity);//update 
		return new ApiResponse("Updated address for  Emp , " + employee.getFirstName());

	}

	@Override
	public AddressDTO patchEmpAddress(@NotNull Long empId,
			Map<String, Object> map) {
		System.out.println("map "+map);
		// chk if adr exists
		Address address = adrRepo.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Address Id!!!!"));
//		map.forEach((name, value) -> {
//			Field field = ReflectionUtils.findField(Address.class,name);
//			field.setAccessible(true);
//			ReflectionUtils.setField(field, address, value);
//		});
		//address : persistent entity with old adr(existing in db)
		//maps src object(Map<K,V> of updated fields --> dest object --entity) : by calling setters
		mapper.map(map, address);//setters : one per map entry
		System.out.println("updated address " + address);
		return mapper.map(address, AddressDTO.class);
	}//Hibernate : update query

	@Override
	public ApiResponse deleteAddressDetails(Long empId) {
		Address address = adrRepo.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist!!!!"));
		adrRepo.delete(address);
		return new ApiResponse("Address details deleted for emp id=" + empId);
	}

}

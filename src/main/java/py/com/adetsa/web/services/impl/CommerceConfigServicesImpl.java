package py.com.adetsa.web.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.com.adetsa.db.domain.CommerceConfigEntity;
import py.com.adetsa.db.repository.CommerceConfigRepository;
import py.com.adetsa.dto.CommerceConfigDto;
import py.com.adetsa.dto.PageableDto;
import py.com.adetsa.dto.enums.EntityReferencesStatusEnum;
import py.com.adetsa.exception.LotteryInvocationException;
import py.com.adetsa.util.DateHelper;
import py.com.adetsa.web.services.CommerceConfigServices;
import py.com.adetsa.web.services.CommercesServices;

@Service
public class CommerceConfigServicesImpl implements CommerceConfigServices {

	private static final Logger logger = LoggerFactory.getLogger(CommerceConfigServicesImpl.class);

	@Autowired
	CommerceConfigRepository repository;
	
	@Autowired
	CommercesServices commerceServices;

	@Override
	public PageableDto<CommerceConfigDto> findAllConfigByPages(Integer page, Integer perPage)
			throws LotteryInvocationException {
		logger.info("#findAllConfigByPages - request");
		Pageable pageable = PageRequest.of(page, perPage, Sort.by("id").ascending());
		Page<CommerceConfigEntity> allPage = repository.findAll(pageable);
		PageableDto<CommerceConfigDto> pageableDto = new PageableDto<CommerceConfigDto>();
		List<CommerceConfigEntity> all = allPage.toList();

		List<CommerceConfigDto> dtoList = CommerceConfigDto.toListDTO(all);
		for (CommerceConfigDto dto : dtoList) {
			if (Optional.ofNullable(dto.getCommerceCode()).isPresent()) {
				dto.setCommerceDto(commerceServices.findCommerceById(dto.getCommerceCode()));	
			}
		}
		BeanUtils.copyProperties(allPage, pageableDto);
		pageableDto.setContent(dtoList);
		logger.info("#findAllConfigByPages - response - pageableDto: {}", pageableDto);
		return pageableDto;
	}

	@Override
	public CommerceConfigDto save(CommerceConfigDto dto) throws LotteryInvocationException {
		logger.info("#save - request - dto: {}", dto);
		dto.setCreatedAt(DateHelper.getCurrentDate());
		CommerceConfigEntity entity = CommerceConfigDto.toENTITY(dto);
		if (Optional.ofNullable(dto.getBackgroundImage()).isPresent()) {
			entity.setBackgroundImage(dto.getBackgroundImage());
		}

		if (Optional.ofNullable(dto.getLogo1()).isPresent()) {
			entity.setLogo1(dto.getLogo1());
		}

		if (Optional.ofNullable(dto.getLogo2()).isPresent()) {
			entity.setLogo2(dto.getLogo2());
		}
		CommerceConfigEntity saved = repository.save(entity);
		
		CommerceConfigDto response = CommerceConfigDto.toDTO(saved);
		if (Optional.ofNullable(response.getCommerceCode()).isPresent()) {
			response.setCommerceDto(commerceServices.findCommerceById(response.getCommerceCode()));	
		}
		logger.info("#save - response: {}", response);
		return response;
	}

	@Override
	public List<CommerceConfigDto> saveList(List<CommerceConfigDto> listDto) throws LotteryInvocationException {
		logger.info("#saveList - request - list: {}", listDto);
		listDto.forEach(setter -> {
			setter.setCreatedAt(DateHelper.getCurrentDate());
		});
		List<CommerceConfigEntity> entityList = CommerceConfigDto.toListENTITY(listDto);
		List<CommerceConfigEntity> savedList = repository.saveAll(entityList);
		logger.info("#saveList - response - savedList: {}", savedList);
		List<CommerceConfigDto> response = CommerceConfigDto.toListDTO(savedList);
		for (CommerceConfigDto dto : response) {
			if (Optional.ofNullable(dto.getCommerceCode()).isPresent()) {
				dto.setCommerceDto(commerceServices.findCommerceById(dto.getCommerceCode()));	
			}
		}
		logger.info("#saveList - response: {}", response);
		return response;
	}

	@Override
	public CommerceConfigDto findByCommerceCode(Long commerceCode) throws LotteryInvocationException {
		// logger.info("#findByChannelCode - request - commerceCode: {}", commerceCode);
		Optional<CommerceConfigEntity> optional = repository.findByCommerceCode(commerceCode);
		CommerceConfigEntity entity = optional.orElse(new CommerceConfigEntity());
		CommerceConfigDto dto = CommerceConfigDto.toDTO(entity);
		if (Optional.ofNullable(dto.getCommerceCode()).isPresent()) {
			dto.setCommerceDto(commerceServices.findCommerceById(dto.getCommerceCode()));	
		}
		logger.info("#findByChannelCode - response - dto: {}", dto);
		return dto;
	}

	@Override
	public List<CommerceConfigDto> findByStatus(String status) throws LotteryInvocationException {
		logger.info("#findByStatus - request - status: {}", status);
		Optional<List<CommerceConfigEntity>> optional = repository.findByStatus(status);
		List<CommerceConfigEntity> entityList = optional.orElse(new ArrayList<CommerceConfigEntity>());
		List<CommerceConfigDto> response = CommerceConfigDto.toListDTO(entityList);
		for (CommerceConfigDto dto : response) {
			if (Optional.ofNullable(dto.getCommerceCode()).isPresent()) {
				dto.setCommerceDto(commerceServices.findCommerceById(dto.getCommerceCode()));	
			}
		}
		logger.info("#findByStatus - response: {}", response);
		return response;
	}

	@Override
	public List<CommerceConfigDto> findActive() throws LotteryInvocationException {
		logger.info("#findActive - request");
		List<CommerceConfigDto> dtoList = findByStatus(EntityReferencesStatusEnum.A.getCod());
		return dtoList;
	}

	@Override
	public List<CommerceConfigDto> findAll() throws LotteryInvocationException {
		logger.info("#findAll - request");
		List<CommerceConfigEntity> entityList = repository.findAll(Sort.by("id").ascending());
		List<CommerceConfigDto> response = CommerceConfigDto.toListDTO(entityList);
		logger.info("#findAll - response: {}", response);
		for (CommerceConfigDto dto : response) {
			if (Optional.ofNullable(dto.getCommerceCode()).isPresent()) {
				dto.setCommerceDto(commerceServices.findCommerceById(dto.getCommerceCode()));	
			}
		}
		return response;
	}

	@Override
	@Transactional(value = "lotteryTransactionManager")
	public CommerceConfigDto update(Long id, CommerceConfigDto dto) throws LotteryInvocationException {
		logger.info("#update - request - id: {} - dto: {}", id, dto);
		CommerceConfigDto response = new CommerceConfigDto();
		Optional<CommerceConfigEntity> o = repository.findById(id);
		if (o.isPresent()) {
			CommerceConfigEntity entity = o.orElseThrow(null);
			entity.setCommerceCode(dto.getCommerceCode());
			entity.setMainColor(dto.getMainColor());
			entity.setSecondaryColor(dto.getSecondaryColor());
			entity.setStatus(dto.getStatus());

			if (Optional.ofNullable(dto.getBackgroundImage()).isPresent()) {
				entity.setBackgroundImage(dto.getBackgroundImage());
			}

			if (Optional.ofNullable(dto.getLogo1()).isPresent()) {
				entity.setLogo1(dto.getLogo1());
			}

			if (Optional.ofNullable(dto.getLogo2()).isPresent()) {
				entity.setLogo2(dto.getLogo2());
			}

			CommerceConfigEntity updated = repository.save(entity);
			response = CommerceConfigDto.toDTO(updated);
			
			if (Optional.ofNullable(response.getCommerceCode()).isPresent()) {
				response.setCommerceDto(commerceServices.findCommerceById(response.getCommerceCode()));	
			}
		}
		logger.info("#update - response - response: {}", response);
		return response;
	}

	@Override
	public void deleteById(Long id) throws LotteryInvocationException {
		logger.info("#deleteById - id: {}", id);
		repository.deleteById(id);
		logger.info("#deleteById - response");
	}
}
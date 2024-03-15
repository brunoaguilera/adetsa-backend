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

import py.com.adetsa.db.domain.Get023Entity;
import py.com.adetsa.db.domain.Get024Entity;
import py.com.adetsa.db.domain.Get024Id;
import py.com.adetsa.db.repository.Get023Repository;
import py.com.adetsa.db.repository.Get024Repository;
import py.com.adetsa.dto.CommerceConfigDto;
import py.com.adetsa.dto.Get023Dto;
import py.com.adetsa.dto.Get024Dto;
import py.com.adetsa.dto.PageableDto;
import py.com.adetsa.exception.LotteryInvocationException;
import py.com.adetsa.web.services.CommerceConfigServices;
import py.com.adetsa.web.services.CommercesServices;

@Service
public class CommercesServicesImpl implements CommercesServices {

	private static final Logger logger = LoggerFactory.getLogger(CommercesServicesImpl.class);

	@Autowired
	Get023Repository commercesRepository;

	@Autowired
	Get024Repository branchRepository;

	@Autowired
	CommerceConfigServices commerceConfigServices;

	@Override
	public Get023Dto findCommerceById(Long commerceId) throws LotteryInvocationException {
		logger.info("#findCommerceById - request - commerceId: {}", commerceId);
		Optional<Get023Entity> optional = commercesRepository.findByCommerceId(commerceId);
		Get023Entity entity = optional.orElse(new Get023Entity());
		Get023Dto dto = Get023Dto.toDTO(entity);
		return dto;
	}

	@Override
	public PageableDto<Get023Dto> findAllCommerceByPages(Integer page, Integer perPage) throws LotteryInvocationException {
		logger.info("#findAllCommerceByPages - request");
		Pageable pageable = PageRequest.of(page, perPage, Sort.by("ge23clicod").ascending());
		Page<Get023Entity> allPage = commercesRepository.findAll(pageable);
		PageableDto<Get023Dto> pageableDto = new PageableDto<Get023Dto>();
		List<Get023Entity> all = allPage.toList();

		List<Get023Dto> dtoList = Get023Dto.toListDTO(all);
		BeanUtils.copyProperties(allPage, pageableDto);
		pageableDto.setContent(dtoList);
		logger.info("#findAllCommerceByPages - response - pageableDto: {}", pageableDto);
		return pageableDto;
	}

	@Override
	public PageableDto<Get024Dto> findAllBranchByPages(Integer page, Integer perPage) throws LotteryInvocationException {
		logger.info("#findAllBranchByPages - request");
		Pageable pageable = PageRequest.of(page, perPage, Sort.by("id").ascending());
		Page<Get024Entity> allPage = branchRepository.findAll(pageable);
		PageableDto<Get024Dto> pageableDto = new PageableDto<Get024Dto>();
		List<Get024Entity> all = allPage.toList();

		List<Get024Dto> dtoList = Get024Dto.toListDTO(all);
		BeanUtils.copyProperties(allPage, pageableDto);
		pageableDto.setContent(dtoList);
		logger.info("#findAllBranchByPages - response - pageableDto: {}", pageableDto);
		return pageableDto;
	}

	@Override
	public Get023Dto findCommerceByRUC(String commerceRUC) throws LotteryInvocationException {
		logger.info("#findCommerceByRUC - request - commerceId: {}", commerceRUC);
		Optional<Get023Entity> optional = commercesRepository.findByRUC(commerceRUC);
		Get023Entity entity = optional.orElse(new Get023Entity());
		Get023Dto dto = Get023Dto.toDTO(entity);
		logger.info("#findCommerceByRUC - response - dto: {}", dto);
		return dto;
	}

	@Override
	public List<Get023Dto> findAllCommerceActive() throws LotteryInvocationException {
		logger.info("#findAllCommerceActive - request");
		List<Get023Entity> entityList = commercesRepository.findAll(Sort.by("ge23clicod").ascending());
		List<Get023Dto> dtoList = Get023Dto.toListDTO(entityList);
		logger.info("#findAllCommerceActive - response - dtoList: {}", dtoList);
		return dtoList;
	}

	@Override
	public List<Get023Dto> findAllCommerce() throws LotteryInvocationException {
		logger.info("#findAllCommerce - request");
		List<Get023Entity> entityList = commercesRepository.findAll(Sort.by("ge23clicod").ascending());
		List<Get023Dto> dtoList = Get023Dto.toListDTO(entityList);
		logger.info("#findAllCommerce - response - dtoList: {}", dtoList);
		return dtoList;
	}

	@Override
	public List<Get024Dto> findBranchByCommerceId(Long commerceId) throws LotteryInvocationException {
		logger.info("#findBranchByCommerceId - request - commerceId: {}", commerceId);
		Optional<List<Get024Entity>> optional = branchRepository.findByCommerceId(commerceId);
		List<Get024Entity> entityList = optional.orElse(new ArrayList<Get024Entity>());
		List<Get024Dto> dtoList = Get024Dto.toListDTO(entityList);
		logger.info("#findBranchByCommerceId - response - dtoList: {}", dtoList);
		return dtoList;
	}

	@Override
	public List<Get024Dto> findBranchBySWCod(Long swCode) throws LotteryInvocationException {
		logger.info("#findBranchBySWCod - request - swCode: {}", swCode);
		Optional<List<Get024Entity>> optional = branchRepository.findBySWCod(swCode);
		List<Get024Entity> entityList = optional.orElse(new ArrayList<Get024Entity>());
		List<Get024Dto> dtoList = Get024Dto.toListDTO(entityList);
		logger.info("#findBranchBySWCod - response - dtoList: {}", dtoList);
		return dtoList;
	}
	
	@Override
	public List<Get024Dto> findAllBranchActive() throws LotteryInvocationException {
		logger.info("#findAllBranchActive - request");
		Optional<List<Get024Entity>> optional = branchRepository.findAllBranchActive();
		List<Get024Entity> entityList = optional.orElse(new ArrayList<Get024Entity>());
		List<Get024Dto> dtoList = Get024Dto.toListDTO(entityList);
		logger.info("#findAllBranchActive - response - dtoList: {}", dtoList);
		return dtoList;
	}

	@Override
	public List<Get024Dto> findAllBranch() throws LotteryInvocationException {
		logger.info("#findAllBranch - request");
		List<Get024Entity> entityList = branchRepository.findAll(Sort.by("id").ascending());
		List<Get024Dto> dtoList = Get024Dto.toListDTO(entityList);
		logger.info("#findAllBranch - response - dtoList: {}", dtoList);
		return dtoList;
	}

	@Override
	public Get024Dto findBranchById(Long commerceId, Long branchId) throws LotteryInvocationException {
		logger.info("#findBranchById - request - commerceId: {} - branchId: {}", commerceId, branchId);
		Get024Id id = new Get024Id(commerceId, branchId);
		Optional<Get024Entity> optional = branchRepository.findByEmbeddedId(id);
		Get024Entity entity = optional.orElse(new Get024Entity());
		Get024Dto dto = Get024Dto.toDTO(entity);
		logger.info("#findBranchById - response - dto: {}", dto);
		return dto;
	}

	@Override
	public CommerceConfigDto findCommerceConfigByCommerceId(Long commerceId) throws LotteryInvocationException {
		logger.info("#findCommerceConfigByCommerceId - request - commerceId: {}", commerceId);
		CommerceConfigDto dto = commerceConfigServices.findByCommerceCode(commerceId);
		logger.info("#findCommerceConfigByCommerceId - response - dto: {}", dto);
		return dto;
	}
}
package py.com.adetsa.web.services;

import java.util.List;

import py.com.adetsa.dto.CommerceConfigDto;
import py.com.adetsa.dto.Get023Dto;
import py.com.adetsa.dto.Get024Dto;
import py.com.adetsa.dto.PageableDto;
import py.com.adetsa.exception.LotteryInvocationException;

public interface CommercesServices {

	Get023Dto findCommerceById(Long commerceId) throws LotteryInvocationException;

	Get023Dto findCommerceByRUC(String commerceRUC) throws LotteryInvocationException;

	PageableDto<Get023Dto> findAllCommerceByPages(Integer page, Integer perPage) throws LotteryInvocationException;

	List<Get023Dto> findAllCommerceActive() throws LotteryInvocationException;

	List<Get023Dto> findAllCommerce() throws LotteryInvocationException;

	PageableDto<Get024Dto> findAllBranchByPages(Integer page, Integer perPage) throws LotteryInvocationException;

	List<Get024Dto> findBranchByCommerceId(Long commerceId) throws LotteryInvocationException;

	List<Get024Dto> findBranchBySWCod(Long swCode) throws LotteryInvocationException;
	
	List<Get024Dto> findAllBranchActive() throws LotteryInvocationException;

	List<Get024Dto> findAllBranch() throws LotteryInvocationException;

	Get024Dto findBranchById(Long commerceId, Long branchId) throws LotteryInvocationException;

	CommerceConfigDto findCommerceConfigByCommerceId(Long commerceId) throws LotteryInvocationException;
}
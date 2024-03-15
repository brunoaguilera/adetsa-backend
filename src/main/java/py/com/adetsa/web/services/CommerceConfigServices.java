package py.com.adetsa.web.services;

import java.util.List;

import py.com.adetsa.dto.CommerceConfigDto;
import py.com.adetsa.dto.PageableDto;
import py.com.adetsa.exception.LotteryInvocationException;

public interface CommerceConfigServices {

	PageableDto<CommerceConfigDto> findAllConfigByPages(Integer page, Integer perPage) throws LotteryInvocationException;

	CommerceConfigDto save(CommerceConfigDto dto) throws LotteryInvocationException;

	List<CommerceConfigDto> saveList(List<CommerceConfigDto> listDto) throws LotteryInvocationException;

	CommerceConfigDto findByCommerceCode(Long commerceCode) throws LotteryInvocationException;

	List<CommerceConfigDto> findByStatus(String status) throws LotteryInvocationException;

	List<CommerceConfigDto> findActive() throws LotteryInvocationException;

	List<CommerceConfigDto> findAll() throws LotteryInvocationException;
	
	CommerceConfigDto update(Long id, CommerceConfigDto dto) throws LotteryInvocationException;

	void deleteById(Long id) throws LotteryInvocationException;
}
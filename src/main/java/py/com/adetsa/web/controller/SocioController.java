package py.com.adetsa.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import py.com.adetsa.db.domain.PartnerCandidatosEntity;
import py.com.adetsa.db.domain.PartnerEntity;
import py.com.adetsa.db.domain.PartnerUtilityEntity;
import py.com.adetsa.db.repository.PartnerCandidatosRepository;
import py.com.adetsa.db.repository.PartnerRepository;
import py.com.adetsa.db.repository.PartnerUtilityRepository;
import py.com.adetsa.dto.ActualizaSocioRequest;
import py.com.adetsa.dto.ActualizaSocioVotoRequest;
import py.com.adetsa.dto.CommerceConfigDto;
import py.com.adetsa.dto.PartnerCandidatosDto;
import py.com.adetsa.dto.PartnerDto;
import py.com.adetsa.dto.PartnerUtilityDto;
import py.com.adetsa.exception.LotteryApplicationException;
import py.com.adetsa.exception.LotteryInvocationException;
import py.com.adetsa.web.services.CommercesServices;

@RestController
@RequestMapping("/socios")
@CrossOrigin(originPatterns = "*")
public class SocioController {

	private static final Logger logger = LoggerFactory.getLogger(SocioController.class);

	@Autowired
	CommercesServices commercesServices;

	@Autowired
	PartnerUtilityRepository partnerUtilityRepository;

	@Autowired
	PartnerRepository partnerRepository;

	@Autowired
	PartnerCandidatosRepository partnerCandidatosRepository;

	@GetMapping(value = "/utility/partner-cod/{partnerCod}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PartnerUtilityDto> consultaSocioUtility(@PathVariable Long partnerCod)
			throws LotteryInvocationException {
		logger.info("#consultaSocioUtility - partnerCod: {} - ci: {}", partnerCod);

		PartnerUtilityDto response = new PartnerUtilityDto();
		Optional<PartnerUtilityEntity> optional = partnerUtilityRepository.findByPartnerCod(partnerCod);
		PartnerUtilityEntity entity = optional.orElse(new PartnerUtilityEntity());

		logger.info("#consultaSocioUtility - response - entity: {}", entity);

		if (!Optional.ofNullable(entity.getPartnerCod()).isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			response = PartnerUtilityDto.toDTO(entity);
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/find-all-partner", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PartnerUtilityDto>> findAllPartner(
			@RequestParam(value = "partnerNumber", defaultValue = "0") Long partnerNumber)
			throws LotteryInvocationException {
		logger.info("#findAllPartner - partnerNumber: {}", partnerNumber);

		List<PartnerUtilityDto> response = new ArrayList<PartnerUtilityDto>();
		List<PartnerUtilityEntity> entityList = new ArrayList<>();

		if (!Optional.ofNullable(partnerNumber).isPresent() || partnerNumber == 0) {
			entityList = partnerUtilityRepository.findAll();
		} else {
			Optional<PartnerUtilityEntity> optional = partnerUtilityRepository.findByPartnerCod(partnerNumber);
			PartnerUtilityEntity entity = optional.orElse(new PartnerUtilityEntity());
			entityList.add(entity);
		}

		logger.info("#findAllPartner - response - entityList: {}", entityList);

		response = PartnerUtilityDto.toListDTO(entityList);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/image-background/{commerce-code}", produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> findImageBackground(@PathVariable(name = "commerce-code") Long commerceId)
			throws LotteryInvocationException, LotteryApplicationException, IOException {
		logger.info("#findImageBackground - REQUEST");
		CommerceConfigDto dto = commercesServices.findCommerceConfigByCommerceId(commerceId);

		if (dto.getBackgroundImage() != null) {
			logger.info("#findImageBackground - RESPONSE - multipartFile");
			return ResponseEntity.ok().body(dto.getBackgroundImage());
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/actualiza_datos_utilidad")
	public ResponseEntity<PartnerUtilityDto> actualizaDatosUtilidad(@RequestBody ActualizaSocioRequest request)
			throws NumberFormatException, LotteryInvocationException {
		logger.info("#actualizaDatosUtilidad - request: {}", request);

		int rows = partnerUtilityRepository.updateWithdrawMoney(request.getPartnerCod(), request.getWithdrawMoney());

		if (rows == 0) {
			return ResponseEntity.notFound().build();
		}

		PartnerUtilityDto response = new PartnerUtilityDto();
		Optional<PartnerUtilityEntity> optional = partnerUtilityRepository
				.findByPartnerCod(Long.valueOf(request.getPartnerCod()));
		PartnerUtilityEntity entity = optional.orElse(new PartnerUtilityEntity());

		logger.info("#actualizaDatosUtilidad - response - entity: {}", entity);

		if (!Optional.ofNullable(entity.getPartnerCod()).isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			response = PartnerUtilityDto.toDTO(entity);
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/partner-cod/{partnerCod}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PartnerDto> consultaSocio(@PathVariable Long partnerCod) throws LotteryInvocationException {
		logger.info("#consultaSocio - partnerCod: {} - ci: {}", partnerCod);

		PartnerDto response = new PartnerDto();
		Optional<PartnerEntity> optional = partnerRepository.findByPartnerCod(partnerCod);
		PartnerEntity entity = optional.orElse(new PartnerEntity());

		logger.info("#consultaSocio - response - entity: {}", entity);

		if (!Optional.ofNullable(entity.getPartnerCod()).isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			response = PartnerDto.toDTO(entity);
		}
		return ResponseEntity.ok(response);
	}

	@PostMapping("/actualiza_datos_voto")
	public ResponseEntity<PartnerDto> actualizaDatosVoto(@RequestBody ActualizaSocioVotoRequest request)
			throws NumberFormatException, LotteryInvocationException {
		logger.info("#actualizaDatosUtilidad - request: {}", request);

		int rows = partnerRepository.updateVoto(request.getPartnerCod(), request.getPartnerCodVoto());

		if (rows == 0) {
			return ResponseEntity.notFound().build();
		}

		PartnerDto response = new PartnerDto();
		Optional<PartnerEntity> optional = partnerRepository.findByPartnerCod(Long.valueOf(request.getPartnerCod()));
		PartnerEntity entity = optional.orElse(new PartnerEntity());

		logger.info("#actualizaDatosUtilidad - response - entity: {}", entity);

		if (!Optional.ofNullable(entity.getPartnerCod()).isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			response = PartnerDto.toDTO(entity);
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/candidatos/partner-cod/{partnerCod}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PartnerCandidatosDto> consultaSocioCandidato(@PathVariable Long partnerCod)
			throws LotteryInvocationException {
		logger.info("#consultaSocioCandidato - partnerCod: {} - ci: {}", partnerCod);

		PartnerCandidatosDto response = new PartnerCandidatosDto();
		Optional<PartnerCandidatosEntity> optional = partnerCandidatosRepository.findByPartnerCod(partnerCod);
		PartnerCandidatosEntity entity = optional.orElse(new PartnerCandidatosEntity());

		logger.info("#consultaSocioCandidato - response - entity: {}", entity);

		if (!Optional.ofNullable(entity.getPartnerCod()).isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			response = PartnerCandidatosDto.toDTO(entity);
			Optional<PartnerEntity> optionalPartner = partnerRepository
					.findByPartnerCod(Long.valueOf(response.getPartnerCod()));
			PartnerEntity entityPartner = optionalPartner.orElse(new PartnerEntity());
			if (!Optional.ofNullable(entityPartner.getPartnerCod()).isPresent()) {
				response.setPartner(PartnerDto.toDTO(entityPartner));
			}
			Long cantidad = partnerRepository.sumVotosByPartnerCod(Long.valueOf(response.getPartnerCod()));
			if (cantidad == null) {
				cantidad = 0L;
			}
			response.setCantidadVotos(cantidad);

		}
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/candidatos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PartnerCandidatosDto>> consultaSociosCandidatos() throws LotteryInvocationException {
		logger.info("#consultaSociosCandidatos");

		List<PartnerCandidatosDto> response = new ArrayList<>();
		List<PartnerCandidatosEntity> entityList = partnerCandidatosRepository.findAllCandidatos();

		logger.info("#consultaSociosCandidatos - response - entity: {}", entityList);

		if (!Optional.ofNullable(entityList).isPresent() || entityList.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {

			logger.info("#consultaSociosCandidatos - va entrar en for");

			for (PartnerCandidatosEntity entity : entityList) {
				logger.info("#consultaSociosCandidatos - Entrar en for - entity: {}", entity);
				PartnerCandidatosDto dto = new PartnerCandidatosDto();
				dto = PartnerCandidatosDto.toDTO(entity);
				logger.info("#consultaSociosCandidatos - Entrar en for - dto: {}", dto);
				Optional<PartnerEntity> optionalPartner = partnerRepository
						.findByPartnerCod(Long.valueOf(dto.getPartnerCod()));
				PartnerEntity entityPartner = optionalPartner.orElse(new PartnerEntity());
				logger.info("#consultaSociosCandidatos - Entrar en for - entityPartner: {}", entityPartner);
				if (Optional.ofNullable(entityPartner.getPartnerCod()).isPresent()) {
					dto.setPartner(PartnerDto.toDTO(entityPartner));
				}
				Long cantidadVotos = partnerRepository.sumVotosByPartnerCod(Long.valueOf(dto.getPartnerCod()));
				if (cantidadVotos == null) {
					cantidadVotos = 0L;
				}
				dto.setCantidadVotos(cantidadVotos);
				response.add(dto);
			}

		}
		logger.info("#consultaSociosCandidatos - response: {}", response);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/insertcandidato/{partnerCod}")
	public ResponseEntity<PartnerDto> insertaCandidato(@PathVariable Long partnerCod)
			throws NumberFormatException, LotteryInvocationException {
		logger.info("#insertaCandidato - partnerCod: {}", partnerCod);

		Optional<PartnerEntity> optionalPartnerEntity = partnerRepository.findByPartnerCod(partnerCod);
		PartnerEntity partnerEntity = optionalPartnerEntity.orElse(new PartnerEntity());

		if (!Optional.ofNullable(partnerEntity).isPresent()
				|| !Optional.ofNullable(partnerEntity.getId()).isPresent()) {
			return ResponseEntity.notFound().build();
		}

		int rows = partnerCandidatosRepository.insertaCandidato(partnerEntity.getPartnerCod());

		if (rows == 0) {
			return ResponseEntity.notFound().build();
		}

		PartnerDto response = new PartnerDto();
		Optional<PartnerEntity> optional = partnerRepository.findByPartnerCod(partnerCod);
		PartnerEntity entity = optional.orElse(new PartnerEntity());

		logger.info("#insertaCandidato - response - entity: {}", entity);

		if (!Optional.ofNullable(entity.getPartnerCod()).isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			response = PartnerDto.toDTO(entity);
		}
		return ResponseEntity.ok(response);
	}

	@PostMapping("/deletecandidato/{partnerCod}")
	public ResponseEntity<PartnerDto> deleteCandidato(@PathVariable Long partnerCod)
			throws NumberFormatException, LotteryInvocationException {
		logger.info("#deleteCandidato - partnerCod: {}", partnerCod);

		Optional<PartnerEntity> optionalPartnerEntity = partnerRepository.findByPartnerCod(partnerCod);
		PartnerEntity partnerEntity = optionalPartnerEntity.orElse(new PartnerEntity());

		if (!Optional.ofNullable(partnerEntity).isPresent()
				|| !Optional.ofNullable(partnerEntity.getId()).isPresent()) {
			return ResponseEntity.notFound().build();
		}

		int rows = partnerCandidatosRepository.deleteCandidato(partnerEntity.getPartnerCod());

		if (rows == 0) {
			return ResponseEntity.notFound().build();
		}

		int rowsNullVotos = partnerRepository.updateNullVotados(partnerEntity.getPartnerCod());
		logger.info("#deleteCandidato - se han puesto a null {} votos para el candidato {}", rowsNullVotos, partnerEntity.partnerName);

		PartnerDto response = new PartnerDto();

		if (!Optional.ofNullable(partnerEntity.getPartnerCod()).isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			response = PartnerDto.toDTO(partnerEntity);
		}
		logger.info("#deleteCandidato - response: {}", response);
		return ResponseEntity.ok(response);
	}
}
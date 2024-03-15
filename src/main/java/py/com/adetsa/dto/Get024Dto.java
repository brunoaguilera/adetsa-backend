package py.com.adetsa.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import py.com.adetsa.db.domain.Get024Entity;
import py.com.adetsa.db.domain.Get024Id;
import py.com.adetsa.validate.CommerceValidate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "ge23clicod", "ge24clisuc", "ge24clisno", "ge24clisdi", "ge24paicnu", "ge24dptcnu", "ge24ciucod",
		"ge24zoncod", "ge24fpacal", "ge24empcod", "ge24succod", "ge24rubid", "ge24mercod", "ge24telnro" })
public class Get024Dto {

	@JsonProperty(value = "ge23clicod")
	private Long ge23clicod;

	@JsonProperty(value = "ge24clisuc")
	private Long ge24clisuc;

	@JsonProperty(value = "ge24clisno")
	private String ge24clisno;

	@JsonProperty(value = "ge24clisdi")
	private String ge24clisdi;

	@JsonProperty(value = "ge24paicnu")
	private Integer ge24paicnu;

	@JsonProperty(value = "ge24dptcnu")
	private Integer ge24dptcnu;

	@JsonProperty(value = "ge24ciucod")
	private Integer ge24ciucod;

	@JsonProperty(value = "ge24fhoupd")
	private Date ge24fhoupd;

	@JsonProperty(value = "ge24usuupd")
	private String ge24usuupd;

	@JsonProperty(value = "ge24zoncod")
	private Integer ge24zoncod;

	@JsonProperty(value = "ge24fpacal")
	private String ge24fpacal;

	@JsonProperty(value = "ge24empcod")
	private Integer ge24empcod;

	@JsonProperty(value = "ge24succod")
	private Integer ge24succod;

	@JsonProperty(value = "ge24rubid")
	private Integer ge24rubid;

	@JsonProperty(value = "ge24mercod")
	private Integer ge24mercod;

	@JsonProperty(value = "ge24telnro")
	private String ge24telnro;

	@JsonProperty(value = "ge24faxnro")
	private String ge24faxnro;

	@JsonProperty(value = "ge24codpro")
	private Long ge24codpro;

	@JsonProperty(value = "ge24codswi")
	private Long ge24codswi;

	@JsonProperty(value = "ge24cliraz")
	private String ge24cliraz;

	@JsonProperty(value = "ge24cliruc")
	private String ge24cliruc;

	@JsonProperty(value = "ge24stspro")
	private String ge24stspro;

	@JsonProperty(value = "ge24stsswi")
	private String ge24stsswi;

	@JsonProperty(value = "ge24mspcod")
	private Integer ge24mspcod;

	@JsonProperty(value = "ge24mspobs")
	private String ge24mspobs;

	@JsonProperty(value = "ge24msscod")
	private Integer ge24msscod;

	@JsonProperty(value = "ge24mssobs")
	private String ge24mssobs;

	@JsonProperty(value = "ge24tcscod")
	private String ge24tcscod;

	@JsonProperty(value = "ge24mspfh")
	private Date ge24mspfh;

	@JsonProperty(value = "ge24mssfh")
	private Date ge24mssfh;

	@JsonProperty(value = "ge24cat")
	private Integer ge24cat;

	@JsonProperty(value = "ge24usuing")
	private String ge24usuing;

	@JsonProperty(value = "ge24fhing")
	private Date ge24fhing;

	@JsonProperty(value = "ge24fchprf")
	private String ge24fchprf;

	@JsonProperty(value = "ge24fchem")
	private String ge24fchem;

	@JsonProperty(value = "ge24modraz")
	private String ge24modraz;

	@JsonProperty(value = "ge24fchpos")
	private String ge24fchpos;

	@JsonProperty(value = "ge24coucod")
	private Integer ge24coucod;

	@JsonProperty(value = "ge24zcocod")
	private String ge24zcocod;

	@JsonProperty(value = "ge24casmat")
	private String ge24casmat;

	@JsonProperty(value = "ge24ecogru")
	private String ge24ecogru;

	@JsonIgnore
	private Map<String, Object> additionalData = new HashMap<>();

	public Long getGe23clicod() {
		return ge23clicod;
	}

	public void setGe23clicod(Long ge23clicod) {
		this.ge23clicod = ge23clicod;
	}

	public Long getGe24clisuc() {
		return ge24clisuc;
	}

	public void setGe24clisuc(Long ge24clisuc) {
		this.ge24clisuc = ge24clisuc;
	}

	public String getGe24clisno() {
		return ge24clisno;
	}

	public void setGe24clisno(String ge24clisno) {
		this.ge24clisno = ge24clisno;
	}

	public String getGe24clisdi() {
		return ge24clisdi;
	}

	public void setGe24clisdi(String ge24clisdi) {
		this.ge24clisdi = ge24clisdi;
	}

	public Integer getGe24paicnu() {
		return ge24paicnu;
	}

	public void setGe24paicnu(Integer ge24paicnu) {
		this.ge24paicnu = ge24paicnu;
	}

	public Integer getGe24dptcnu() {
		return ge24dptcnu;
	}

	public void setGe24dptcnu(Integer ge24dptcnu) {
		this.ge24dptcnu = ge24dptcnu;
	}

	public Integer getGe24ciucod() {
		return ge24ciucod;
	}

	public void setGe24ciucod(Integer ge24ciucod) {
		this.ge24ciucod = ge24ciucod;
	}

	public Date getGe24fhoupd() {
		return ge24fhoupd;
	}

	public void setGe24fhoupd(Date ge24fhoupd) {
		this.ge24fhoupd = ge24fhoupd;
	}

	public String getGe24usuupd() {
		return ge24usuupd;
	}

	public void setGe24usuupd(String ge24usuupd) {
		this.ge24usuupd = ge24usuupd;
	}

	public Integer getGe24zoncod() {
		return ge24zoncod;
	}

	public void setGe24zoncod(Integer ge24zoncod) {
		this.ge24zoncod = ge24zoncod;
	}

	public String getGe24fpacal() {
		return ge24fpacal;
	}

	public void setGe24fpacal(String ge24fpacal) {
		this.ge24fpacal = ge24fpacal;
	}

	public Integer getGe24empcod() {
		return ge24empcod;
	}

	public void setGe24empcod(Integer ge24empcod) {
		this.ge24empcod = ge24empcod;
	}

	public Integer getGe24succod() {
		return ge24succod;
	}

	public void setGe24succod(Integer ge24succod) {
		this.ge24succod = ge24succod;
	}

	public Integer getGe24rubid() {
		return ge24rubid;
	}

	public void setGe24rubid(Integer ge24rubid) {
		this.ge24rubid = ge24rubid;
	}

	public Integer getGe24mercod() {
		return ge24mercod;
	}

	public void setGe24mercod(Integer ge24mercod) {
		this.ge24mercod = ge24mercod;
	}

	public String getGe24telnro() {
		return ge24telnro;
	}

	public void setGe24telnro(String ge24telnro) {
		this.ge24telnro = ge24telnro;
	}

	public String getGe24faxnro() {
		return ge24faxnro;
	}

	public void setGe24faxnro(String ge24faxnro) {
		this.ge24faxnro = ge24faxnro;
	}

	public Long getGe24codpro() {
		return ge24codpro;
	}

	public void setGe24codpro(Long ge24codpro) {
		this.ge24codpro = ge24codpro;
	}

	public Long getGe24codswi() {
		return ge24codswi;
	}

	public void setGe24codswi(Long ge24codswi) {
		this.ge24codswi = ge24codswi;
	}

	public String getGe24cliraz() {
		return ge24cliraz;
	}

	public void setGe24cliraz(String ge24cliraz) {
		this.ge24cliraz = ge24cliraz;
	}

	public String getGe24cliruc() {
		return ge24cliruc;
	}

	public void setGe24cliruc(String ge24cliruc) {
		this.ge24cliruc = ge24cliruc;
	}

	public String getGe24stspro() {
		return ge24stspro;
	}

	public void setGe24stspro(String ge24stspro) {
		this.ge24stspro = ge24stspro;
	}

	public String getGe24stsswi() {
		return ge24stsswi;
	}

	public void setGe24stsswi(String ge24stsswi) {
		this.ge24stsswi = ge24stsswi;
	}

	public Integer getGe24mspcod() {
		return ge24mspcod;
	}

	public void setGe24mspcod(Integer ge24mspcod) {
		this.ge24mspcod = ge24mspcod;
	}

	public String getGe24mspobs() {
		return ge24mspobs;
	}

	public void setGe24mspobs(String ge24mspobs) {
		this.ge24mspobs = ge24mspobs;
	}

	public Integer getGe24msscod() {
		return ge24msscod;
	}

	public void setGe24msscod(Integer ge24msscod) {
		this.ge24msscod = ge24msscod;
	}

	public String getGe24mssobs() {
		return ge24mssobs;
	}

	public void setGe24mssobs(String ge24mssobs) {
		this.ge24mssobs = ge24mssobs;
	}

	public String getGe24tcscod() {
		return ge24tcscod;
	}

	public void setGe24tcscod(String ge24tcscod) {
		this.ge24tcscod = ge24tcscod;
	}

	public Date getGe24mspfh() {
		return ge24mspfh;
	}

	public void setGe24mspfh(Date ge24mspfh) {
		this.ge24mspfh = ge24mspfh;
	}

	public Date getGe24mssfh() {
		return ge24mssfh;
	}

	public void setGe24mssfh(Date ge24mssfh) {
		this.ge24mssfh = ge24mssfh;
	}

	public Integer getGe24cat() {
		return ge24cat;
	}

	public void setGe24cat(Integer ge24cat) {
		this.ge24cat = ge24cat;
	}

	public String getGe24usuing() {
		return ge24usuing;
	}

	public void setGe24usuing(String ge24usuing) {
		this.ge24usuing = ge24usuing;
	}

	public Date getGe24fhing() {
		return ge24fhing;
	}

	public void setGe24fhing(Date ge24fhing) {
		this.ge24fhing = ge24fhing;
	}

	public String getGe24fchprf() {
		return ge24fchprf;
	}

	public void setGe24fchprf(String ge24fchprf) {
		this.ge24fchprf = ge24fchprf;
	}

	public String getGe24fchem() {
		return ge24fchem;
	}

	public void setGe24fchem(String ge24fchem) {
		this.ge24fchem = ge24fchem;
	}

	public String getGe24modraz() {
		return ge24modraz;
	}

	public void setGe24modraz(String ge24modraz) {
		this.ge24modraz = ge24modraz;
	}

	public String getGe24fchpos() {
		return ge24fchpos;
	}

	public void setGe24fchpos(String ge24fchpos) {
		this.ge24fchpos = ge24fchpos;
	}

	public Integer getGe24coucod() {
		return ge24coucod;
	}

	public void setGe24coucod(Integer ge24coucod) {
		this.ge24coucod = ge24coucod;
	}

	public String getGe24zcocod() {
		return ge24zcocod;
	}

	public void setGe24zcocod(String ge24zcocod) {
		this.ge24zcocod = ge24zcocod;
	}

	public String getGe24casmat() {
		return ge24casmat;
	}

	public void setGe24casmat(String ge24casmat) {
		this.ge24casmat = ge24casmat;
	}

	public String getGe24ecogru() {
		return ge24ecogru;
	}

	public void setGe24ecogru(String ge24ecogru) {
		this.ge24ecogru = ge24ecogru;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalData;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalData.put(name, value);
	}

	public static Get024Dto toDTO(Get024Entity entity) {
		CommerceValidate.entityToDtoValidateGet024(entity);
		Get024Dto dto = new Get024Dto();
		BeanUtils.copyProperties(entity, dto);
		if (Optional.ofNullable(entity.getId()).isPresent()) {
			dto.setGe23clicod(entity.getId().getGe23clicod());
			dto.setGe24clisuc(entity.getId().getGe24clisuc());
		}
		return dto;
	}

	public static List<Get024Dto> toListDTO(List<Get024Entity> list) {
		List<Get024Dto> response = new ArrayList<Get024Dto>();
		for (Get024Entity entity : list) {
			response.add(toDTO(entity));
		}
		return response;
	}

	public static Get024Entity toENTITY(Get024Dto dto) {
		Get024Entity entity = new Get024Entity();
		BeanUtils.copyProperties(dto, entity);
		if (Optional.ofNullable(dto).isPresent()) {
			entity.setId(new Get024Id(dto.getGe23clicod(), dto.getGe24clisuc()));
		}
		return entity;
	}

	public static List<Get024Entity> toListENTITY(List<Get024Dto> list) {
		List<Get024Entity> response = new ArrayList<Get024Entity>();
		for (Get024Dto dto : list) {
			response.add(toENTITY(dto));
		}
		return response;
	}

	@Override
	public String toString() {
		return "Get024Dto [ge23clicod=" + ge23clicod + ", ge24clisuc=" + ge24clisuc + ", ge24clisno=" + ge24clisno
				+ ", ge24clisdi=" + ge24clisdi + ", ge24paicnu=" + ge24paicnu + ", ge24dptcnu=" + ge24dptcnu
				+ ", ge24ciucod=" + ge24ciucod + ", ge24fhoupd=" + ge24fhoupd + ", ge24usuupd=" + ge24usuupd
				+ ", ge24zoncod=" + ge24zoncod + ", ge24fpacal=" + ge24fpacal + ", ge24empcod=" + ge24empcod
				+ ", ge24succod=" + ge24succod + ", ge24rubid=" + ge24rubid + ", ge24mercod=" + ge24mercod
				+ ", ge24telnro=" + ge24telnro + ", ge24faxnro=" + ge24faxnro + ", ge24codpro=" + ge24codpro
				+ ", ge24codswi=" + ge24codswi + ", ge24cliraz=" + ge24cliraz + ", ge24cliruc=" + ge24cliruc
				+ ", ge24stspro=" + ge24stspro + ", ge24stsswi=" + ge24stsswi + ", ge24mspcod=" + ge24mspcod
				+ ", ge24mspobs=" + ge24mspobs + ", ge24msscod=" + ge24msscod + ", ge24mssobs=" + ge24mssobs
				+ ", ge24tcscod=" + ge24tcscod + ", ge24mspfh=" + ge24mspfh + ", ge24mssfh=" + ge24mssfh + ", ge24cat="
				+ ge24cat + ", ge24usuing=" + ge24usuing + ", ge24fhing=" + ge24fhing + ", ge24fchprf=" + ge24fchprf
				+ ", ge24fchem=" + ge24fchem + ", ge24modraz=" + ge24modraz + ", ge24fchpos=" + ge24fchpos
				+ ", ge24coucod=" + ge24coucod + ", ge24zcocod=" + ge24zcocod + ", ge24casmat=" + ge24casmat
				+ ", ge24ecogru=" + ge24ecogru + ", additionalData=" + additionalData + "]";
	}
}
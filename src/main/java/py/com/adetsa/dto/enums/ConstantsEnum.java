package py.com.adetsa.dto.enums;

public enum ConstantsEnum {
	BANCARD_COMMERCE_CODE("BANCARD_COMMERCE_CODE", "Código de comercio Bancard"), 
	I("I", "INACTIVO"), 
	ROLE_ADMIN("ROLE_ADMIN", "Rol Administrador"),
	ROLE_USER("ROLE_USER", "Rol Usuario");

	private String cod;
	private String desc;

	ConstantsEnum(String cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public String getCod() {
		return this.cod;
	}

	public String getDesc() {
		return this.desc;
	}

	public static ConstantsEnum getDefault() {
		return I;
	}

	public static ConstantsEnum getByCod(String cod) {
		for (ConstantsEnum val : ConstantsEnum.values()) {
			if (val.cod.equals(cod)) {
				return val;
			}
		}
		return getDefault();
	}
}
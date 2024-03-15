package py.com.adetsa.dto.enums;

public enum EntityReferencesStatusEnum {
	A("A", "ACTIVO"), I("I", "INACTIVO");

	private String cod;
	private String desc;

	EntityReferencesStatusEnum(String cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public String getCod() {
		return this.cod;
	}

	public String getDesc() {
		return this.desc;
	}

	public static EntityReferencesStatusEnum getDefault() {
		return A;
	}

	public static EntityReferencesStatusEnum getByCod(String cod) {
		for (EntityReferencesStatusEnum val : EntityReferencesStatusEnum.values()) {
			if (val.cod.equals(cod)) {
				return val;
			}
		}
		return getDefault();
	}
}
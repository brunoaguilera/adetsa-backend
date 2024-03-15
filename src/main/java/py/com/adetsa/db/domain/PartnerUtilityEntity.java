package py.com.adetsa.db.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "partner_utility", schema = "adetsa")
public class PartnerUtilityEntity {

	@Id
	@Column(name = "partner_cod")
	public String partnerCod;

	@Column(name = "partner_name")
	public String partnerName;

	@Column(name = "utility")
	public double utility;

	@Column(name = "withdraw_money")
	public String withdrawMoney;

	public String getPartnerCod() {
		return partnerCod;
	}

	public void setPartnerCod(String partnerCod) {
		this.partnerCod = partnerCod;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public double getUtility() {
		return utility;
	}

	public void setUtility(double utility) {
		this.utility = utility;
	}

	public String getWithdrawMoney() {
		return withdrawMoney;
	}

	public void setWithdrawMoney(String withdrawMoney) {
		this.withdrawMoney = withdrawMoney;
	}

	@Override
	public String toString() {
		return "PartnerEntity [partnerCod=" + partnerCod + ", partnerName=" + partnerName + ", utility=" + utility
				+ ", withdrawMoney=" + withdrawMoney + "]";
	}
}
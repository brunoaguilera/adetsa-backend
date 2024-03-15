package py.com.adetsa.validate;

import java.util.Optional;

import py.com.adetsa.db.domain.Get023Entity;
import py.com.adetsa.db.domain.Get024Entity;
import py.com.adetsa.util.LotteryUtils;

public class CommerceValidate {

//	private static final Logger logger = LoggerFactory.getLogger(CommerceValidate.class);

	public static void entityToDtoValidateGet023(Get023Entity entity) {
		if (Optional.ofNullable(entity).isPresent()) {

//			logger.info("entity.getId(): {}", entity.getGe23clicod());
			if (Optional.ofNullable(entity.getGe23clicod()).isPresent()) {
				if (Optional.ofNullable(entity.getGe23clinom()).isPresent()) {
					entity.setGe23clinom(LotteryUtils.trim(entity.getGe23clinom()));
				}
			}
		}
	}

	public static void entityToDtoValidateGet024(Get024Entity entity) {
		if (Optional.ofNullable(entity).isPresent()) {

//			logger.info("entity.Get024Id(): {}", entity.getId());
			if (Optional.ofNullable(entity.getId()).isPresent()) {
				if (Optional.ofNullable(entity.getGe24clisno()).isPresent()) {
					entity.setGe24clisno(LotteryUtils.trim(entity.getGe24clisno()));
				}
			}
		}
	}

}

package py.com.adetsa.config;

import java.io.IOException;
import java.io.PrintStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

import py.com.adetsa.util.FileUtils;

public class LotteryBanner implements Banner {

	private static final String BANNER_FILE = "/logo.txt";

	private static final Logger LOGGER = LoggerFactory.getLogger(LotteryBanner.class);

	public void printBanner(Environment environment, Class<?> aClass, PrintStream printStream) {
		String version = getClass().getPackage().getImplementationVersion();
		if (version == null) {
			version = "DEVELOPMENT";
		}

		version = String.format("%n(%s)%n", version);

		try {
			printStream.print(FileUtils.readFromClasspath(BANNER_FILE) + version);
		} catch (IOException e) {
			LOGGER.error("Error al obtener el banner {}", e);
		}
	}
}

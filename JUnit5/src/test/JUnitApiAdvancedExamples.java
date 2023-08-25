package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.condition.DisabledForJreRange;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.io.TempDir;

@Tag("production")

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JUnitApiAdvancedExamples {

	@Test
	@Tag("production")
	void someTestForProdEnv() {

	}

	@Test
	@Order(1)
	void order1() {
		// some assertions...
	}

	@Test
	@Order(2)
	void order2() {
		// some assertions...
	}

	@Test
	@Order(3)
	void order3() {
		// some assertions...
	}

	@Test
	@EnabledOnOs(OS.MAC)
	void onlyOMacOS() {
		// some assertions...
	}

	@Test
	@EnabledOnOs({ OS.MAC, OS.LINUX })
	void onlyOMacOrLinux() {
		// some assertions...
	}

	@Test
	@DisabledOnOs(OS.WINDOWS)
	void notOnWindows() {
	}

	// **** JRE Conditions

	@Test
	@EnabledOnJre(JRE.JAVA_10)
	void onlyOnJava8() {
	}

	@Test
	@EnabledOnJre({ JRE.JAVA_9, JRE.JAVA_10 })
	void onJava9Or10() {
	}

	@Test
	@EnabledForJreRange(min = JRE.JAVA_9, max = JRE.JAVA_11)
	void fromJava9to11() {
	}

	@Test
	@EnabledForJreRange(min = JRE.JAVA_9)
	void fromJava9toCurrentJavaFeatureNumber() {
	}

	@Test
	@EnabledForJreRange(max = JRE.JAVA_11)
	void fromJava8To11() {
	}

	@Test
	@DisabledOnJre(JRE.JAVA_9)
	void notOnJava9() {
	}

	@Test
	@DisabledForJreRange(min = JRE.JAVA_9, max = JRE.JAVA_11)
	void notFromJava9to11() {
	}

	@Test
	@DisabledForJreRange(min = JRE.JAVA_9)
	void notFromJava9toCurrentJavaFeatureNumber() {
	}

	@Test
	@DisabledForJreRange(max = JRE.JAVA_11)
	void notFromJava8to11() {
	}

	// *** System properties conditions

	@Test
	@EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
	void onlyOn64BitArchitectures() {
	}

	@Test
	@DisabledIfSystemProperty(named = "ci-server", matches = "true")
	void notOnCiServer() {
	}

	// *** Environment variables conditions

	@Test
	@EnabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
	void onlyOnStagingServer() {
	}

	@Test
	@DisabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*")
	void notOnDeveloperWorkstation() {
	}

	// *** Custom conditions

	@Test
	@EnabledIf("customCondition")
	void enabled() {
	}

	@Test
	@DisabledIf("customCondition")
	void disabled() {
	}

	boolean customCondition() {
		return true;
	}

	// ===================== Repeated test

	@RepeatedTest(value = 5, name = "{displayName} {currentRepetition}/{totalRepetitions}")
	void repeatedTest() {
	}

	// ===================== Extension - TempDir

	@Test
	void tempDirExample(@TempDir Path tempDir) throws IOException {
		Path path = tempDir.resolve("test");
		Files.write(path, "some text".getBytes());

		assertEquals("some text", Files.readAllLines(path).stream().collect(Collectors.joining()));
	}
}

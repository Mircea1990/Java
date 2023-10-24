package com.example.version;

import org.springframework.boot.system.JavaVersion;
import org.springframework.boot.system.SystemProperties;
import org.springframework.core.SpringVersion;

// This class is used to obtain version information of various components.
public class VersionObtainer {
    // This method returns the version of Spring being used.
    public String getSpringVersion() {
        return SpringVersion.getVersion();
    }

    // This method returns the version of Java being used.
    public String getJavaVersion() {
        return JavaVersion.getJavaVersion().toString();
    }

    // This method returns the version of JDK being used.
    public String getJdkVersion() {
        return SystemProperties.get("java.version");
    }
}


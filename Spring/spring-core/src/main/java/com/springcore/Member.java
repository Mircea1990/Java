package com.springcore;

import lombok.Getter;
import org.springframework.stereotype.Component;

// The @Getter annotation is a Lombok annotation to auto-generate getter methods for all fields.
// The @Component annotation is a Spring Framework annotation to indicate that a class is a
// "component".
// These classes are considered as candidates for auto-detection when using annotation-based
// configuration and classpath scanning.
@Getter @Component public class Member {
    // Member variable for storing member id
    private int memberId;
    // Member variable for storing member name
    private String memberName;

    // Setter method for memberId
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    // Setter method for memberName
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}


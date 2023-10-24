package com.example.factorybean;

import lombok.Getter;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.lang.NonNull;

// This class extends AbstractFactoryBean and is annotated with @Getter from Lombok to provide
// getter methods for all fields.
// The singleton property is not set because its default value is true.
@Getter public class SingleToolFactory extends AbstractFactoryBean<Tool> {
    // These are the private fields for factoryId and toolId.
    private int factoryId;
    private int toolId;

    // This method returns the type of object that this FactoryBean creates. In this case, it's
    // Tool.
    @Override public Class<?> getObjectType() {
        return Tool.class;
    }

    // This method creates a new instance of Tool with the toolId. It's called when a new
    // instance of the bean is needed.
    @Override protected @NonNull Tool createInstance() throws Exception {
        return new Tool(toolId);
    }

    // This method sets the factoryId field.
    public void setFactoryId(int factoryId) {
        this.factoryId = factoryId;
    }

    // This method sets the toolId field.
    public void setToolId(int toolId) {
        this.toolId = toolId;
    }
}

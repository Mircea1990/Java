package com.example.factorybean;

import lombok.Getter;
import org.springframework.beans.factory.FactoryBean;

// The @Getter annotation is a part of Project Lombok and it generates a getter for all
// non-static fields.
@Getter
// The ToolFactory class implements the FactoryBean interface with Tool as its generic parameter.
public class ToolFactory implements FactoryBean<Tool> {
    // This is a private field for the ToolFactory class. It represents the id of the factory.
    private int factoryId;
    // This is a private field for the ToolFactory class. It represents the id of the tool that
    // this factory produces.
    private int toolId;

    // This method is an override from the FactoryBean interface. It returns an instance of the
    // object this factory creates, which is a Tool object.
    @Override public Tool getObject() throws Exception {
        return new Tool(toolId); // Creates a new Tool object with the toolId field as its id.
    }

    // This method is an override from the FactoryBean interface. It returns the type of object
    // this factory creates, which is a Tool class.
    @Override public Class<?> getObjectType() {
        return Tool.class;
    }

    // This method is an override from the FactoryBean interface. It indicates whether this
    // factory produces singleton objects. In this case, it does not.
    @Override public boolean isSingleton() {
        return false;
    }

    // This is a setter method for the factoryId field. It's used to change the value of the
    // factoryId field of an existing ToolFactory object.
    public void setFactoryId(int factoryId) {
        this.factoryId = factoryId; // Sets the factoryId of the tool factory to the passed value.
    }

    // This is a setter method for the toolId field. It's used to change the value of the toolId
    // field of an existing ToolFactory object.
    public void setToolId(int toolId) {
        this.toolId =
                toolId; // Sets the toolId of the tool that this factory produces to the passed
        // value.
    }
}


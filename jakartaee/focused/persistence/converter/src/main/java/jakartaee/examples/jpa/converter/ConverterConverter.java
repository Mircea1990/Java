package jakartaee.examples.jpa.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * The Converter used to demonstrate usage of @Converter.
 */
@Converter public class ConverterConverter
        implements AttributeConverter<ConverterAttribute, String> {

    /**
     * Convert ConverterAttribute to String.
     *
     * @param converterAttribute the attribute.
     * @return the string.
     */
    @Override public String convertToDatabaseColumn(ConverterAttribute converterAttribute) {
        return converterAttribute.getValue().toString();
    }

    /**
     * Convert String to ConverterAttribute.
     *
     * @param string the string.
     * @return the ConverterAttribute.
     */
    @Override public ConverterAttribute convertToEntityAttribute(String string) {
        return new ConverterAttribute(Long.valueOf(string));
    }
}

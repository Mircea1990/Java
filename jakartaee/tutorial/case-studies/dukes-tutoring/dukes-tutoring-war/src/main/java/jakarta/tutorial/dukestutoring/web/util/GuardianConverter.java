package jakarta.tutorial.dukestutoring.web.util;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakartaee.tutorial.dukestutoring.entity.Guardian;


@FacesConverter(forClass = Guardian.class, value = "guardian") public class GuardianConverter
        extends EntityConverter implements Converter {

    @Override public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.isEmpty()) {
            return null;
        }
        return this.getViewMap(context).get(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        if (object == null) {
            return "";
        }

        Guardian guardian = (Guardian) object;
        Long id = guardian.getId();
        if (id != null) {
            String stringId = String.valueOf(id.longValue());
            this.getViewMap(context).put(stringId, object);
            return stringId;
        } else {
            return "0";
        }
    }
}

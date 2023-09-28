package jakarta.tutorial.interceptor.ejb;

import java.util.logging.Logger;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;


public class HelloInterceptor {
    private static final Logger logger = Logger.getLogger("interceptor.ejb.HelloInterceptor");
    protected String greeting;

    public HelloInterceptor() {
    }

    @AroundInvoke public Object modifyGreeting(InvocationContext ctx) throws Exception {
        Object[] parameters = ctx.getParameters();
        String param = (String) parameters[0];
        param = param.toLowerCase();
        parameters[0] = param;
        ctx.setParameters(parameters);
        try {
            return ctx.proceed();
        } catch (Exception e) {
            logger.warning("Error calling ctx.proceed in modifyGreeting()");
            return null;
        }
    }

}

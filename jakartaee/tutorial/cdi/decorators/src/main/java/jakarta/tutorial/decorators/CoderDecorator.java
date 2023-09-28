package jakarta.tutorial.decorators;

import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.enterprise.inject.Any;
import jakarta.inject.Inject;

@Decorator public abstract class CoderDecorator implements Coder {

    @Inject @Delegate @Any Coder coder;

    @Override public String codeString(String s, int tval) {
        int len = s.length();

        return "\"" + s + "\" becomes " + "\"" + coder.codeString(s, tval) + "\", " + len +
               " characters in length";
    }
}

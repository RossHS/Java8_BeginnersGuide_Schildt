package Ch14_LambdaExpressions_MethodReferences;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Ross on 27.10.2017.
 */
public interface MyIOAction {
    boolean ioAction(Reader rdr) throws IOException;
}

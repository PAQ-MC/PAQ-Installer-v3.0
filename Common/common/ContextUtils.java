package common;

import org.xeustechnologies.jcl.JarClassLoader;

import java.io.Closeable;
import java.io.IOException;
import java.util.Stack;

/**
 * Created by Aleksander on 14.12.13.
 */
public class ContextUtils {
    private static final Stack<JarClassLoader> _classLoaders;

    static {
        _classLoaders = new Stack<JarClassLoader>();
        _classLoaders.push(new JarClassLoader());
    }

    public static Closeable enter(final JarClassLoader classLoader) {
        _classLoaders.push(classLoader);

        return new Closeable() {
            @Override
            public void close() throws IOException {
                JarClassLoader popped = _classLoaders.pop();
                if(popped != classLoader)
                    throw new IllegalStateException("context stack corrupt");
            }
        };
    }

    public static ClassLoader get() {
        return _classLoaders.peek();
    }
}

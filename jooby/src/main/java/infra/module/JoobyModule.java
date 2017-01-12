package infra.module;

import com.google.inject.Binder;

import com.typesafe.config.Config;

import org.jooby.Env;
import org.jooby.Jooby;

/**
 * @author Claudio E. de Oliveira
 * @date 11/01/17.
 * @email claudioed.oliveira@gmail.com Project logify
 */
public class JoobyModule implements Jooby.Module {

    @Override
    public void configure(Env env, Config config, Binder binder) throws Throwable {
        binder.install(new DataModule());
    }

}

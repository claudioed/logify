package infra.module;

import com.google.inject.AbstractModule;

/**
 * @author Claudio E. de Oliveira
 * @date 11/01/17.
 * @email claudioed.oliveira@gmail.com Project logify
 */
public class DropwizardModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new DataModule());
    }

}

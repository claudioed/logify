package infra.module;

import com.google.inject.AbstractModule;

import domain.controller.LogController;

/**
 * @author Claudio E. de Oliveira
 * @date 10/01/17.
 * @email claudioed.oliveira@gmail.com Project logify
 */
public class RatpackModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new DataModule());
        bind(LogController.class);
    }

}

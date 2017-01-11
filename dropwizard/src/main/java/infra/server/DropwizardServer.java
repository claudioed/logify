package infra.server;

import com.google.inject.Guice;
import com.google.inject.Injector;

import domain.controller.LogController;
import infra.config.DropwizardConfiguration;
import infra.module.DataModule;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

/**
 * @author Claudio E. de Oliveira
 * @date 11/01/17.
 * @email claudioed.oliveira@gmail.com Project logify
 */
public class DropwizardServer extends Application<DropwizardConfiguration> {

    public static void main(String[] args) throws Exception {
        new DropwizardServer().run(args);
    }

    @Override
    public void run(DropwizardConfiguration dropwizardConfiguration, Environment environment) throws Exception {
        final Injector injector = Guice.createInjector(new DataModule());
        environment.jersey().register(injector.getInstance(LogController.class));
    }
}

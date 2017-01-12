package infra.server;

import org.jooby.Jooby;

import domain.controller.LogController;
import infra.module.JoobyModule;

/**
 * @author Claudio E. de Oliveira
 * @date 11/01/17.
 * @email claudioed.oliveira@gmail.com Project logify
 */
public class JoobyServer extends Jooby {

    {
        use(new JoobyModule());
        use(LogController.class);
    }

    public static void main(String[] args) {
        // 3. run my app
        run(JoobyServer::new, args);
    }

}

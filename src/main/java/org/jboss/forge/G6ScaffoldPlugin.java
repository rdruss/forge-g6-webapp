package org.jboss.forge;

import org.jboss.forge.scaffold.events.AdvertiseGenProfile;
import org.jboss.forge.shell.events.PostStartup;
import org.jboss.forge.shell.plugins.Plugin;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.net.URL;

/**
 * @author Rodney Russ.
 */

@ApplicationScoped
public class G6ScaffoldPlugin implements Plugin {
    @Inject
    private Event<AdvertiseGenProfile> event;

    public void init(@Observes PostStartup postStartup) {
        URL g6_fpk = getClass().getClassLoader()
                .getResource("org/jboss/forge/templates/g6-webapp.fpk");

        event.fire(new AdvertiseGenProfile("g6-webapp", g6_fpk));
    }
}

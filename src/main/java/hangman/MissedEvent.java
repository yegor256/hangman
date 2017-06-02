package game;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import event.Event;

/**
 * Won event.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class MissedEvent implements Event {
        private final FailuresMessageMedia media;
        private final Failures failures;
        private final Event source;

        public MissedWithMessage(final FailuresMessageMedia media, final Failures failures, final Event event) {
                this.media = media;
                this.failures = failures;
                this.source = event;
        }

        @Override
        public boolean is(String name) {
                return source.is(name);
        }

        @Override
        public Map<String, T> payload() {
                Collections.unmodifiableMap(new HashMap<Integer, T>() {
                        {
                                put("failures", failures);
                                put("media", media);
                        }
                });
        }
}
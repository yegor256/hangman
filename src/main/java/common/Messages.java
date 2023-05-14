package common;

import java.util.*;

public final class Messages
{
    private final Map<String, Set<Recipient>> _recipients = new HashMap<>();

    public void subcribeTo(String subject, Recipient recipient)
    {
        if (!_recipients.containsKey(subject))
            _recipients.put(subject, new HashSet<>());
        _recipients.get(subject).add(recipient);
    }

    public void send(String subject, String content)
    {
        if (_recipients.containsKey(subject))
            _recipients.get(subject).forEach(x -> x.receive(content));
    }
}

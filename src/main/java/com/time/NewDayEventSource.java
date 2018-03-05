package com.time;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NewDayEventSource {
    private List listeners = new ArrayList();

    public synchronized void addEventListener(NewDayEventListener listener) {
        listeners.add(listener);
    }

    public synchronized void removeEventListener(NewDayEventListener listener) {
        listeners.remove(listener);
    }

    private synchronized void fireEvent() {
        NewDayEvent event = new NewDayEvent(this);
        Iterator i = listeners.iterator();
        while(i.hasNext()) {
            ((NewDayEventListener) i.next()).handleNewDayEvent(event);
        }
    }
}

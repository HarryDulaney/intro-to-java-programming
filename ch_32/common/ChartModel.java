package ch_32.common;

import java.util.*;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class ChartModel {
    private double[] data = {200, 40, 50, 100, 40, 10};
    private String[] dataName = {"CS", "Math", "Chem", "Biol", "Phys", "Buss"};

    private transient Vector<EventHandler<ActionEvent>> actionListeners;

    public ChartModel() {
    }

    public double[] getData() {
        return data;
    }

    public synchronized void removeActionListener(EventHandler<ActionEvent> l) {
        if (actionListeners != null && actionListeners.contains(l)) {
            Vector<EventHandler<ActionEvent>> v = (Vector<EventHandler<ActionEvent>>) actionListeners.clone();
            v.removeElement(l);
            actionListeners = v;
        }
    }

    public synchronized void addActionListener(EventHandler<ActionEvent> l) {
        Vector<EventHandler<ActionEvent>> v = actionListeners == null ? new Vector<>(2) : (Vector) actionListeners.clone();
        if (!v.contains(l)) {
            v.addElement(l);
            actionListeners = v;
        }
    }

    protected void fireActionPerformed(ActionEvent e) {
        if (actionListeners != null) {
            Vector<EventHandler<ActionEvent>> listeners = actionListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                listeners.elementAt(i).handle(e);
            }
        }
    }

    public void setChartData(String[] newDataName, double[] newData) {
        dataName = newDataName;
        data = newData;
        // System.arraycopy(newData, 0, data, 0, newData.length);
        fireActionPerformed(new ActionEvent());
    }

    public String[] getDataName() {
        return dataName;
    }
}


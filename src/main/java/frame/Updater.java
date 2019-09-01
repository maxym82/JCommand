package frame;

import javax.swing.*;

public class Updater {
    private Timer timer;

    public Updater(int delay, Runnable callback) {
        timer = new Timer(delay, e -> {
            timer.stop();
            callback.run();
        });
    }

    public void update() {
        if (!SwingUtilities.isEventDispatchThread()) {
            SwingUtilities.invokeLater(() -> {timer.restart();});
        } else {
            timer.restart();
        }
    }
}

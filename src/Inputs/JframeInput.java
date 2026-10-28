package src.Inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;
import java.util.Queue;

public class JframeInput implements Input, KeyListener {
    private Set<Integer> pressedKeys = new HashSet<>();

    private final Queue<String> platformerInputs = new LinkedList<>();

    @Override
    public String getInput() {
        if (pressedKeys.contains(KeyEvent.VK_W) || pressedKeys.contains(KeyEvent.VK_UP)) {
            return "W";
        }
        if (pressedKeys.contains(KeyEvent.VK_S) || pressedKeys.contains(KeyEvent.VK_DOWN)) {
            return "S";
        }
        if (pressedKeys.contains(KeyEvent.VK_A) || pressedKeys.contains(KeyEvent.VK_LEFT)) {
            return "A";
        }
        if (pressedKeys.contains(KeyEvent.VK_D) || pressedKeys.contains(KeyEvent.VK_RIGHT)) {
            return "D";
        }
        if (pressedKeys.contains(KeyEvent.VK_SPACE)) {
            return "SPACE";
        }
        return "";
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        boolean newPress = pressedKeys.add(e.getKeyCode());

        if (!newPress) {
            return;
        }

        switch (e.getKeyCode()) {
            case KeyEvent.VK_A, KeyEvent.VK_LEFT ->
                    platformerInputs.offer("A");
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT ->
                    platformerInputs.offer("D");
            case KeyEvent.VK_SPACE ->
                    platformerInputs.offer("SPACE");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
    }

    public String getNextCommand() {
        String command = platformerInputs.poll();
        return command == null ? "" : command;
    }

}

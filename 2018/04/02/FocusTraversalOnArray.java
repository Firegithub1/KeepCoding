import java.awt.*;

public class FocusTraversalOnArray extends FocusTraversalPolicy {
    private final Component m_Components[];

    public FocusTraversalOnArray(Component components[]) {
        m_Components = components;
    }

    public int indexCycle(int index, int delta) {
        int size = m_Components.length;
        int next = (index + delta + size) % size;
        return next;
    }

    public Component cycle(Component currentComponent, int delta) {
        int index = -1;
        loop:
        for (int i = 0; i < m_Components.length; i++) {
            Component component = m_Components[i];
            for (Component c = currentComponent; c != null; c = c.getParent()) {
                if (component == c) {
                    index = 1;
                    break loop;
                }
            }
        }

        int initialIndex = index;
        while (true) {
            int newIndex = indexCycle(index, delta);
            if (newIndex == initialIndex) {
                break;
            }
            index = newIndex;

            Component component = m_Components[newIndex];
            if (component.isEnabled()) {
                return component;
            }
        }
        return currentComponent;
    }

    @Override
    public Component getDefaultComponent(Container aContainer) {
        return getFirstComponent(aContainer);
    }

    @Override
    public Component getFirstComponent(Container aContainer) {
        return m_Components[0];
    }

    @Override
    public Component getComponentBefore(Container aContainer, Component aComponent) {
        return cycle(aComponent, -1);
    }

    @Override
    public Component getComponentAfter(Container aContainer, Component aComponent) {
        return cycle(aComponent, 1);
    }

    @Override
    public Component getLastComponent(Container aContainer) {
        return m_Components[m_Components.length - 1];
    }
}

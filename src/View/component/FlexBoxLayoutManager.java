package View.component;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.HashMap;
import java.util.Map;

public class FlexBoxLayoutManager implements LayoutManager {

    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    private int flexDirection;
    private Map<Component, Integer> componentWidthMap;
    private Map<Component, Integer> componentHeightMap;
    private Map<Component, Boolean> fillWidthMap;
    private Map<Component, Boolean> fillHeightMap;
    private int gap;
    private Insets padding;
    public FlexBoxLayoutManager(int flexDirection) {
        this.flexDirection = flexDirection;
        this.componentWidthMap = new HashMap<>();
        this.componentHeightMap = new HashMap<>();
        this.fillWidthMap = new HashMap<>();
        this.fillHeightMap = new HashMap<>();
        this.gap = 0;
        this.padding = new Insets(0, 0, 0, 0);
    }

    public void setItemWidth(Component component, int width) {
        componentWidthMap.put(component, width);
    }

    public void setFillWidth(Component component, boolean fill) {
        fillWidthMap.put(component, fill);
    }

    public void setItemHeight(Component component, int height) {
        componentHeightMap.put(component, height);
    }

    public void setFillHeight(Component component, boolean fill) {
        fillHeightMap.put(component, fill);
    }
    public void setGap(int gap) {
        this.gap = gap;
    }
    public void setPadding(Insets padding) {
        this.padding = padding;
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {
        // Not used
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        componentWidthMap.remove(comp);
        componentHeightMap.remove(comp);
        fillWidthMap.remove(comp);
        fillHeightMap.remove(comp);
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return calculateLayoutSize(parent.getComponents(), parent.getInsets());
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return calculateLayoutSize(parent.getComponents(), parent.getInsets());
    }

    @Override
    public void layoutContainer(Container parent) {
        Component[] components = parent.getComponents();
        Insets insets = parent.getInsets();

        int x = insets.left + padding.left;
        int y = insets.top + padding.top;

        int availableWidth = parent.getWidth() - insets.left - insets.right - padding.left - padding.right;
        int availableHeight = parent.getHeight() - insets.top - insets.bottom - padding.top - padding.bottom;

        for (Component component : components) {
            int componentWidth = calculateComponentWidth(component, availableWidth, components);
            int componentHeight = calculateComponentHeight(component, availableHeight, components);

            if (flexDirection == HORIZONTAL) {
                component.setBounds(x, y, componentWidth, componentHeight);
                x += componentWidth + gap;
            } else {
                component.setBounds(x, y, componentWidth, componentHeight);
                y += componentHeight + gap;
            }
        }
    }

    private int calculateComponentWidth(Component component, int availableWidth, Component[] components) {
        if (componentWidthMap.containsKey(component)) {
            return Math.min(componentWidthMap.get(component), availableWidth);
        } else if (fillWidthMap.containsKey(component) && fillWidthMap.get(component)) {
            int totalFillComponents = 0;
            int totalFixedWidth = 0;

            for (Component comp : components) {
                if (fillWidthMap.containsKey(comp) && fillWidthMap.get(comp)) {
                    totalFillComponents++;
                } else {
                    totalFixedWidth += componentWidthMap.getOrDefault(comp, comp.getPreferredSize().width);
                }
            }

            if(flexDirection == VERTICAL)
                return availableWidth;
            return (availableWidth - totalFixedWidth) / totalFillComponents;
        } else {
            return Math.min(component.getPreferredSize().width, availableWidth);
        }
    }

    private int calculateComponentHeight(Component component, int availableHeight, Component[] components) {
        if (componentHeightMap.containsKey(component)) {
            return Math.min(componentHeightMap.get(component), availableHeight);
        } else if (fillHeightMap.containsKey(component) && fillHeightMap.get(component)) {
            int totalFillComponents = 0;
            int totalFixedHeight = 0;

            for (Component comp : components) {
                if (fillHeightMap.containsKey(comp) && fillHeightMap.get(comp)) {
                    totalFillComponents++;
                } else {
                    totalFixedHeight += componentHeightMap.getOrDefault(comp, comp.getPreferredSize().height);
                }
            }
            if(flexDirection == HORIZONTAL)
                return availableHeight ;
            return (availableHeight - totalFixedHeight) / totalFillComponents;
        } else {
            return Math.min(component.getPreferredSize().height, availableHeight);
        }
    }

    private Dimension calculateLayoutSize(Component[] components, Insets insets) {
        int width = 0;
        int height = 0;

        for (Component component : components) {
            if (flexDirection == HORIZONTAL) {
                width += calculateComponentWidth(component, Integer.MAX_VALUE, components);
                height = Math.max(height, component.getPreferredSize().height);
            } else {
                width = Math.max(width, component.getPreferredSize().width);
                height += calculateComponentHeight(component, Integer.MAX_VALUE, components);
            }
        }

        return new Dimension(width + insets.left + insets.right + padding.left + padding.right,
                height + insets.top + insets.bottom + padding.top + padding.bottom);

    }
}
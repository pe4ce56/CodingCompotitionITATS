package View.resource.utils;

import java.awt.*;
import java.util.HashMap;

public class Utils {
    public static HashMap<String, Integer> getSizeOfScreen(double percentage) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int widthInPixels = (int) (screenSize.getWidth() * percentage);
        int heightInPixels = (int) (screenSize.getHeight() * percentage);

        HashMap<String, Integer> dimensions = new HashMap<>();
        dimensions.put("width", widthInPixels);
        dimensions.put("height", heightInPixels);

        return dimensions;
    }

    public static GridBagConstraints getGbc(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        return gbc;
    }
}
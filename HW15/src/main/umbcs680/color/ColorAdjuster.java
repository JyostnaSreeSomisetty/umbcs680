package umbcs680.color;

import umbcs680.color.Color;

@FunctionalInterface
public interface ColorAdjuster {
    Color adjust(Color color);
}
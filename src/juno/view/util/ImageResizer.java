/*
 *
 * MIT License
 *
 * Copyright (c) 2022 Simone Gentili
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package juno.view.util;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

/**
 * This class defines an image resizer.
 * @author Simone Gentili
 */
public class ImageResizer
        implements InterfaceImageResizer {

    // The ImageResizer instance.
    private static ImageResizer instance;

    // Builds an ImageResizer object.
    private ImageResizer() {}

    /**
     * Returns the ImageResizer instance.
     * @return The ImageResizer instance.
     */
    public static ImageResizer getInstance() {
        if(instance == null) instance = new ImageResizer();
        return instance;
    }

    @Override
    @SuppressWarnings("SuspiciousNameCombination")
    public Image resize(@NotNull Component component,
                        @NotNull Icon icon) {

        // Rotated icon case.
        if (icon instanceof RotatedIcon rotatedIcon) {
            RotatedIcon.Rotate rotate = rotatedIcon.getRotate();
            Icon temp = rotatedIcon.getIcon();
            if (temp instanceof ImageIcon imageIcon) {
                // Up and Down rotated value cases.
                // Width and height in this case must
                // be reversed. This inversion results
                // in the "SuspiciousNameCombination" warning.
                if (rotate == RotatedIcon.Rotate.UP ||
                        rotate == RotatedIcon.Rotate.DOWN) {
                    return imageIcon.getImage().getScaledInstance(
                            component.getPreferredSize().height,
                            component.getPreferredSize().width,
                            Image.SCALE_SMOOTH);
                }

                // About center and Upside down rotated cases.
                else return imageIcon.getImage().getScaledInstance(
                        component.getPreferredSize().width,
                        component.getPreferredSize().height,
                        Image.SCALE_SMOOTH);

            } else throw new IllegalArgumentException(
                    "Invalid object type: " + temp.getClass() +
                            ". ImageIcon type expected.");
        }

        // Image icon type case.
        else if (icon instanceof ImageIcon imageIcon)
            return imageIcon.getImage().getScaledInstance(
                    component.getPreferredSize().width,
                    component.getPreferredSize().height,
                    Image.SCALE_SMOOTH);

        // Invalid case.
        else throw new IllegalArgumentException(
                    "Invalid object type: " + icon.getClass() +
                            ". ImageIcon type expected.");
    }

    @Override
    public void resize(@NotNull AbstractButton button,
                       double divisor) {
        Icon icon = button.getIcon();
        button.setPreferredSize(new Dimension(
                (int) (icon.getIconWidth()  / divisor),
                (int) (icon.getIconHeight() / divisor)));
    }

    /**
     * Resize the specified JLabel object by
     * dividing the width and the height of
     * the Icon object of the specified JLabel
     * with the specified double value.
     * @param label A JLabel object.
     * @param divisor A double value.
     */
    public void resize(@NotNull JLabel label,
                       double divisor) {
        Icon icon = label.getIcon();
        label.setPreferredSize(new Dimension(
                (int) (icon.getIconWidth()  / divisor),
                (int) (icon.getIconHeight() / divisor)));
    }

}
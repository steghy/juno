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

package juno.view.img_initializer;

import juno.model.requester.InterfacePathProvider;
import juno.model.util.Os;
import juno.view.util.RotatedIcon;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class ImageComponentInitializer
        extends AbstractImageComponentInitializer {

    public Dimension dimension = null;
    public Constraints BOTH_MISSING = Constraints.THROW_EXCEPTION;
    public Constraints BOTH_SELECTED_MISSING = Constraints.THROW_EXCEPTION;
    public Constraints ALL_MISSING = Constraints.THROW_EXCEPTION;
    public Constraints IMAGE_MISSING = Constraints.KEEP_ROLLOVER_IMAGE;
    public Constraints ROLLOVER_IMAGE_MISSING = Constraints.KEEP_IMAGE;
    public Constraints SELECTED_IMAGE_MISSING = Constraints.KEEP_ROLLOVER_SELECTED_IMAGE;
    public Constraints ROLLOVER_SELECTED_IMAGE_MISSING = Constraints.KEEP_SELECTED_IMAGE;
    public boolean download = false;

    // The ImageComponentInitializer instance.
    private static ImageComponentInitializer instance;

    /** Builds the ImageComponentInitializer instance. */
    private ImageComponentInitializer() {}


    /**
     * Returns the ImageComponentInitializer instance.
     * @return The ImageComponentInitializer instance.
     */
    public static ImageComponentInitializer getInstance() {
        if(instance == null) instance = new ImageComponentInitializer();
        return instance;
    }

    @Override
    public void initialize(@NotNull AbstractButton button,
                           @NotNull InterfacePathProvider file,
                           @NotNull InterfacePathProvider rolloverFile,
                           RotatedIcon.Rotate rotate) {
        // Image section.
        button.setName(file.canonicalPath());
        String imageAbsolutePath = file.absolutePath();
        boolean imageExists = true;
        if (!Os.exists(imageAbsolutePath)) {
            if(download) {
                try {
                    Objects.requireNonNull(getRequester()).resolve(file);
                } catch (IOException e) {
                    if(IMAGE_MISSING == Constraints.THROW_EXCEPTION) {
                        throw new RuntimeException(imageAbsolutePath + " is missing.");
                    } e.printStackTrace();
                    imageExists = false;
                }
            } else {
                imageExists = false;
            }
        }

        // Rollover image.
        String rolloverImageAbsolutePath = rolloverFile.absolutePath();
        boolean rolloverImageExists = true;
        if(!Os.exists(rolloverImageAbsolutePath)) {
            if(download) {
                try {
                    Objects.requireNonNull(getRequester()).resolve(rolloverFile);
                } catch (IOException e) {
                    if(ROLLOVER_IMAGE_MISSING == Constraints.THROW_EXCEPTION) {
                        throw new IllegalArgumentException(rolloverImageAbsolutePath + " is missing");
                    }
                    e.printStackTrace();
                    rolloverImageExists = false;
                }
            } else {
                rolloverImageExists = false;
            }
        }

        // Both missing.
        if(!imageExists && !rolloverImageExists) {
            solve(button, BOTH_MISSING, dimension);
        } else if(rolloverImageExists && !imageExists) {
            if(IMAGE_MISSING == Constraints.KEEP_ROLLOVER_IMAGE) {
                RotatedIcon rolloverIcon = new RotatedIcon(new ImageIcon(rolloverImageAbsolutePath), rotate);
                button.setIcon(rolloverIcon);
                button.setPreferredSize(new Dimension(rolloverIcon.getIconWidth(), rolloverIcon.getIconHeight()));
                makeTransparent(button);
            } else {
                solve(button, IMAGE_MISSING, dimension);
            }

        } else if(!rolloverImageExists) {
            if(ROLLOVER_IMAGE_MISSING == Constraints.KEEP_IMAGE) {
                RotatedIcon icon = new RotatedIcon(new ImageIcon(imageAbsolutePath), rotate);
                button.setIcon(icon);
                button.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
                makeTransparent(button);
            } else {
                solve(button, ROLLOVER_IMAGE_MISSING, dimension);
            }
        } else {
            // button size -> image size [ not from rollover image ]
            RotatedIcon icon = new RotatedIcon(new ImageIcon(rolloverImageAbsolutePath), rotate);
            button.setRolloverIcon(icon);
            icon = new RotatedIcon(new ImageIcon(imageAbsolutePath), rotate);
            button.setIcon(icon);
            button.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
            makeTransparent(button);
        }
    }

    @Override
    public void initialize(@NotNull AbstractButton button,
                           @NotNull InterfacePathProvider file,
                           @NotNull InterfacePathProvider rolloverFile,
                           @NotNull InterfacePathProvider selectedFile,
                           @NotNull InterfacePathProvider rolloverSelectedFile,
                           RotatedIcon.Rotate rotate) {
        // Image case.
        button.setName(file.canonicalPath());
        String imageAbsolutePath = file.absolutePath();
        boolean imageExists = true;
        if (!Os.exists(imageAbsolutePath)) {
            if(download) {
                try {
                    Objects.requireNonNull(getRequester()).resolve(file);
                } catch (IOException e) {
                    if(IMAGE_MISSING == Constraints.THROW_EXCEPTION) {
                        throw new RuntimeException(imageAbsolutePath + " is missing.");
                    }
                    e.printStackTrace();
                    imageExists = false;
                }
            } else {
                imageExists = false;
            }
        }

        // Rollover image case.
        String rolloverImageAbsolutePath = rolloverFile.absolutePath();
        boolean rolloverImageExists = true;
        if(!Os.exists(rolloverImageAbsolutePath)) {
            if(download) {
                try {
                    Objects.requireNonNull(getRequester()).resolve(rolloverFile);
                } catch (IOException e) {
                    if(ROLLOVER_IMAGE_MISSING == Constraints.THROW_EXCEPTION) {
                        throw new IllegalArgumentException(rolloverImageAbsolutePath + " is missing");
                    } e.printStackTrace();
                    rolloverImageExists = false;
                }
            } else rolloverImageExists = false;
        }

        // Selected image case.
        String selectedImageAbsolutePath = selectedFile.absolutePath();
        boolean selectedImageExists = true;
        if (!Os.exists(selectedImageAbsolutePath)) {
            if(download) {
                try {
                    Objects.requireNonNull(getRequester()).resolve(selectedFile);
                } catch (IOException e) {
                    if(SELECTED_IMAGE_MISSING == Constraints.THROW_EXCEPTION) {
                        throw new RuntimeException(selectedImageAbsolutePath + " is missing.");
                    } e.printStackTrace();
                    selectedImageExists = false;
                }
            } else selectedImageExists = false;
        }

        // Rollover selected image.
        String rolloverSelectedImageAbsolutePath = rolloverSelectedFile.absolutePath();
        boolean rolloverSelectedImageExists = true;
        if(!Os.exists(rolloverSelectedImageAbsolutePath)) {
            if(download) {
                try {
                    Objects.requireNonNull(getRequester()).resolve(rolloverSelectedFile);
                } catch (IOException e) {
                    if(ROLLOVER_SELECTED_IMAGE_MISSING == Constraints.THROW_EXCEPTION) {
                        throw new IllegalArgumentException(rolloverImageAbsolutePath + " is missing");
                    } e.printStackTrace();
                    rolloverSelectedImageExists = false;
                }
            } else rolloverSelectedImageExists = false;
        }

        // All missing.
        if(!imageExists && !rolloverImageExists && !selectedImageExists && !rolloverSelectedImageExists)
            solve(button, ALL_MISSING, dimension);

        // Image & rollover image missing.
        if(!imageExists && !rolloverImageExists)
            solve(button, BOTH_MISSING, dimension);

        else if(rolloverImageExists && !imageExists) {
            if(IMAGE_MISSING == Constraints.KEEP_ROLLOVER_IMAGE) {
                Icon rolloverIcon;
                ImageIcon temp = new ImageIcon(rolloverImageAbsolutePath);
                if(rotate != null) rolloverIcon = new RotatedIcon(temp, rotate);
                else rolloverIcon = temp;
                button.setIcon(rolloverIcon);
                button.setPreferredSize(new Dimension(rolloverIcon.getIconWidth(), rolloverIcon.getIconHeight()));
                makeTransparent(button);
            } else {
                solve(button, IMAGE_MISSING, dimension);
                return;
            }
        }

        else if(!rolloverImageExists) {
            if(ROLLOVER_IMAGE_MISSING == Constraints.KEEP_IMAGE) {
                Icon icon;
                ImageIcon temp = new ImageIcon(imageAbsolutePath);
                if(rotate != null) icon = new RotatedIcon(temp, rotate);
                else icon = temp;
                button.setIcon(icon);
                button.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
                makeTransparent(button);
            } else {
                solve(button, ROLLOVER_IMAGE_MISSING, dimension);
                return;
            }
        } else {
            Icon icon;
            ImageIcon temp = new ImageIcon(rolloverImageAbsolutePath);
            if(rotate != null) icon = new RotatedIcon(temp, rotate);
            else icon = temp;
            button.setRolloverIcon(icon);
            icon = new ImageIcon(imageAbsolutePath);
            button.setIcon(icon);
            button.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
            makeTransparent(button);
        }

        // Selected image & rollover selected image missing.
        if(!selectedImageExists && !rolloverSelectedImageExists)
            solve(button, BOTH_SELECTED_MISSING, dimension);

        else if(rolloverSelectedImageExists && !selectedImageExists) {
            if(SELECTED_IMAGE_MISSING == Constraints.KEEP_ROLLOVER_SELECTED_IMAGE) {
                Icon selectedRolloverIcon = new ImageIcon(rolloverSelectedImageAbsolutePath);
                button.setSelectedIcon(selectedRolloverIcon);
                button.setSize(selectedRolloverIcon.getIconWidth(), selectedRolloverIcon.getIconHeight());
                makeTransparent(button);
            } else {
                solve(button, SELECTED_IMAGE_MISSING, dimension);
            }
        } else if(!rolloverSelectedImageExists) {
            if(ROLLOVER_SELECTED_IMAGE_MISSING == Constraints.KEEP_SELECTED_IMAGE) {
                Icon selectedIcon = new ImageIcon(selectedImageAbsolutePath);
                button.setIcon(selectedIcon);
                button.setSize(selectedIcon.getIconWidth(), selectedIcon.getIconHeight());
                makeTransparent(button);
            } else {
                solve(button, ROLLOVER_SELECTED_IMAGE_MISSING, dimension);
            }
        } else {
            Icon icon;
            ImageIcon temp = new ImageIcon(rolloverSelectedImageAbsolutePath);
            if(rotate != null) icon = new RotatedIcon(temp, rotate);
            else icon = temp;
            button.setRolloverSelectedIcon(icon);
            button.setSelectedIcon(icon);
            button.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
            makeTransparent(button);
        }
    }

    @Override
    public void initialize(@NotNull JLabel label,
                           @NotNull InterfacePathProvider file,
                           RotatedIcon.Rotate rotate) {
        // Image case.
        label.setName(file.canonicalPath());
        String imageAbsolutePath = file.absolutePath();
        boolean imageExists = true;
        if(!Os.exists(imageAbsolutePath)) {
            if(download) {
                try {
                    Objects.requireNonNull(getRequester()).resolve(file);
                } catch (IOException e) {
                    if(IMAGE_MISSING == Constraints.THROW_EXCEPTION) {
                        throw new RuntimeException(imageAbsolutePath + " is missing");
                    } e.printStackTrace();
                    imageExists = false;
                }
            } else imageExists = false;
        } if(imageExists) {
            Icon icon;
            ImageIcon temp = new ImageIcon(imageAbsolutePath);
            if(rotate != null) icon = new RotatedIcon(temp, rotate);
            else icon = temp;
            label.setIcon(icon);
            label.setOpaque(false);
            label.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconWidth()));
        } else {
            solve(label, IMAGE_MISSING, dimension);
        }
    }

    private void makeTransparent(@NotNull AbstractButton button) {
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
    }

    private void solve(@NotNull JLabel label,
                       @NotNull Constraints constant,
                       Dimension dimension) {
        if(constant == Constraints.THROW_EXCEPTION) {
            throw new RuntimeException(label.getName() + " not found");
        } else if(constant == Constraints.BLUE_LABEL) {
            label.setBackground(Color.BLUE);
        } else if(constant == Constraints.CYAN_LABEL) {
            label.setBackground(Color.CYAN);
        } else if(constant == Constraints.GREEN_LABEL) {
            label.setBackground(Color.GREEN);
        } else if(constant == Constraints.YELLOW_LABEL) {
            label.setBackground(Color.YELLOW);
        } else if(constant == Constraints.RED_LABEL) {
            label.setBackground(Color.RED);
        } else {
            throw new IllegalArgumentException("Invalid Constant: " + constant);
        }
        label.setOpaque(true);
        label.setSize(dimension);
    }

    private void solve(@NotNull AbstractButton button,
                       @NotNull Constraints constant,
                       Dimension dimension) {
        if(constant == Constraints.THROW_EXCEPTION) {
            throw new RuntimeException(button.getName() + " not found");
        } else if(constant == Constraints.CYAN_BUTTON) {
            button.setBackground(Color.CYAN);
        } else if(constant == Constraints.BLUE_BUTTON) {
            button.setBackground(Color.BLUE);
        } else if(constant == Constraints.GREEN_BUTTON) {
            button.setBackground(Color.GREEN );
        } else if(constant == Constraints.YELLOW_BUTTON) {
            button.setBackground(Color.YELLOW);
        } else if(constant == Constraints.RED_BUTTON) {
            button.setBackground(Color.RED);
        } else {
            throw new IllegalArgumentException("Invalid Constant: " + constant);
        }
        button.setText(button.getName());
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(true);
        button.setFocusPainted(true);
        button.setSize(dimension);
    }

}
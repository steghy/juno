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

package juno.view.download;

import juno.init.Downloader;
import juno.init.GitHubURLBuilder;
import juno.init.InterfacePathProvider;
import juno.model.util.Os;
import juno.view.util.Constant;
import juno.view.util.InterfaceImageComponentInitializer;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * @author Simone Gentili
 */
public class ImageComponentInitializer
        implements InterfaceImageComponentInitializer {

    public Dimension dimension = null;
    public Constant BOTH_MISSING = Constant.THROW_EXCEPTION;
    public Constant BOTH_SELECTED_MISSING = Constant.THROW_EXCEPTION;
    public Constant ALL_MISSING = Constant.THROW_EXCEPTION;
    public Constant IMAGE_MISSING = Constant.KEEP_ROLLOVER_IMAGE;
    public Constant ROLLOVER_IMAGE_MISSING = Constant.KEEP_IMAGE;
    public Constant SELECTED_IMAGE_MISSING = Constant.KEEP_ROLLOVER_SELECTED_IMAGE;
    public Constant ROLLOVER_SELECTED_IMAGE_MISSING = Constant.KEEP_SELECTED_IMAGE;
    public boolean download = true;

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
                           InterfacePathProvider rolloverFile) {
        // Image section.
        String imageAbsolutePath = file.absolutePath();
        String imageCanonicalPath = file.canonicalPath();
        GitHubURLBuilder githubURLBuilder = GitHubURLBuilder.getInstance();
        boolean imageExists = true;
        if (!Os.exists(imageAbsolutePath)) {
            if(download) {
                try {
                    Downloader.downloadUsingNIO(githubURLBuilder.getURL(imageCanonicalPath), imageAbsolutePath);
                } catch (IOException e) {
                    if(IMAGE_MISSING == Constant.THROW_EXCEPTION) {
                        throw new RuntimeException(imageAbsolutePath + " is missing.");
                    }
                    e.printStackTrace();
                    imageExists = false;
                }
            } else {
                imageExists = false;
            }
        }

        // Rollover image.
        String rolloverImageAbsolutePath = rolloverFile.absolutePath();
        String rolloverImageCanonicalPath = rolloverFile.canonicalPath();
        boolean rolloverImageExists = true;
        if(!Os.exists(rolloverImageAbsolutePath)) {
            if(download) {
                // Attempt to download the file from the GitHub repository.
                try {
                    Downloader.downloadUsingNIO(githubURLBuilder.getURL(rolloverImageCanonicalPath), rolloverImageAbsolutePath);
                } catch (IOException e) {
                    if(ROLLOVER_IMAGE_MISSING == Constant.THROW_EXCEPTION) {
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
            if(IMAGE_MISSING == Constant.KEEP_ROLLOVER_IMAGE) {
                Icon rolloverIcon = new ImageIcon(rolloverImageAbsolutePath);
                button.setIcon(rolloverIcon);
                button.setSize(rolloverIcon.getIconWidth(), rolloverIcon.getIconHeight());
                makeTransparent(button);
            } else {
                solve(button, IMAGE_MISSING, dimension);
            }

        } else if(!rolloverImageExists) {
            if(ROLLOVER_IMAGE_MISSING == Constant.KEEP_IMAGE) {
                Icon icon = new ImageIcon(imageAbsolutePath);
                button.setIcon(icon);
                button.setSize(icon.getIconWidth(), icon.getIconHeight());
                makeTransparent(button);
            } else {
                solve(button, ROLLOVER_IMAGE_MISSING, dimension);
            }
        } else {
            // button size -> image size [ not from rollover image ]
            Icon icon = new ImageIcon(rolloverImageAbsolutePath);
            button.setRolloverIcon(icon);
            icon = new ImageIcon(imageAbsolutePath);
            button.setIcon(icon);
            button.setSize(icon.getIconWidth(), icon.getIconHeight());
            makeTransparent(button);
        }
    }

    @Override
    public void initialize(@NotNull AbstractButton button,
                           @NotNull InterfacePathProvider file,
                           InterfacePathProvider rolloverFile,
                           @NotNull InterfacePathProvider selectedFile,
                           InterfacePathProvider rolloverSelectedFile) {
        // Image case.
        String imageAbsolutePath = file.absolutePath();
        String imageCanonicalPath = file.canonicalPath();
        GitHubURLBuilder githubURLBuilder = GitHubURLBuilder.getInstance();
        boolean imageExists = true;
        if (!Os.exists(imageAbsolutePath)) {
            if(download) {
                try {
                    Downloader.downloadUsingNIO(githubURLBuilder.getURL(imageCanonicalPath), imageAbsolutePath);
                } catch (IOException e) {
                    if(IMAGE_MISSING == Constant.THROW_EXCEPTION) {
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
        String rolloverImageCanonicalPath = rolloverFile.canonicalPath();
        boolean rolloverImageExists = true;
        if(!Os.exists(rolloverImageAbsolutePath)) {
            if(download) {
                try {
                    Downloader.downloadUsingNIO(githubURLBuilder.getURL(rolloverImageCanonicalPath), rolloverImageAbsolutePath);
                } catch (IOException e) {
                    if(ROLLOVER_IMAGE_MISSING == Constant.THROW_EXCEPTION) {
                        throw new IllegalArgumentException(rolloverImageAbsolutePath + " is missing");
                    }
                    e.printStackTrace();
                    rolloverImageExists = false;
                }
            } else {
                rolloverImageExists = false;
            }
        }

        // Selected image case.
        String selectedImageAbsolutePath = selectedFile.absolutePath();
        String selectedImageCanonicalPath = selectedFile.canonicalPath();
        boolean selectedImageExists = true;
        if (!Os.exists(selectedImageAbsolutePath)) {
            if(download) {
                try {
                    Downloader.downloadUsingNIO(githubURLBuilder.getURL(selectedImageCanonicalPath), selectedImageAbsolutePath);
                } catch (IOException e) {
                    if(SELECTED_IMAGE_MISSING == Constant.THROW_EXCEPTION) {
                        throw new RuntimeException(selectedImageAbsolutePath + " is missing.");
                    }
                    e.printStackTrace();
                    selectedImageExists = false;
                }
            } else {
                selectedImageExists = false;
            }
        }

        // ROLLOVER SELECTED IMAGE
        String rolloverSelectedImageAbsolutePath = rolloverSelectedFile.absolutePath();
        String rolloverSelectedImagePath = rolloverSelectedFile.canonicalPath();
        boolean rolloverSelectedImageExists = true;
        if(!Os.exists(rolloverSelectedImageAbsolutePath)) {
            if(download) {
                try {
                    Downloader.downloadUsingNIO(githubURLBuilder.getURL(rolloverSelectedImagePath), rolloverSelectedImageAbsolutePath);
                } catch (IOException e) {
                    if(ROLLOVER_SELECTED_IMAGE_MISSING == Constant.THROW_EXCEPTION) {
                        throw new IllegalArgumentException(rolloverImageAbsolutePath + " is missing");
                    }
                    e.printStackTrace();
                    rolloverSelectedImageExists = false;
                }
            } else {
                rolloverSelectedImageExists = false;
            }
        }

        // All missing.
        if(!imageExists && !rolloverImageExists && !selectedImageExists && !rolloverSelectedImageExists) {
            solve(button, ALL_MISSING, dimension);
        }
        // Image & rollover image missing.
        if(!imageExists && !rolloverImageExists) {
            solve(button, BOTH_MISSING, dimension);
        } else if(rolloverImageExists && !imageExists) {
            if(IMAGE_MISSING == Constant.KEEP_ROLLOVER_IMAGE) {
                Icon rolloverIcon = new ImageIcon(rolloverImageAbsolutePath);
                button.setIcon(rolloverIcon);
                button.setSize(rolloverIcon.getIconWidth(), rolloverIcon.getIconHeight());
                makeTransparent(button);
            } else {
                solve(button, IMAGE_MISSING, dimension);
                return;
            }
        } else if(!rolloverImageExists) {
            if(ROLLOVER_IMAGE_MISSING == Constant.KEEP_IMAGE) {
                Icon icon = new ImageIcon(imageAbsolutePath);
                button.setIcon(icon);
                button.setSize(icon.getIconWidth(), icon.getIconHeight());
                makeTransparent(button);
            } else {
                solve(button, ROLLOVER_IMAGE_MISSING, dimension);
                return;
            }
        } else {
            // button size -> image size [ not from rollover image ]
            Icon icon = new ImageIcon(rolloverImageAbsolutePath);
            button.setRolloverIcon(icon);
            icon = new ImageIcon(imageAbsolutePath);
            button.setIcon(icon);
            button.setSize(icon.getIconWidth(), icon.getIconHeight());
            makeTransparent(button);
        }

        // Selected image & rollover selected image missing.
        if(!selectedImageExists && !rolloverSelectedImageExists) {
            solve(button, BOTH_SELECTED_MISSING, dimension);
        } else if(rolloverSelectedImageExists && !selectedImageExists) {
            if(SELECTED_IMAGE_MISSING == Constant.KEEP_ROLLOVER_SELECTED_IMAGE) {
                Icon selectedRolloverIcon = new ImageIcon(rolloverSelectedImageAbsolutePath);
                button.setSelectedIcon(selectedRolloverIcon);
                button.setSize(selectedRolloverIcon.getIconWidth(), selectedRolloverIcon.getIconHeight());
                makeTransparent(button);
            } else {
                solve(button, SELECTED_IMAGE_MISSING, dimension);
            }
        } else if(!rolloverSelectedImageExists) {
            if(ROLLOVER_SELECTED_IMAGE_MISSING == Constant.KEEP_SELECTED_IMAGE) {
                Icon selectedIcon = new ImageIcon(selectedImageAbsolutePath);
                button.setIcon(selectedIcon);
                button.setSize(selectedIcon.getIconWidth(), selectedIcon.getIconHeight());
                makeTransparent(button);
            } else {
                solve(button, ROLLOVER_SELECTED_IMAGE_MISSING, dimension);
            }
        } else {
            // button size -> selected image size [ not from rollover selected image ]
            Icon icon = new ImageIcon(rolloverSelectedImageAbsolutePath);
            button.setRolloverSelectedIcon(icon);
            icon = new ImageIcon(selectedImageAbsolutePath);
            button.setSelectedIcon(icon);
            button.setSize(icon.getIconWidth(), icon.getIconHeight());
            makeTransparent(button);
        }
    }

    @Override
    public void initialize(@NotNull JLabel label,
                           @NotNull InterfacePathProvider file) {
        // Image case.
        String imageAbsolutePath = file.absolutePath();
        String imageCanonicalPath = file.canonicalPath();
        GitHubURLBuilder githubURLBuilder = GitHubURLBuilder.getInstance();
        boolean imageExists = true;
        if(!Os.exists(imageAbsolutePath)) {
            if(download) {
                try {
                    Downloader.downloadUsingNIO(githubURLBuilder.getURL(imageCanonicalPath), imageAbsolutePath);
                } catch (IOException e) {
                    if(IMAGE_MISSING == Constant.THROW_EXCEPTION) {
                        throw new RuntimeException(imageAbsolutePath + " is missing");
                    }
                    e.printStackTrace();
                    imageExists = false;
                }
            } else {
                imageExists = false;
            }
        } if(imageExists) {
            Icon icon = new ImageIcon(imageAbsolutePath);
            label.setIcon(icon);
            label.setOpaque(false);
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
                       @NotNull Constant constant,
                       Dimension dimension) {
        if(constant == Constant.THROW_EXCEPTION) {
            throw new RuntimeException(label.getName() + " not found");
        } else if(constant == Constant.BLUE_LABEL) {
            label.setBackground(Color.BLUE);
        } else if(constant == Constant.CYAN_LABEL) {
            label.setBackground(Color.CYAN);
        } else if(constant == Constant.GREEN_LABEL) {
            label.setBackground(Color.GREEN);
        } else if(constant == Constant.YELLOW_LABEL) {
            label.setBackground(Color.YELLOW);
        } else if(constant == Constant.RED_LABEL) {
            label.setBackground(Color.RED);
        } else {
            throw new IllegalArgumentException("Invalid Constant: " + constant);
        }
        label.setOpaque(true);
        label.setSize(dimension);
    }

    private void solve(@NotNull AbstractButton button,
                       @NotNull Constant constant,
                       Dimension dimension) {
        if(constant == Constant.THROW_EXCEPTION) {
            throw new RuntimeException(button.getName() + " not found");
        } else if(constant == Constant.CYAN_BUTTON) {
            button.setBackground(Color.CYAN);
        } else if(constant == Constant.BLUE_BUTTON) {
            button.setBackground(Color.BLUE);
        } else if(constant == Constant.GREEN_BUTTON) {
            button.setBackground(Color.GREEN );
        } else if(constant == Constant.YELLOW_BUTTON) {
            button.setBackground(Color.YELLOW);
        } else if(constant == Constant.RED_BUTTON) {
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
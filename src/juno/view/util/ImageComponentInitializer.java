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

import juno.init.Downloader;
import juno.init.GitHubURLBuilder;
import juno.init.InterfaceDirectories;
import juno.model.util.Os;
import juno.model.util.PathGenerator;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ImageComponentInitializer {

    private ImageComponentInitializer() {}

    public static void initialize(@NotNull AbstractButton button,
                                  @NotNull InterfaceDirectories path,
                                  boolean download,
                                  String name,
                                  @NotNull String file,
                                  @NotNull String rolloverFile,
                                  Dimension dimension,
                                  @NotNull Constant BOTH_MISSING,
                                  @NotNull Constant IMAGE_MISSING,
                                  @NotNull Constant ROLLOVER_IMAGE_MISSING) {
        // Image section.
        button.setName(name);
        String imageAbsolutePath = PathGenerator.generate(path.absolutePath(), file);
        String imagePath = PathGenerator.generate(path.path(), file);

        GitHubURLBuilder githubURLBuilder = GitHubURLBuilder.getInstance();
        boolean imageExists = true;
        if (!Os.exists(imageAbsolutePath)) {
            if(download) {
                try {
                    Downloader.downloadUsingNIO(githubURLBuilder.getURL(imagePath), imageAbsolutePath);
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
        String rolloverImageAbsolutePath = PathGenerator.generate(path.absolutePath(), rolloverFile);
        String rolloverImagePath = PathGenerator.generate(path.path(), rolloverFile);

        boolean rolloverImageExists = true;
        if(!Os.exists(rolloverImageAbsolutePath)) {
            if(download) {
                try {
                    Downloader.downloadUsingNIO(githubURLBuilder.getURL(rolloverImagePath), rolloverImageAbsolutePath);
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

    public static void initialize(@NotNull AbstractButton button,
                                  @NotNull InterfaceDirectories path,
                                  boolean download,
                                  String name,
                                  String file,
                                  String rolloverFile,
                                  String selectedFile,
                                  String rolloverSelectedFile,
                                  Dimension dimension,
                                  Constant BOTH_MISSING,
                                  Constant BOTH_SELECTED_MISSING,
                                  Constant ALL_MISSING,
                                  Constant IMAGE_MISSING,
                                  Constant ROLLOVER_IMAGE_MISSING,
                                  Constant SELECTED_IMAGE_MISSING,
                                  Constant ROLLOVER_SELECTED_IMAGE_MISSING) {
        // Image case.
        button.setName(name);
        String imageAbsolutePath = PathGenerator.generate(path.absolutePath(), file);
        String imagePath = PathGenerator.generate(path.path(), file);

        GitHubURLBuilder githubURLBuilder = GitHubURLBuilder.getInstance();
        boolean imageExists = true;
        if (!Os.exists(imageAbsolutePath)) {
            if(download) {
                try {
                    Downloader.downloadUsingNIO(githubURLBuilder.getURL(imagePath), imageAbsolutePath);
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
        String rolloverImageAbsolutePath = PathGenerator.generate(path.absolutePath(), rolloverFile);
        String rolloverImagePath = PathGenerator.generate(path.path(), rolloverFile);

        boolean rolloverImageExists = true;
        if(!Os.exists(rolloverImageAbsolutePath)) {
            if(download) {
                try {
                    Downloader.downloadUsingNIO(githubURLBuilder.getURL(rolloverImagePath), rolloverImageAbsolutePath);
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
        String selectedImageAbsolutePath = PathGenerator.generate(path.absolutePath(), selectedFile);
        String selectedImagePath = PathGenerator.generate(path.path(), selectedFile);

        boolean selectedImageExists = true;
        if (!Os.exists(selectedImageAbsolutePath)) {
            if(download) {
                try {
                    Downloader.downloadUsingNIO(githubURLBuilder.getURL(selectedImagePath), selectedImageAbsolutePath);
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
        String rolloverSelectedImageAbsolutePath = PathGenerator.generate(path.absolutePath(), rolloverSelectedFile);
        String rolloverSelectedImagePath = PathGenerator.generate(path.path(), rolloverSelectedFile);

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

        // ALL MISSING
        if(!imageExists && !rolloverImageExists && !selectedImageExists && !rolloverSelectedImageExists) {
            solve(button, ALL_MISSING, dimension);
        }

        // IMAGE & ROLLOVER_IMAGE MISSING
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

        // SELECTED_IMAGE & ROLLOVER_SELECTED_IMAGE MISSING
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

    public static void initialize(@NotNull AbstractButton button,
                                  @NotNull InterfaceDirectories path,
                                  boolean download,
                                  String name,
                                  @NotNull String file,
                                  Dimension dimension,
                                  @NotNull Constant ICON_MISSING) {
        // Image case.
        button.setName(name);
        String imageAbsolutePath = PathGenerator.generate(path.absolutePath(), file);
        String imagePath = PathGenerator.generate(path.path(), file);
        GitHubURLBuilder githubURLBuilder = GitHubURLBuilder.getInstance();
        boolean imageExists = true;
        if(!Os.exists(imageAbsolutePath)) {
            if(download) {
                try {
                    Downloader.downloadUsingNIO(githubURLBuilder.getURL(imagePath), imageAbsolutePath);
                } catch (IOException e) {
                    if(ICON_MISSING == Constant.THROW_EXCEPTION) {
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
            button.setIcon(icon);
            button.setSize(icon.getIconWidth(), icon.getIconHeight());
            makeTransparent(button);
        } else {
            solve(button, ICON_MISSING, dimension);
        }
    }

    public static void initialize(@NotNull JLabel label,
                                  @NotNull InterfaceDirectories path,
                                  boolean download,
                                  String name,
                                  @NotNull String file,
                                  Dimension dimension,
                                  @NotNull Constant ICON_MISSING) {
        // Image case.
        String imageAbsolutePath = PathGenerator.generate(path.absolutePath(), file);
        String imagePath = PathGenerator.generate(path.path(), file);

        GitHubURLBuilder githubURLBuilder = GitHubURLBuilder.getInstance();
        boolean imageExists = true;
        if(!Os.exists(imageAbsolutePath)) {
            if(download) {
                try {
                    Downloader.downloadUsingNIO(githubURLBuilder.getURL(imagePath), imageAbsolutePath);
                } catch (IOException e) {
                    if(ICON_MISSING == Constant.THROW_EXCEPTION) {
                        throw new RuntimeException(imageAbsolutePath + " is missing");
                    }
                    e.printStackTrace();
                    imageExists = false;
                }
            } else {
                imageExists = false;
            }
        }

        label.setName(name);

        if(imageExists) {
            Icon icon = new ImageIcon(imageAbsolutePath);
            label.setIcon(icon);
            label.setOpaque(false);
        } else {
            solve(label, ICON_MISSING, dimension);
        }
    }

    private static void makeTransparent(@NotNull AbstractButton button) {
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
    }

    private static void solve(@NotNull JLabel label,
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

    private static void solve(@NotNull AbstractButton button,
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
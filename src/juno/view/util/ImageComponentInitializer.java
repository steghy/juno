package juno.view.util;

import juno.init.Downloader;
import juno.init.Path;
import juno.init.URLBuilder;
import juno.model.util.Os;
import juno.model.util.PathGenerator;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ImageComponentInitializer {

    private ImageComponentInitializer() {}

    public static void initialize(AbstractButton button,
                                  Path path,
                                  String name,
                                  String file,
                                  String rolloverFile,
                                  Dimension dimension,
                                  Constant BOTH_MISSING,
                                  Constant IMAGE_MISSING,
                                  Constant ROLLOVER_IMAGE_MISSING) {
        // IMAGE
        button.setName(name);
        String imageAbsolutePath = PathGenerator.generate(path.absolutePath(), file);
        String imagePath = PathGenerator.generate(path.path(), file);

        URLBuilder url = URLBuilder.getInstance();
        boolean iconExits = true;
        if (!Os.exists(imageAbsolutePath)) {
            try {
                Downloader.downloadUsingNIO(url.getURL(imagePath), imageAbsolutePath);
            } catch (IOException e) {
                if(IMAGE_MISSING == Constant.THROW_EXCEPTION) {
                    throw new RuntimeException(imageAbsolutePath + " is missing.");
                }
                e.printStackTrace();
                iconExits = false;
            }
        }

        // ROLLOVER IMAGE
        String rolloverImageAbsolutePath = PathGenerator.generate(path.absolutePath(), rolloverFile);
        String rolloverImagePath = PathGenerator.generate(path.path(), rolloverFile);

        boolean rolloverIconExists = true;
        if(!Os.exists(rolloverImageAbsolutePath)) {
            try {
                Downloader.downloadUsingNIO(url.getURL(rolloverImagePath), rolloverImageAbsolutePath);
            } catch (IOException e) {
                if(ROLLOVER_IMAGE_MISSING == Constant.THROW_EXCEPTION) {
                    throw new IllegalArgumentException(rolloverImageAbsolutePath + " is missing");
                }
                e.printStackTrace();
                rolloverIconExists = false;
            }
        }

        // BOTH MISSING
        if(!iconExits && !rolloverIconExists) {
            solve(button, BOTH_MISSING, dimension);
        } else if(rolloverIconExists && !iconExits) {
            if(IMAGE_MISSING == Constant.KEEP_ROLLOVER_IMAGE) {
                Icon rolloverIcon = new ImageIcon(rolloverImageAbsolutePath);
                button.setIcon(rolloverIcon);
                button.setSize(rolloverIcon.getIconWidth(), rolloverIcon.getIconHeight());
                makeTransparent(button);
            } else {
                solve(button, IMAGE_MISSING, dimension);
            }

        } else if(!rolloverIconExists) {
            if(ROLLOVER_IMAGE_MISSING == Constant.KEEP_IMAGE) {
                Icon icon = new ImageIcon(imageAbsolutePath);
                button.setIcon(icon);
                button.setSize(icon.getIconWidth(), icon.getIconHeight());
                makeTransparent(button);
            } else {
                solve(button, ROLLOVER_IMAGE_MISSING, dimension);
            }
        } else {
            Icon icon = new ImageIcon(imageAbsolutePath);
            Icon rolloverIcon = new ImageIcon(rolloverImageAbsolutePath);
            button.setIcon(icon);
            button.setRolloverIcon(rolloverIcon);
            button.setSize(icon.getIconWidth(), icon.getIconHeight());
            makeTransparent(button);
        }
    }

    public static void initialize(AbstractButton button,
                                  Path path,
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
        button.setName(name);


        // IMAGE
        String imageAbsolutePath = PathGenerator.generate(path.absolutePath(), file);
        String imagePath = PathGenerator.generate(path.path(), file);

        URLBuilder url = URLBuilder.getInstance();
        boolean imageExists = true;
        if (!Os.exists(imageAbsolutePath)) {
            try {
                Downloader.downloadUsingNIO(url.getURL(imagePath), imageAbsolutePath);
            } catch (IOException e) {
                if(IMAGE_MISSING == Constant.THROW_EXCEPTION) {
                    throw new RuntimeException(imageAbsolutePath + " is missing.");
                }
                e.printStackTrace();
                imageExists = false;
            }
        }

        // ROLLOVER IMAGE
        String rolloverImageAbsolutePath = PathGenerator.generate(path.absolutePath(), rolloverFile);
        String rolloverImagePath = PathGenerator.generate(path.path(), rolloverFile);

        boolean rolloverImageExists = true;
        if(!Os.exists(rolloverImageAbsolutePath)) {
            try {
                Downloader.downloadUsingNIO(url.getURL(rolloverImagePath), rolloverImageAbsolutePath);
            } catch (IOException e) {
                if(ROLLOVER_IMAGE_MISSING == Constant.THROW_EXCEPTION) {
                    throw new IllegalArgumentException(rolloverImageAbsolutePath + " is missing");
                }
                e.printStackTrace();
                rolloverImageExists = false;
            }
        }

        // SELECTED IMAGE
        String selectedImageAbsolutePath = PathGenerator.generate(path.absolutePath(), selectedFile);
        String selectedImagePath = PathGenerator.generate(path.path(), selectedFile);

        boolean selectedImageExists = true;
        if (!Os.exists(selectedImageAbsolutePath)) {
            try {
                Downloader.downloadUsingNIO(url.getURL(selectedImagePath), selectedImageAbsolutePath);
            } catch (IOException e) {
                if(SELECTED_IMAGE_MISSING == Constant.THROW_EXCEPTION) {
                    throw new RuntimeException(selectedImageAbsolutePath + " is missing.");
                }
                e.printStackTrace();
                selectedImageExists = false;
            }
        }

        // ROLLOVER SELECTED IMAGE
        String rolloverSelectedImageAbsolutePath = PathGenerator.generate(path.absolutePath(), rolloverSelectedFile);
        String rolloverSelectedImagePath = PathGenerator.generate(path.path(), rolloverSelectedFile);

        boolean rolloverSelectedImageExists = true;
        if(!Os.exists(rolloverSelectedImageAbsolutePath)) {
            try {
                Downloader.downloadUsingNIO(url.getURL(rolloverSelectedImagePath), rolloverSelectedImageAbsolutePath);
            } catch (IOException e) {
                if(ROLLOVER_SELECTED_IMAGE_MISSING == Constant.THROW_EXCEPTION) {
                    throw new IllegalArgumentException(rolloverImageAbsolutePath + " is missing");
                }
                e.printStackTrace();
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
            Icon icon = new ImageIcon(imageAbsolutePath);
            Icon rolloverIcon = new ImageIcon(rolloverImageAbsolutePath);
            button.setIcon(icon);
            button.setRolloverIcon(rolloverIcon);
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
            Icon selectedIcon = new ImageIcon(selectedImageAbsolutePath);
            Icon rolloverSelectedIcon = new ImageIcon(rolloverSelectedImageAbsolutePath);
            button.setSelectedIcon(selectedIcon);
            button.setRolloverSelectedIcon(rolloverSelectedIcon);
            button.setSize(rolloverSelectedIcon.getIconWidth(), rolloverSelectedIcon.getIconHeight());
            makeTransparent(button);
        }
    }

    public static void initialize(AbstractButton button,
                                  Path path,
                                  String name,
                                  String file,
                                  Dimension dimension,
                                  Constant ICON_MISSING) {
        // IMAGE
        String imageAbsolutePath = PathGenerator.generate(path.absolutePath(), file);
        String imagePath = PathGenerator.generate(path.path(), file);

        URLBuilder url = URLBuilder.getInstance();
        boolean iconExists = true;
        if(!Os.exists(imageAbsolutePath)) {
            try {
                Downloader.downloadUsingNIO(url.getURL(imagePath), imageAbsolutePath);
            } catch (IOException e) {
                if(ICON_MISSING == Constant.THROW_EXCEPTION) {
                    throw new RuntimeException(imageAbsolutePath + " is missing");
                }
                e.printStackTrace();
                iconExists = false;
            }
        }

        button.setName(name);

        if(iconExists) {
            Icon icon = new ImageIcon(imageAbsolutePath);
            button.setIcon(icon);
            makeTransparent(button);
        } else {
            solve(button, ICON_MISSING, dimension);
        }
    }

    public static void initialize(JLabel label,
                                  Path path,
                                  String name,
                                  String file,
                                  Dimension dimension,
                                  Constant ICON_MISSING) {
        // IMAGE
        String imageAbsolutePath = PathGenerator.generate(path.absolutePath(), file);
        String imagePath = PathGenerator.generate(path.path(), file);

        URLBuilder url = URLBuilder.getInstance();
        boolean iconExists = true;
        if(!Os.exists(imageAbsolutePath)) {
            try {
                Downloader.downloadUsingNIO(url.getURL(imagePath), imageAbsolutePath);
            } catch (IOException e) {
                if(ICON_MISSING == Constant.THROW_EXCEPTION) {
                    throw new RuntimeException(imageAbsolutePath + " is missing");
                }
                e.printStackTrace();
                iconExists = false;
            }
        }

        label.setName(name);

        if(iconExists) {
            Icon icon = new ImageIcon(imageAbsolutePath);
            label.setIcon(icon);
            label.setOpaque(false);
        } else {
            solve(label, ICON_MISSING, dimension);
        }
    }

    private static void makeTransparent(AbstractButton button) {
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
    }

    private static void solve(JLabel label, Constant constant, Dimension dimension) {
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

    private static void solve(AbstractButton button, Constant constant, Dimension dimension) {
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
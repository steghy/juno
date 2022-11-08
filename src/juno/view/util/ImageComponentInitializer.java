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
                                  Constant ICON_MISSING,
                                  Constant ROLLOVER_ICON_MISSING) {
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
                if(ICON_MISSING == Constant.THROW_EXCEPTION) {
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
                if(ROLLOVER_ICON_MISSING == Constant.THROW_EXCEPTION) {
                    throw new IllegalArgumentException(rolloverImageAbsolutePath + " is missing");
                }
                e.printStackTrace();
                rolloverIconExists = false;
            }
        }

        if(!iconExits && !rolloverIconExists) {
            solve(button, BOTH_MISSING, dimension);
        } else if(rolloverIconExists && !iconExits) {
            if(ICON_MISSING == Constant.KEEP_ROLLOVER_ICON) {
                Icon rolloverIcon = new ImageIcon(rolloverImageAbsolutePath);
                button.setIcon(rolloverIcon);
                makeTransparent(button);
            } else {
                solve(button, ICON_MISSING, dimension);
            }
        } else if(iconExits && !rolloverIconExists) {
            if(ROLLOVER_ICON_MISSING == Constant.KEEP_ICON) {
                Icon icon = new ImageIcon(imageAbsolutePath);
                button.setIcon(icon);
                makeTransparent(button);
            } else {
                solve(button, ROLLOVER_ICON_MISSING, dimension);
            }
        } else {
            Icon icon = new ImageIcon(imageAbsolutePath);
            Icon rolloverIcon = new ImageIcon(rolloverImageAbsolutePath);
            button.setIcon(icon);
            button.setRolloverIcon(rolloverIcon);
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
            button.setSize(icon.getIconWidth(), icon.getIconHeight());
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
            label.setSize(icon.getIconWidth(), icon.getIconWidth());
            label.setOpaque(false);
        } else {
            solve(label, ICON_MISSING, dimension);
        }
    }

    private static void makeTransparent(AbstractButton button) {
        button.setBorderPainted(false);
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
        button.setSize(dimension);
    }
}
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

package juno.model.data.io.input.reflection.test;

import juno.init.Directories;
import juno.model.data.io.input.InputPKGInitializer;
import juno.model.data.io.input.reflection.RConfigurationFilesProvider;
import juno.model.util.PathGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class ConfigurationFilesProviderTester {

    public static void main(String[] args) {
        // Initialization.
        InputPKGInitializer.initialize();

        RConfigurationFilesProvider filesProvider = RConfigurationFilesProvider.getInstance();
        filesProvider.extensions().add("json");
        filesProvider.setRecursive(false);


        String path = PathGenerator.generate(Directories.CONFIG.absolutePath(), "");

        System.out.println("Pre configuration files provider");

        MyObject object = new MyObject();

        PrintStatus.printStatus(object);

        System.out.println("-------------------------------");

        // Getting configuration files
        List<File> configurationFiles;
        try {
            configurationFiles = filesProvider.getConfigurationFiles(object, path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        configurationFiles.forEach(System.out::println);

        System.out.println("-------------------------------");
        System.out.println("Post configuration files provider");

        PrintStatus.printStatus(object);


    }
}

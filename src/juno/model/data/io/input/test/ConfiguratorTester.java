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

package juno.model.data.io.input.test;

import juno.init.Directories;
import juno.model.data.io.input.*;
import juno.model.util.PathGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Objects;

public class ConfiguratorTester {

    // DATA IMPORTER COMPONENT
    private final static JSONDataImporter jsonDataImporter = JSONDataImporter.getInstance();

    // CLASS TARGET
    private final static Class<?> clazz = MyClass.class;

    public static void main(String[] args) {
        String myClassConfigPath = PathGenerator.generate(Directories.CONFIG.absolutePath(), "");

        // DEEP COPIER
        PropertyDeepCopier deepCopier = PropertyDeepCopier.getInstance();

        // INITIALIZATION
        InputDataInitializer.initialize();

        // RCONFIGURATOR TEST
        System.out.println("///// Pre configuration /////");
        System.out.println(deepCopier.deepCopy(clazz));

        // Recursive parameter setting
        RConfigurationFilesProvider.getInstance().setRecursive(true);

        try {
             ConfigurationFilesProvider.getInstance().getConfigurationFiles(clazz, myClassConfigPath).forEach(System.out::println);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("///// Post configuration /////");
        System.out.println(deepCopier.deepCopy(clazz));
    }
}
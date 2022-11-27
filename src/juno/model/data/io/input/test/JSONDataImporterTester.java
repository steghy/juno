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
import juno.model.data.io.input.JSONDataImporter;
import juno.model.util.PathGenerator;

import java.io.IOException;
import java.util.Map;

public class JSONDataImporterTester {

    public static void main(String[] args) throws IOException {
        JSONDataImporter dataImporter = JSONDataImporter.getInstance();
        String targetPath = PathGenerator.generate(Directories.CONFIG.absolutePath(), "output-file.json");
        Map<String, Object> map = dataImporter.importData(targetPath);
        printMap(map);
    }

    @SuppressWarnings("unchecked")
    private static void printMap(Map<String, Object> map) {
        map.forEach((k, v) -> {
            System.out.print(k + " = ");
            if(v instanceof Map<?, ?> anotherMap) {
                System.out.print(" { ");
                printMap((Map<String, Object>) v);
                System.out.println(" } ");
            } else {
                System.out.print(v + " type -> ");
                System.out.println(v.getClass().getSimpleName());
            }
        });
    }
}

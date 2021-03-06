/*
 * Copyright (C) 2011 Nipuna Gunathilake.
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.usf.cutr.gtfsrtvalidator.helper;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

public class GetFile {
    public InputStream getFileFromJar(String path) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(path);
        return is;
    }

    public File getJarLocation() {
        URL jarLocation = this.getClass().getProtectionDomain().getCodeSource().getLocation();
        File f = null;
        try {
            f = new File(jarLocation.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return f;
    }

    // convert InputStream to String
    public static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}

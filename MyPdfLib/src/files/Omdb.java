/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author stavros
 */
public class Omdb {

    public static String[] getMovieDetails(String title) throws IOException {
        String[] find = {"Title", "Year", "Genre", "imdbRating", "Plot"};
        String[] rslt = new String[6];

        String url = "http://www.omdbapi.com/?t=" + title.replace(" ", "+") + "&type=movie&plot=full&r=json";
        URLConnection connection = new URL(url).openConnection();
        InputStream response = connection.getInputStream();
        String json;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(response))) {
            json = br.readLine();
        }

        json = json.substring(2, json.length() - 2);
        json = json.replace('"', '_');
        String[] pairs = json.split("_,_", -2);

        int nPairs = pairs.length, i;
        String[] attrNames = new String[nPairs];
        String[] attrValues = new String[nPairs];
        for (i = 0; i < nPairs; i++) {
            String split[] = pairs[i].split("_:_");
            attrNames[i] = split[0];
            attrValues[i] = split[1];
        }
        if ((i = getIndexOf(attrNames, "Error")) != -1) {
            rslt[0] = attrValues[i];
            return rslt;
        }

        rslt[0] = "OK";
        for (i = 1; i <= 5; i++) {
            int index = getIndexOf(attrNames, find[i-1]);
            rslt[i] = attrValues[index];
        }
        return rslt;
    }

    private static int getIndexOf(String[] in, String s) {
        for (int i = 0; i < in.length; i++) {
            if (s.equals(in[i])) {
                return i;
            }
        }
        return -1;
    }
}

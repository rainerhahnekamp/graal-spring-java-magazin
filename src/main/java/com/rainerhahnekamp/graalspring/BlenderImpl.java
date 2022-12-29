package com.rainerhahnekamp.graalspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlenderImpl implements Blender, Runnable {

    public static final Colour[][][] colours = new Colour[100][100][100];

    // Implementierung von Blender

    @Override
    public void run() {
        var id = new Colour(0, 0, 0);
        for (int x = 0; x < colours.length; x++) {
            Colour[][] plane = colours[x];
            for (int y = 0; y < plane.length; y++) {
                Colour[] row = plane[y];
                for (int z = 0; z < row.length; z++) {
                    Colour colour = new Colour(x, y, z);
                    colour.add(id);
                    if ((colour.r + colour.g + colour.b) % 42 == 0) {
                        row[z] = colour;
                    }
                }
            }
        }
    }


    public static class Colour {
        double r, g, b;

        Colour(double r, double g, double b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }

        public void add(Colour other) {
            r += other.r;
            g += other.g;
            b += other.b;
        }
    }
}

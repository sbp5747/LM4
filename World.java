import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class World {
    private String[][] world;
    private Point starting_position;

    public World() {
        world = new String[5][5]; // Set the world size to 5x5
        starting_position = new Point(0, 0); // Set the starting position to (0, 0)
    }

    public void load_tiles() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("map.txt"));
            ArrayList<String> rows = new ArrayList<String>();
            String line;
            while ((line = reader.readLine()) != null) {
                rows.add(line);
            }
            reader.close();

            int numRows = rows.size();
            int numCols = rows.get(0).split(",").length;

            world = new String[numRows][numCols];

            for (int i = 0; i < numRows; i++) {
                String[] tiles = rows.get(i).split(",");
                for (int j = 0; j < numCols; j++) {
                    world[i][j] = tiles[j];
                    if (tiles[j].equals("S")) {
                        starting_position.setLocation(j, i);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
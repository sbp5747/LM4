import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class MapTile {
    private int x;
    private int y;

    public MapTile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public List<MapTile> adjacent_moves() {
        List<MapTile> moves = new ArrayList<MapTile>();
        moves.add(new MapTile(x, y - 1)); // Move North
        moves.add(new MapTile(x, y + 1)); // Move South
        moves.add(new MapTile(x - 1, y)); // Move West
        moves.add(new MapTile(x + 1, y)); // Move East
        return moves;
    }
}
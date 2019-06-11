
import java.util.ArrayList;



class Node {


    private String id;

    private ArrayList<edges> edges;

    private boolean infinite;


    Node(String id) {
        this.id = id;
        this.edges = new ArrayList<>();
    }




    boolean isInfinite() {
        return infinite;
    }

    void setInfinite(boolean infinite) {
        this.infinite = infinite;
    }

    ArrayList<edges> getEdges() {
        return edges;
    }



    void addEdge(String s, String At, String pop, String push, String d) {
        this.edges.add(new edges(s, At, pop, push, d));
    }

}

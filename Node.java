import java.util.ArrayList;
import java.util.List;

class Node implements Comparable<Node> {

  public int val;
  public int discovery_time;
  public int finish_time;
  public Node parent;
  public String color;

  public List<Node>  neighbours;

  Node(int x) {
    this.neighbours = new ArrayList<Node>();
    this.val = x;
    this.color = "white";
  }

  public void addNeighbour(Node newNode) {
    this.neighbours.add(newNode);
  }

  public void addNeighbour(Node n1, Node n2, Node n3) {
    this.neighbours.add(n1);
    this.neighbours.add(n2);
    this.neighbours.add(n3);
  }

  public void addNeighbour(Node n1, Node n2) {
    this.neighbours.add(n1);
    this.neighbours.add(n2);
  }

  @Override
  public int compareTo(Node o) {
    return o.finish_time - this.finish_time;
  }
}

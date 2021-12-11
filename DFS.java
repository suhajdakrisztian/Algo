import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class TopologicalSort extends DFS {
  public static void TS(Node root) {

    if(results.size() == 0)
      DepthFirstSearch(root);

    List<Node> dummy = results;
    Collections.sort(dummy);

    for(int i = 0; i < dummy.size(); i++) {
      if(i == dummy.size() - 1)
        System.out.print(dummy.get(i).val);
      else
        System.out.print(dummy.get(i).val + ",");
    }
    System.out.print("\n");
  }
}

class DFS {

  public static List<Node> results = new ArrayList<Node>();
  public static Integer time = 0;

  public static void DepthFirstSearch(Node root) {

    root.discovery_time = ++time;
    root.color = "grey";
    results.add(root);
    

    for(Node element: root.neighbours) {
       if(element.color == "white") {
         element.parent = root;
         DepthFirstSearch(element);
       } 
    }
    root.finish_time = ++time;
    root.color = "black";
  }

  public static void getResults() {
      for(Node elem: results) {
        if(elem.parent != null)
          System.out.println("Node: "+ elem.val + " Discovery: " + elem.discovery_time + " Finish:" + elem.finish_time + " Parent: " + elem.parent.val);
        else
          System.out.println("Node: "+ elem.val + " Discovery: " + elem.discovery_time + " Finish:" + elem.finish_time + " Parent: " + 0);
      }
  }

  public static void main(String[] args) {

    Node egy = new Node(1);
    Node ketto = new Node(2);
    Node harom = new Node(3);
    Node negy = new Node(4);
    Node ot = new Node(5);
    Node hat = new Node(6);

    egy.addNeighbour(ketto, harom);
    ketto.addNeighbour(negy, ot);
    negy.addNeighbour(hat);
    harom.addNeighbour(ot);
    ot.addNeighbour(hat);
    

    DepthFirstSearch(egy);
    TopologicalSort.TS(egy);

    getResults();

  }
}
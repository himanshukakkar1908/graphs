
/*

1. You are given a graph and a src vertex.
2. You are required to find and print all hamiltonian paths and cycles starting from src. The cycles must end with "*" and paths with a "."

Note -> A hamiltonian path is such which visits all vertices without visiting any twice. A hamiltonian path becomes a cycle if there is an edge between first and last vertex.
Note -> Print in lexicographically increasing order.

Constraints
None

Sample Input

7
9
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
2 5 10
0

Sample Output
0123456.
0123465.
0125643*
0346521*

 */



import java.util.ArrayList;
import java.util.Scanner;

public class hamiltonian{
    static class Edge{
        int src;
        int nbr;
        int wt;
        Edge(int src,int nbr,int wt){
            this.src=src;
            this.nbr=nbr;
            this.wt=wt;
        }
    }

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);

        int vertices=scn.nextInt();
        int edges=scn.nextInt();

        ArrayList<Edge>[] graph=new ArrayList[vertices];

        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=1;i<=edges;i++){
            int src=scn.nextInt();
            int nbr=scn.nextInt();
            int wt= scn.nextInt();
            Edge e=new Edge(src,nbr,wt);
            graph[src].add(e);
            Edge e_=new Edge(nbr,src,wt);
            graph[nbr].add(e_);
        }

        int src=scn.nextInt();

        boolean[] visited=new boolean[vertices];

        print_all_paths_func(graph,src,visited,"",src);

    }

    public static void print_all_paths_func(ArrayList<Edge>[] graph,int src,boolean[] visisted,String psf,int start){

        psf+=src;
        visisted[src]=true;

        if(psf.length()==graph.length){
            for(Edge e:graph[src]){
                if(e.nbr==start){
                    System.out.println(psf+"*");
                    visisted[src]=false;
                    return;
                }
            }
            System.out.println(psf+".");
            visisted[src]=false;
            return;
        }

        for(int next_vertex=0;next_vertex<graph.length;next_vertex++){
            for(Edge e:graph[src]){
                if(e.nbr==next_vertex && !visisted[next_vertex]){
                    print_all_paths_func(graph,next_vertex,visisted,psf,start);
                }
            }
        }

        visisted[src]=false;

    }

}

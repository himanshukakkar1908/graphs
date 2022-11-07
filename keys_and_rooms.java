import java.util.ArrayList;
import java.util.Scanner;

public class keys_and_rooms {

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
            int dest=scn.nextInt();

            boolean[] visited=new boolean[vertices];

        }

}

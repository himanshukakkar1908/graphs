import java.util.ArrayList;
import java.util.Scanner;

/*

7
5
0 1
2 3
4 5
5 6
4 6

 */

public class perfect_friends {

        static class Edge{
            int src;
            int nbr;
            int wt;
            Edge(int src,int nbr,int wt){
                this.src=src;
                this.nbr=nbr;
                this.wt=wt;
            }

            Edge(int src,int nbr){
                this.src=src;
                this.nbr=nbr;
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
                Edge e=new Edge(src,nbr);
                graph[src].add(e);
                Edge e_=new Edge(nbr,src);
                graph[nbr].add(e_);
            }

            boolean[] visited=new boolean[vertices];

            ArrayList<Integer> components_size=new ArrayList<>();

            for(int i=0;i<graph.length;i++){
                if(!visited[i]) {
                    components_size.add(dfs(graph, i, visited));
                }
            }

            int ways=0;

            for(int i=0;i<components_size.size();i++){
                for(int j=i+1;j<components_size.size();j++){
                    ways+=components_size.get(i)*components_size.get(j);
                }
            }

            System.out.println(ways);

        }

        public static int dfs(ArrayList<Edge>[] graph, int src, boolean[] visited){

            visited[src]=true;

            int count=0;

            for(Edge e:graph[src]){
                if(!visited[e.nbr]) {
                    count+=dfs(graph, e.nbr, visited);
                }
            }

            count+=1;
            return count;

        }

}

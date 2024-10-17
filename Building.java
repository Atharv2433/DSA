public class Building{
    ArrayList<ArrayList<Integer> adj;
    public Building(int n){
        adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
    }
    public void addedge(int source , int destination){

        adj.get(source - 1).add(destination);
        adj.get(destination - 1).add(source);

    }


    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Building b = new Building(n);

        int m = sc.nextInt();

        for(int i =0; i < m; i++){
            
            int source = sc.nextInt();
            int destination = sc.nextInt();

            addedge(source,destination);
        }



    }
}
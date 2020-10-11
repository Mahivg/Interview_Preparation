public class JosephusProblem {

    public static void main(String args[]){

        JosephusProblem jsp = new JosephusProblem();
        int n = 14, k = 2;
        int freed = jsp.findTheFreed(n,k);
        System.out.println("Freed person : " + freed);
    }

    private int findTheFreed(int n, int k) {
        if(n<=1){
            System.out.println("Killing person at " + k + " in " + (n-1) + " people" );
            return n;
        }
        //System.out.println("Killing person at " + k + " in " + (n-1) + " people" );
        return (findTheFreed(n-1,k) + k) % n;
//        return (findTheFreed(n-1,k) + k - 1) % n;
//        return (findTheFreed(n-1,k) + k - 1) % n + 1;
    }
}

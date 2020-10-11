public class BestTimeToBuyStock {

    public static void main(String[] args){

        BestTimeToBuyStock bts = new BestTimeToBuyStock();

        int[] profits = {23, 13, 25, 29, 33, 19, 34, 45, 65, 67};
        
        int k = 2;

        bts.findProfitForAnyTransaction(profits);
        
        bts.findProfitWithKTransaction(profits, k);
    }

    private void findProfitWithKTransaction(int[] profits, int k) {
    }

    private void findProfitForAnyTransaction(int[] profits) {

        int localMinima = -1, localMaxima = -1;
        boolean profitFlag = true;
        int n = profits.length;
        int profit = 0;

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < n; i++){

            int before = (i==0)?0:profits[i-1];
            int after = (i== n-1)?0:profits[i+1];

            if(i==0 && profitFlag && profits[i]<= after){
                localMinima = i;
                profitFlag = !profitFlag;
            }


            if(profits[i] >= before && profits[i] >= after && !profitFlag){
                localMaxima = i;
                sb.append("(" + localMinima + " " + localMaxima + ") ");
                profit += (profits[localMaxima] - profits[localMinima]);
                profitFlag =! profitFlag;
            }
            else if(profits[i] <= before && profits[i] <= after && profitFlag){
                localMinima = i;
                profitFlag = !profitFlag;
            }
        }
        if(localMinima == -1 && localMaxima == -1){
            System.out.println("No Profit");
        }else{
            System.out.print(sb.toString().trim());
            System.out.println("Profit " + profit);
        }
    }
}

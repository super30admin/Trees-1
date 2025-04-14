

So in this Question we have to find out the confusing numbers upto given number.
The intuotion here is we know th e confusing numbers from 0 to 9 and then we will further go using dfs traversal
Time Complexity : 5^L
Space Complexity : O(L)
We will put the confusing numbers from 0 to 9 in a map
class solution{
    HashMap<Integer,Integer> map;
    int count;
    public int confusingNumber(int n){
        if(n==0){
            return 0;
        }
        map = new HashMap<>();
        count =0;
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
        dfs(0,n);
    }
    // DFS traversal
    private void dfs(long curr, int n){
        //base
        if(curr > n ){
            return;
        }
        //logic
        if(isConfusing(curr)){
            count++;
        }
        for(long key : map.keySet()){
            long newNumber = curr * 10 + key;  
               // 1* 10 +1
            if(newNumber != 0){   // why are we adding this condition because it will always be 0*10+0 always and it will be overflow because it will keep on generating stack frames and it will be 0 always
                dfs(newNumber,n);
            }
            
        }
    }
    //Method to find out weather the number is confusing or not
    private boolean isConfusing(long num){
        long rev=0;
        long temp = num;
        while(temp > 0){
            int rem = (int) num%10;
            rev = rev * 10 + map.get(rem);
            temp = temp/10;
        }
        return num!= rev;
    }
}


public class Struct{
    int numUsers;
    long sum;
    Set<Integer> user;
    List<List<Integer>> bids;
    
    Struct(){
        numUsers = 0;
        sum = 0;
        user = new HashSet<Integer>();
        bids = new ArrayList<>();
    }
}
//<user id, number of shares, bidding price, timestamp>
public class Bids {
    public List<Integer> distributeBids(List<List<Integer>> bids, int transactions){
        TreeMap<Integer,Struct> map = new TreeMap<>(Collections.reverseOrder());
        Set<Integer> gotShares = new HashSet<>();
        for(List<Integer> bid: bids){
            map.putIfAbsent(bid.get(2),new Struct());
            map.get(bid.get(2)).numUsers++;
            map.get(bid.get(2)).sum+=bid.get(1);
            map.get(bid.get(2)).user.add(bid.get(0));
            map.get(bid.get(2)).bids.add(bid);
            gotShares.add(bid.get(0));
        }
        Iterator<Map.Entry<Integer, Struct>> itr = map.entrySet().iterator();
        while(transactions>0&&itr.hasNext()){
            Map.Entry<Integer, Struct> pair = itr.next();
            if(transactions>=pair.getValue().numUsers){
                for(int us: pair.getValue().user){
                    gotShares.remove(us);
                }
                transactions-=pair.getValue().sum;
            }
            else{
                Comparator<List<Integer>> comparator = (List<Integer> o1, List<Integer> o2) -> o1.get(3)-o2.get(3) ;
                List<List<Integer>> bidsL = pair.getValue().bids;
                Collections.sort(bidsL,comparator);
                int index = 0;
                while(transactions>0){
                    transactions-=1;
                    gotShares.remove(bidsL.get(index).get(0));
                    index++;
                }

            }


        }
        List<Integer> ret = new ArrayList<Integer>(gotShares);
        return ret;

    }
}
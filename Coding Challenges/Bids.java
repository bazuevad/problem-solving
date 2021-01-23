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
    public void main(String[] args){
        Bids test = new Bids();
        List<Integer> first = new ArrayList<>(Arrays.asList(1,2,5,0));
        List<Integer> second = new ArrayList<>(Arrays.asList(2,1,4,2));
        List<Integer> third = new ArrayList<>(Arrays.asList(3,5,4,6));
        List<List<Integer>> testBids = new ArrayList<>(Arrays.asList(first,second,third));
        test.distributeBids(testBids, 3);
        first = new ArrayList<>(Arrays.asList(1,2,4,6208));
        testBids = new ArrayList<>(Arrays.asList(first));
        test.distributeBids(testBids, 2);
        first = new ArrayList<>(Arrays.asList(1,3,1,9866));
        second = new ArrayList<>(Arrays.asList(2,1,2,5258));
        third = new ArrayList<>(Arrays.asList(3,2,4,5788));
        List<Integer> fourth = new ArrayList<>(Arrays.asList(4,2,4,6536));
        testBids = new ArrayList<>(Arrays.asList(first,second,third,fourth));
        test.distributeBids(testBids, 2);
    }
}
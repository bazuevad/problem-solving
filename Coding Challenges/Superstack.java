public String Superstack(String[] operations){
    Stack<Integer> stack = new Stack<>();
    Map<Integer,Integer> map = new HashMap<>();
    for(int i = 0; i < operations.length;i++){
        String[] splitted = operations[i].split(" ");
        if(splitted[0].compareTo("push")==0){
            stack.push(Integer.parseInt(splitted[1]));
            System.out.println(stack.peek());
        }
        else if(splitted[0].compareTo("pop")==0){
            if(stack.size()==0){
                System.out.println("EMPTY");
            }
            else{
                int key = stack.size();
                // System.out.println(stack.peek());
                stack.pop();
                if(stack.size()==0){
                    System.out.println("EMPTY");
                }
                else{
                    if(map.containsKey(key)){
                        if(map.containsKey(key-1)){
                            map.replace(key-1,map.get(key-1)+map.get(key));
                        }
                        else{
                            map.put(key-1,map.get(key));
                        }
                        map.remove(key);
                        System.out.println(stack.peek()+map.get(key-1));
                    }
                    else{
                        System.out.println(stack.peek());
                    }
                }
            }
        }
        else if(splitted[0].compareTo("inc")==0){
            int key = Integer.parseInt(splitted[1]);
            int val = Integer.parseInt(splitted[2]);
            if(map.containsKey(key)){
                map.replace(key,map.get(key)+val);
            }
            else{
                map.put(key,val);
            }
            int size = stack.size();
            if(size==0){
                System.out.println("EMPTY");
            }
            else{
                if(map.containsKey(size)){
                    System.out.println(stack.peek()+map.get(size));
                }
            }   
        }
    }
    int size = stack.size();
    if(size==0){
        return "EMPTY";
    }
    if(map.containsKey(size)){
        int ret = stack.peek()+map.get(size);
        return Integer.toString(ret);
    }
    return Integer.toString(stack.peek());
    }
    

    String a = "push 4";
    String b = "push 5";
    String c = "inc 2 1";
    String d = "pop";
    String e = "pop";
    String[] test = {a,b,c,d,e};
    Superstack(test);



    


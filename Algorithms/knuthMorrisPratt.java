public static boolean knuthMorrisPrattAlgorithm(String string, String substring) {
    int[] pattern = buildPattern(substring);
    return doesMatch(string,substring,pattern);
  }
	public static int[] buildPattern(String substring){
		int[] patt = new int[substring.length()];
		Arrays.fill(patt,-1);
		int i = 0;
		int j = 1;
		while(j<substring.length()){
			if(substring.charAt(j)==substring.charAt(i)){
				patt[j] = i;
				i++;
				j++;
			}
			else if(i>0){
				i = patt[i-1]+1;
			}
			else{
				j++;
			}
		}
		return patt;
	}
	
	public static boolean doesMatch(String string, String substring, int[] patt){
		int i = 0;
		int j = 0;
		while(i+substring.length()-j<=string.length()){
			if(string.charAt(i)==substring.charAt(j)){
				if(j==substring.length()-1){
					return true;
				}
				i++;
				j++;
			}
			else if(j>0){
				j = patt[j-1]+1;
			}
			else{
				i++;
			}
		}
		return false;
	}
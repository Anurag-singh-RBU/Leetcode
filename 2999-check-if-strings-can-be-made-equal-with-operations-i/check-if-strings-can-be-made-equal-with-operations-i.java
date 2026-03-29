class Solution {

    public static void swap(char[] arr , int i , int j){

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public boolean canBeEqual(String s1, String s2) {
        
        if(s1.equals(s2)) return true;

        char[] f = s1.toCharArray();

        Set<String> hs = new HashSet<>();

        hs.add(new String(f));

        swap(f , 0 , 2);
        hs.add(new String(f));

        swap(f , 0 , 2);

        swap(f , 1 , 3);
        hs.add(new String(f));

        swap(f , 0 , 2);
        hs.add(new String(f));

        return hs.contains(s2);

    }
}
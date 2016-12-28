package sorttest;


public class sortTestCalss implements Comparable<sortTestCalss>{
    long ID;
    long DATA;
    
    

    public sortTestCalss(long ID, long DATA) {
        this.ID = ID;
        this.DATA = DATA;
    }
    
    @Override
    public int compareTo(sortTestCalss o) {
        return Long.signum(DATA - o.DATA);
    }
    
}

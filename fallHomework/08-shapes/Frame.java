//make a frame out of 2 given ints
public class Frame{
    public String frame (int r , int c){
        int rc;
        int cc;
        String out= "";
        for (rc=0; rc<r; rc ++){
            
            for (cc=0; cc<c; cc++){
                if (rc==0 || rc== r-1){
                    out+="*";
                }
                else {
                    if (cc==0 || cc==r-1){
                        out+="*";
                    }
                    else {
                        out +=" ";
                    }
                }
            }
            out+="*";
            out+="\n";
        }
        return out;
    }
}
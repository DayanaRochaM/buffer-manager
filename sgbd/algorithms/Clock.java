package sgbd.algorithms;

import java.util.LinkedHashMap;

public class Clock extends AbstractAlgorithm{
 
    public Clock(){
        super.setCache(new LinkedHashMap<>(5, 5, false));
    }

    @Override
    public boolean evict() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

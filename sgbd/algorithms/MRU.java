package sgbd.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import sgbd.objects.Frame;

public class MRU extends AbstractAlgorithm{
    
    public MRU(){
         super.setCache(new LinkedHashMap<>(5, 5, true));
    }
    
    @Override
    public boolean evict() {
        
        Frame removedPage;
        List<Integer> allKeys = new ArrayList<>(super.getCache().keySet());
        Collections.reverse(allKeys);
        for(int key : allKeys){
            Frame page = super.getCache().get(key);
            removedPage = page;
            super.getCache().remove(key);
            super.showRemovedPage(removedPage);
            }
        return true;
    }
}
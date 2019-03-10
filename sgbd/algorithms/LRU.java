package sgbd.algorithms;

import sgbd.objects.Frame;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRU extends AbstractAlgorithm{
    
    public LRU(){
        super.setCache(new LinkedHashMap<>(5, 5, true));
    }
    
    @Override
    public boolean evict() {
        
        Frame removedPage;
        for(Map.Entry<Integer, Frame> page: super.getCache().entrySet()){
            removedPage = page.getValue();
            super.getCache().remove(page.getKey());
            super.showRemovedPage(removedPage);
        }
        return true;
    }
}
   
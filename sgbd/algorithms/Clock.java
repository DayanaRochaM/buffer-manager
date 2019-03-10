package sgbd.algorithms;

import java.util.LinkedHashMap;
import java.util.Map;
import sgbd.objects.Frame;

public class Clock extends AbstractAlgorithm{
    
    public Clock(){
        super.setCache(new LinkedHashMap<>(5, 5, false));
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

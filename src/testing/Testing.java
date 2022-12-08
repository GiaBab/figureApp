package testing;

import org.junit.Assert;
import org.junit.Test;

import dataStructure.ArchiveSystem;
import dataStructure.ArrayFigure;

public class Testing {
    
    @Test
    public void name() 
    {
        Assert.assertTrue(ArchiveSystem.getInstance() instanceof ArchiveSystem);
    }

    @Test
    public void name2()
    {
        
    }
}

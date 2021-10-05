package JeanEstProject.logic.flow.impl;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ModuloTest {
   private Modulo mod;
    @Before
    public void setUp() throws Exception {
        mod=new Modulo();
    }
    @Test
    public void testMod(){
Integer result=mod.doMod(9,5);
assertNotNull("null not excepted",result);
assertEquals("must be 4",4,result.intValue());
    }

    @Test
    public void testModBy0(){
        try{
mod.doMod(9,0);
fail("Throw exception");
        }catch (Exception e) {
assertTrue("Not as expected",e.getMessage().equalsIgnoreCase("Some reason"));
         }

    }
}

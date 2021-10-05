package JeanEstProject.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FetchAccountTypeFlowimplTest {
private FetchAccountTypeFlowimpl classToTest;
    @Before
    public void setUp() throws Exception {
        classToTest=new FetchAccountTypeFlowimpl(null);
    }

    @After
    public void tearDown() throws Exception {
        classToTest=null;
    }

    @Test
    public void methodTest() {
        assertTrue(classToTest.methodTest());
    }
}
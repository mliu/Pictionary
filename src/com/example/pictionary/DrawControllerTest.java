package com.example.pictionary;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 *  Test class for the DrawController class
 *
 *  @author Michael Liu
 *  @version Apr 30, 2014
 */
public class DrawControllerTest extends TestCase{

    private DrawController controller;
    private DrawController controller2;

    // ----------------------------------------------------------
    /**
     * Generates a new RedrawingView and DrawController
     */
    public void setUp() {
        DrawQueue<DrawObject> queue = new DrawQueue<DrawObject>();
        controller = new DrawController(queue);
        DrawObject temp = new DrawObject(0xFF000000, 10f, 10f, 1);
        DrawQueue<DrawObject> queue2 = new DrawQueue<DrawObject>();
        queue2.add(temp);
        controller2 = new DrawController(queue2);
    }

    // ----------------------------------------------------------
    /**
     * Tests the setWord() method in the DrawController class
     */
    public void testSetWord() {
        controller.setWord("test");
        assertEquals(controller.getWord(), "test");
    }

    // ----------------------------------------------------------
    /**
     * Tests the hasNext() method in the DrawController class
     */
    public void testHasNext() {
        assertEquals(controller.hasNext(), false);
        assertEquals(controller2.hasNext(), true);
    }

    // ----------------------------------------------------------
    /**
     * Tests the pop() method in the DrawController class
     */
    public void testPop() {
        assertEquals(controller2.hasNext(), true);
        controller2.pop();
        assertEquals(controller2.hasNext(), true);
    }

    // ----------------------------------------------------------
    /**
     * Tests the getScore() method in the DrawController class
     */
    public void testGetScore() {
        assertEquals(controller.getScore(), 10);
        controller2.pop();
        assertEquals(controller2.getScore(), 95);
    }
}

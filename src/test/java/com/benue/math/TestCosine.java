package com.benue.math;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TestCosine {

    @Test
    public void cosines() {

        String wegot            = Arrays.toString(Cosine.cosines(0,360, 3));
        String expected         = "[1.0, 0.9271838545667874, 0.7193398003386512, 0.4067366430758004, 0.03489949670250108, -0.3420201433256687, -0.6691306063588579, -0.8987940462991668, -0.9975640502598242, -0.9510565162951535, -0.7660444431189781, -0.46947156278589075, -0.10452846326765423, 0.2756373558169985, 0.6156614753256578, 0.8660254037844384, 0.9902680687415703]";
        //Assert.assertEquals(expected, wegot);
        System.out.println(wegot);
    }
}
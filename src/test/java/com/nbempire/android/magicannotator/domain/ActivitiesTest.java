/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios.
 * On: 19/10/2012 at 09:23hs.
 */
package com.nbempire.android.magicannotator.domain;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @author Nahuel Barrios.
 * @since 15
 */
public class ActivitiesTest {

    @Test
    public void getName_forEnumConstant_returnOnlyTypeNameWithoutPackages() throws Exception {
        Assert.assertEquals("ChooseAnnotatorActivity", Activities.CHOOSE_ANNOTATOR.getActivityTypeName());
    }
}
/*
 * ===========================================================================
 * IBM Confidential
 * iX Source Materials
 * (C) Copyright IBM Corp. 2024.
 * ===========================================================================
 */
package cc.william.bigevent.article;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cc.william.bigevent.controller.ArticleController;

/**
 * <p>
 * description
 * </p>
 *
 * @author William Wu
 * @version 1.0, 2024-01-23
 * @see
 * @since
 */

@SpringBootTest
public class ArticleControllerTest {

    @Autowired
    private ArticleController articleController;

    @Test
    void testList() {
        assertEquals("234", articleController.list("123").getData());
    }

}

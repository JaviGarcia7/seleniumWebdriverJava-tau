package blog;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.BlogPage;


public class BlogTests extends BaseTest {

    @Test
    public void testBlogPage(){
        BlogPage posts = homePage.goToBlog();
        posts.clickLink();
        posts.scrollToButton();
        posts.clickLinkedinBtn();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

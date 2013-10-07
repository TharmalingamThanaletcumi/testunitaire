package fr.renator.idegest.tu;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import fr.renater.idegest.util.UtilHtml;

public class UtilHtmlTest extends TestCase {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testTabNull(){
		UtilHtml uh = new UtilHtml();
		String arg[] = {"A", "B", "C"};
		String expectedHtmlTab =
		"<table><tr><td>A</td></tr><tr><td>B</td></tr><tr><td>C</td></tr></table>";
		assertEquals("cas général: toHtmlTab",
		expectedHtmlTab, uh.toHtmlTab(arg, arg.length));
	}

}

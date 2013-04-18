import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;


public class ChoiceGroupTest {

	@Test
	public void testChoiceGroup() {
		ChoiceGroup cg = new ChoiceGroup();
		Assert.assertEquals(0, cg.whichChoice);
		Assert.assertEquals(new ArrayList<Choice>(), cg.choices);	
	}
	
	@Test
	public void testGetChoices(){
		ChoiceGroup cg = new ChoiceGroup();
		Assert.assertEquals(new ArrayList<Choice>(), cg.getChoiceList());
	}
	
	@Test
	public void testAddChoices(){
		ChoiceGroup cg = new ChoiceGroup();
		Choice c = new Choice("blah", new ArrayList<String>(), new ArrayList<Object>(), 1);
		cg.addChoiceToGroup(c);
		Assert.assertEquals(1, cg.getChoiceList().size());
	}
	
	@Test
	public void testNextChoice(){
		ChoiceGroup cg = new ChoiceGroup();
		Assert.assertNull(cg.getNextChoice());
		Choice c = new Choice("blah", new ArrayList<String>(), new ArrayList<Object>(), 1);
		cg.addChoiceToGroup(c);
		Assert.assertEquals(c, cg.getNextChoice());
		Assert.assertEquals(c, cg.getNextChoice());
		Assert.assertEquals(c, cg.getNextChoice());
		cg = new ChoiceGroup();
		Choice b = new Choice("blah", new ArrayList<String>(), new ArrayList<Object>(), 0);
		cg.addChoiceToGroup(b);
		Assert.assertNull(cg.getNextChoice());
		cg = new ChoiceGroup();
		Choice d = new Choice("blah", new ArrayList<String>(), new ArrayList<Object>(), 0);
		cg.addChoiceToGroup(b);
		cg.addChoiceToGroup(d);
		Assert.assertEquals(d, cg.getNextChoice());
		Assert.assertNull(cg.getNextChoice());
	}

}

package a.jbehave;

import net.thucydides.jbehave.ThucydidesJUnitStories;

public class TestSuiteDebug extends ThucydidesJUnitStories {

	public TestSuiteDebug() {

		findStoriesCalled("**/consult_dictionary/PO-22InviteUsers.story");

	}
}

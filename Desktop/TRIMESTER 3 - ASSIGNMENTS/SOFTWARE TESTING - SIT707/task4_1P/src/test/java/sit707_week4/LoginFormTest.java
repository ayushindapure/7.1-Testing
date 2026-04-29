package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ayush Indapure
 */
public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "224880003";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Ayush Indapure";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	// 1. Empty username, empty password
	@Test
	public void testEmptyUsernameEmptyPassword() {
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertFalse(status.isLoginSuccess());
	}
	
	// 2. Empty username, wrong password
	@Test
	public void testEmptyUsernameWrongPassword() {
		LoginStatus status = LoginForm.login(null, "xyz");
		Assert.assertFalse(status.isLoginSuccess());
	}
	
	// 3. Empty username, correct password
	@Test
	public void testEmptyUsernameCorrectPassword() {
		LoginStatus status = LoginForm.login(null, "ahsan_pass");
		Assert.assertFalse(status.isLoginSuccess());
	}
	
	// 4. Wrong username, empty password
	@Test
	public void testWrongUsernameEmptyPassword() {
		LoginStatus status = LoginForm.login("abc", null);
		Assert.assertFalse(status.isLoginSuccess());
	}
	
	// 5. Wrong username, wrong password
	@Test
	public void testWrongUsernameWrongPassword() {
		LoginStatus status = LoginForm.login("abc", "xyz");
		Assert.assertFalse(status.isLoginSuccess());
	}
	
	// 6. Wrong username, correct password
	@Test
	public void testWrongUsernameCorrectPassword() {
		LoginStatus status = LoginForm.login("abc", "ahsan_pass");
		Assert.assertFalse(status.isLoginSuccess());
	}
	
	// 7. Correct username, empty password
	@Test
	public void testCorrectUsernameEmptyPassword() {
		LoginStatus status = LoginForm.login("ahsan", null);
		Assert.assertFalse(status.isLoginSuccess());
	}
	
	// 8. Correct username, wrong password
	@Test
	public void testCorrectUsernameWrongPassword() {
		LoginStatus status = LoginForm.login("ahsan", "xyz");
		Assert.assertFalse(status.isLoginSuccess());
	}
	
	// 9. Correct username, correct password
	@Test
	public void testCorrectUsernameCorrectPassword() {
		LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
		Assert.assertTrue(status.isLoginSuccess());
	}
	
	// ---- VALIDATION CODE TESTS ----
	
	// 10. Empty validation code
	@Test
	public void testEmptyValidationCode() {
		boolean result = LoginForm.validateCode(null);
		Assert.assertFalse(result);
	}
	
	// 11. Wrong validation code
	@Test
	public void testWrongValidationCode() {
		boolean result = LoginForm.validateCode("abcd");
		Assert.assertFalse(result);
	}
	
	// 12. Correct validation code
	@Test
	public void testCorrectValidationCode() {
		boolean result = LoginForm.validateCode("123456");
		Assert.assertTrue(result);
	}
}
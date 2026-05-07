package web.service;

import org.junit.Assert;
import org.junit.Test;

/**
 * Ayush Indapure - 224880003
 * Unit tests for LoginService
 */
public class LoginServiceUnitTest {

    @Test
    public void testValidLogin() {
        Assert.assertTrue(LoginService.login("ayush", "qwerty12", "2003-08-18"));
    }

    @Test
    public void testWrongUsername() {
        Assert.assertFalse(LoginService.login("wrong", "qwerty12", "2003-08-18"));
    }

    @Test
    public void testWrongPassword() {
        Assert.assertFalse(LoginService.login("ayush", "wrong", "2003-08-18"));
    }

    @Test
    public void testWrongDob() {
        Assert.assertFalse(LoginService.login("ayush", "qwerty12", "2001-01-01"));
    } //tried all different types of combinations

    @Test
    public void testNullValues() {
        Assert.assertFalse(LoginService.login(null, null, null));
    }

    @Test
    public void testEmptyValues() {
        Assert.assertFalse(LoginService.login("", "", ""));
    }
}
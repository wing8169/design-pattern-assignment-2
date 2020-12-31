/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagementsoftware;

/**
 *
 * @author ritz619
 */
public class MobileNoChecker {
    public static boolean MobileNoChecker(String str) {
        int x;
        if (str.isEmpty() || str.length() < 6 || str.length() > 15) {
            return false;
        }
        for (int j = 0; j < str.length(); j++) {
            x = (int) str.charAt(j);
            if (x < 48 || x > 57) {
                return false;
            }
        }
        return true;
    }
}
